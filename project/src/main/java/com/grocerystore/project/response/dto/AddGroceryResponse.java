package com.grocerystore.project.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddGroceryResponse extends CommonResponse{
	private Integer groceryId;
}
