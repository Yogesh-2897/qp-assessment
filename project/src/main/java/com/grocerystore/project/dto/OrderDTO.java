package com.grocerystore.project.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	private Integer orderId;
	private Double totalCost;
	private String status;
	private List<OrderDetailsDTO> orderItems;
	private Integer userId;
}
