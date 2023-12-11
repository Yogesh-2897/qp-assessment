package com.grocerystore.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocerystore.project.constants.GroceryConstants;
import com.grocerystore.project.constants.OrderConstants;
import com.grocerystore.project.constants.RegistrationConstants;
import com.grocerystore.project.dto.GroceryDTO;
import com.grocerystore.project.dto.OrderDTO;
import com.grocerystore.project.exception.GroceryException;
import com.grocerystore.project.response.dto.GetGroceryListResponse;
import com.grocerystore.project.response.dto.OrderResponse;
import com.grocerystore.project.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/place")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderDTO  order) throws GroceryException{ 
		Integer orderId = orderService.bookOrder(order);
		OrderResponse response = new OrderResponse();
		response.setMessage(OrderConstants.ORDER_SUCCESS_MESSAGE);
		response.setCode(RegistrationConstants.SUCCESS_CODE);
		response.setOrderId(orderId);
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}
	@GetMapping("/grocery/all")
	public ResponseEntity<GetGroceryListResponse> getAllGroceries() throws GroceryException{ 
		List<GroceryDTO> groceryList  = orderService.getGroceryList();
		GetGroceryListResponse response = new GetGroceryListResponse();
		response.setGroceryList(groceryList);
		response.setMessage(GroceryConstants.GROCERY_LIST_SUCCESS_MESSAGE);
		response.setCode(RegistrationConstants.SUCCESS_CODE);
		return new ResponseEntity<GetGroceryListResponse>(response, HttpStatus.OK);
	}
}
