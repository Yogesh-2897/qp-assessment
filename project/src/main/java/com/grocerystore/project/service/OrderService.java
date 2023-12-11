package com.grocerystore.project.service;

import java.util.List;

import com.grocerystore.project.dto.GroceryDTO;
import com.grocerystore.project.dto.OrderDTO;
import com.grocerystore.project.exception.GroceryException;

public interface OrderService {
	public Integer bookOrder(OrderDTO order) throws GroceryException;
	public List<GroceryDTO> getGroceryList() throws GroceryException;

}
