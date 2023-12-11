package com.grocerystore.project.service;

import com.grocerystore.project.dto.UserDTO;
import com.grocerystore.project.exception.GroceryException;

public interface RegistrationService {
	public String doRegistration(UserDTO user) throws GroceryException; 
}
