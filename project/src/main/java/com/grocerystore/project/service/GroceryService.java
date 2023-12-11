package com.grocerystore.project.service;



import java.util.List;

import com.grocerystore.project.dto.GroceryDTO;
import com.grocerystore.project.exception.GroceryException;

public interface GroceryService {
	public Integer addGrocery(GroceryDTO grocery) throws GroceryException;
	public List<GroceryDTO> getAllGroceries(Integer userId) throws GroceryException;
	public Integer updateGrocery(GroceryDTO groceryDTO, Integer loggedInUserId) throws GroceryException;
	public void deleteGrocery(Integer groceryId, Integer loggedInUserId) throws GroceryException;

}
