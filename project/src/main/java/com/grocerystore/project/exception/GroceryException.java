package com.grocerystore.project.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroceryException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1128287733912076268L;
	private String errorCode;
	public GroceryException( String message, String errorCode) {
		super(message);	
		this.errorCode = errorCode;	
	}


}
