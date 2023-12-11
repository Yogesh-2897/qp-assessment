package com.grocerystore.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerystore.project.constants.RegistrationConstants;
import com.grocerystore.project.dto.UserDTO;
import com.grocerystore.project.entity.User;
import com.grocerystore.project.exception.GroceryException;
import com.grocerystore.project.repository.RegistrationRepository;
import com.grocerystore.project.util.RegistrationMapper;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationRepository registrationRepository;

	@Override
	public String doRegistration(UserDTO user) throws GroceryException {
		User temp = registrationRepository.findUserByUserName(user.getUserName());
		if (temp != null) {
			throw new GroceryException(RegistrationConstants.REGISTRATION_ERROR_USER_EXISTS,
					RegistrationConstants.REGISTRATION_ERROR_CODE);
		}
		temp = RegistrationMapper.convertuserDtoToEntity(user);
		if (temp != null) {
			User created = registrationRepository.save(temp);
			if (created != null) {
				return RegistrationConstants.REGISTRATION_USER_CREATION_SUCCESS;
			}
		}
		return null;
	}

}
