package com.grocerystore.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.project.constants.GroceryConstants;
import com.grocerystore.project.constants.RegistrationConstants;
import com.grocerystore.project.dto.GroceryDTO;
import com.grocerystore.project.entity.Grocery;
import com.grocerystore.project.entity.User;
import com.grocerystore.project.exception.GroceryException;
import com.grocerystore.project.repository.GroceryRepository;
import com.grocerystore.project.repository.OrderDetailsRepository;
import com.grocerystore.project.repository.RegistrationRepository;
import com.grocerystore.project.util.GroceryMapper;

@Service
@Transactional
public class GroceryServiceImpl implements GroceryService {
	@Autowired
	GroceryRepository groceryRepository;
	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	OrderDetailsRepository detailsRepository;

	@Override
	public Integer addGrocery(GroceryDTO grocery) throws GroceryException {
		User u = null;
		if (grocery.getUserId() != null) {
			u = registrationRepository.findById(grocery.getUserId()).orElse(null);
		}
		if (u == null) {
			throw new GroceryException(RegistrationConstants.USER_NOT_AVAILABLE,
					RegistrationConstants.USER_NOT_AVAILABLE_CODE);
		}
		if (!RegistrationConstants.ADMIN.equalsIgnoreCase(u.getUserType())) {
			throw new GroceryException(RegistrationConstants.USER_UNAUTHORIZED,
					RegistrationConstants.USER_UNAUTHORIZED_CODE);
		}
		Grocery grocery2 = new Grocery();
		grocery2.setName(grocery.getName());
		grocery2.setCost(grocery.getCost());
		grocery2.setAvailableQuantity(grocery.getAvailableQuantity());
		grocery2.setUser(u);
		return groceryRepository.save(grocery2).getGroceryId();
	}

	@Override
	public List<GroceryDTO> getAllGroceries(Integer userId) throws GroceryException {
		List<GroceryDTO> groceryList = new ArrayList<>();
		User u = null;
		if (userId != null) {
			u = registrationRepository.findById(userId).orElse(null);
		}
		if (u == null) {
			throw new GroceryException(RegistrationConstants.USER_NOT_AVAILABLE,
					RegistrationConstants.USER_NOT_AVAILABLE_CODE);
		}
		List<Grocery> groceries = groceryRepository.findByUser(u);
		for (Grocery g : groceries) {
			groceryList.add(GroceryMapper.covertGroceryToGroceryDTO(g));
		}
		return groceryList;
	}

	@Override
	public Integer updateGrocery(GroceryDTO groceryDTO, Integer loggedInUserId) throws GroceryException {
		User u = null;
		if (loggedInUserId != null) {
			u = registrationRepository.findById(loggedInUserId).orElse(null);
		}
		if (u == null) {
			throw new GroceryException(RegistrationConstants.USER_NOT_AVAILABLE,
					RegistrationConstants.USER_NOT_AVAILABLE_CODE);
		}
		if (!RegistrationConstants.ADMIN.equalsIgnoreCase(u.getUserType())) {
			throw new GroceryException(RegistrationConstants.USER_UNAUTHORIZED,
					RegistrationConstants.USER_UNAUTHORIZED_CODE);
		}
		Grocery g = groceryRepository.findById(groceryDTO.getGroceryId()).orElse(null);
		if (g == null) {
			throw new GroceryException(GroceryConstants.GROCERY_NOT_AVAILABLE,
					GroceryConstants.GROCERY_NOT_AVAILABLE_CODE);
		}
		if (g.getUser().getUserId() != loggedInUserId) {
			throw new GroceryException(RegistrationConstants.UNAUTHORIZED_USER,
					RegistrationConstants.UNAUTHORIZED_USER_CODE);
		}
		Integer grocery = groceryRepository.updateGrocery(groceryDTO.getGroceryId(), groceryDTO.getName(),
				groceryDTO.getAvailableQuantity(), groceryDTO.getCost());

		return grocery;
	}

	@Override
	@Modifying
	public void deleteGrocery(Integer groceryId, Integer loggedInUserId) throws GroceryException {
		User u = null;
		if (loggedInUserId != null) {
			u = registrationRepository.findById(loggedInUserId).orElse(null);
		}
		if (u == null) {
			throw new GroceryException(RegistrationConstants.USER_NOT_AVAILABLE,
					RegistrationConstants.USER_NOT_AVAILABLE_CODE);
		}
		if (!RegistrationConstants.ADMIN.equalsIgnoreCase(u.getUserType())) {
			throw new GroceryException(RegistrationConstants.USER_UNAUTHORIZED,
					RegistrationConstants.USER_UNAUTHORIZED_CODE);
		}
		Grocery g = groceryRepository.findById(groceryId).orElse(null);
		
		if (g == null) {
			throw new GroceryException(GroceryConstants.GROCERY_NOT_AVAILABLE,
					GroceryConstants.GROCERY_NOT_AVAILABLE_CODE);
		}
		if (g.getUser().getUserId() != loggedInUserId) {
			throw new GroceryException(RegistrationConstants.UNAUTHORIZED_USER,
					RegistrationConstants.UNAUTHORIZED_USER_CODE);
		}
		//detailsRepository.updateOrderDetails(g);
		groceryRepository.deleteById(groceryId);

	}

}
