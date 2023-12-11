package com.grocerystore.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.project.constants.GroceryConstants;
import com.grocerystore.project.constants.OrderConstants;
import com.grocerystore.project.constants.RegistrationConstants;
import com.grocerystore.project.dto.GroceryDTO;
import com.grocerystore.project.dto.OrderDTO;
import com.grocerystore.project.dto.OrderDetailsDTO;
import com.grocerystore.project.entity.Grocery;
import com.grocerystore.project.entity.Order;
import com.grocerystore.project.entity.OrderDetails;
import com.grocerystore.project.entity.User;
import com.grocerystore.project.exception.GroceryException;
import com.grocerystore.project.repository.GroceryRepository;
import com.grocerystore.project.repository.OrderRepository;
import com.grocerystore.project.repository.RegistrationRepository;
import com.grocerystore.project.util.GroceryMapper;
import com.grocerystore.project.util.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	GroceryRepository groceryRepository;

	@Override
	@Transactional
	public Integer bookOrder(OrderDTO order) throws GroceryException {
		User u = null;
		if (order.getUserId() != null) {
			u = registrationRepository.findById(order.getUserId()).orElse(null);
		}
		if (u == null) {
			throw new GroceryException(RegistrationConstants.USER_NOT_AVAILABLE,
					RegistrationConstants.USER_NOT_AVAILABLE_CODE);
		}
		Order o = OrderMapper.convertOrderDTOToOrder(order);
		o.setUser(u);
		List<OrderDetails> list = new ArrayList<>();
		Double totalCost = 0.0D;
		for (OrderDetailsDTO d : order.getOrderItems()) {
			OrderDetails orderDetails = new OrderDetails();
			Grocery g = groceryRepository.findById(d.getGroceryId())
					.orElseThrow(() -> new GroceryException(GroceryConstants.GROCERY_NOT_AVAILABLE,
							GroceryConstants.GROCERY_NOT_AVAILABLE_CODE));
			if (g.getAvailableQuantity() < d.getQuantity()) {
				throw new GroceryException(GroceryConstants.GROCERY_OUT_OF_STOCK,
						GroceryConstants.GROCERY_NOT_AVAILABLE_CODE);
			}
			groceryRepository.updateGrocery(g.getGroceryId(), g.getName(), g.getAvailableQuantity() - d.getQuantity(),
					g.getCost());
			orderDetails.setGrocery(g);
			orderDetails.setQuantity(d.getQuantity());
			orderDetails.setCost(g.getCost() * d.getQuantity());
			totalCost += orderDetails.getCost();
			list.add(orderDetails);
		}
		o.setOrderItems(list);
		o.setStatus(OrderConstants.ORDER_PLACED);
		o.setTotalCost(totalCost);
		Order order1 = orderRepository.save(o);
		return order1.getOrderId();
	}

	@Override
	public List<GroceryDTO> getGroceryList() throws GroceryException {
		List<Grocery> groceryList = groceryRepository.findAll();
		List<GroceryDTO> grocery = new ArrayList<>();
		if (groceryList != null && !groceryList.isEmpty()) {
			for (Grocery g : groceryList) {
				GroceryDTO groceryDTO = new GroceryDTO();
				groceryDTO = GroceryMapper.covertGroceryToGroceryDTO(g);
				grocery.add(groceryDTO);
			}
		}
		return grocery;
	}

}
