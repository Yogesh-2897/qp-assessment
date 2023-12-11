package com.grocerystore.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.grocerystore.project.response.dto.CommonResponse;

@RestControllerAdvice
public class ExceptionAdvice {
	 @ExceptionHandler(GroceryException.class)
		public ResponseEntity<CommonResponse> infyBankExceptionHandler(GroceryException exception){
		  	return new ResponseEntity<>(new CommonResponse("404",exception.getMessage()), HttpStatus.NOT_FOUND);	
}
}
