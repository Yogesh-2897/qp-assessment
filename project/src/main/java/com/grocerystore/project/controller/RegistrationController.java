package com.grocerystore.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocerystore.project.constants.RegistrationConstants;
import com.grocerystore.project.dto.UserDTO;
import com.grocerystore.project.exception.GroceryException;
import com.grocerystore.project.response.dto.CommonResponse;
import com.grocerystore.project.service.RegistrationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	
	@Operation(summary = "Registration",
			description="Registration")
	@PostMapping("/create")
	public ResponseEntity<CommonResponse> createUser(@RequestBody UserDTO user) throws GroceryException{
		String message = registrationService.doRegistration(user);
		CommonResponse response = new CommonResponse();
		response.setCode(RegistrationConstants.SUCCESS_CODE);
		response.setMessage(message);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
}
