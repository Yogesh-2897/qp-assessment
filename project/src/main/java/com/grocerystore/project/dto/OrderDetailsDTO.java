package com.grocerystore.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {

	private Integer orderDetailsId;
	private Integer groceryId;
	private Double cost;
	private Integer quantity;
}
