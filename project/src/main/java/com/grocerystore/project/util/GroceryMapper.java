package com.grocerystore.project.util;

import com.grocerystore.project.dto.GroceryDTO;
import com.grocerystore.project.entity.Grocery;

public class GroceryMapper {
	public static GroceryDTO covertGroceryToGroceryDTO(Grocery g) {
		GroceryDTO grocery = new GroceryDTO();
		grocery.setGroceryId(g.getGroceryId());
		grocery.setCost(g.getCost());
		grocery.setAvailableQuantity(g.getAvailableQuantity());
		grocery.setName(g.getName());
		grocery.setUserId(g.getUser()!=null?g.getUser().getUserId():null);
		return grocery;
	}
}
