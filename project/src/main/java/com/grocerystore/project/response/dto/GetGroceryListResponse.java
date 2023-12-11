package com.grocerystore.project.response.dto;

import java.util.List;

import com.grocerystore.project.dto.GroceryDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetGroceryListResponse extends CommonResponse {
	private List<GroceryDTO> groceryList;

}
