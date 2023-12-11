package com.grocerystore.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroceryDTO {
	private Integer groceryId;
	private String name;
	private Double cost;
	private Integer availableQuantity;
	private Integer userId;
}
