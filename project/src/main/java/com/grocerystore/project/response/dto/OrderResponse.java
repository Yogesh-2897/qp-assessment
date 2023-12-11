package com.grocerystore.project.response.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse extends CommonResponse{
	private Integer orderId;
}
