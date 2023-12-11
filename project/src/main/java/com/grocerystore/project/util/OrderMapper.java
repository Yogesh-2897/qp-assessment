package com.grocerystore.project.util;



import com.grocerystore.project.dto.OrderDTO;
import com.grocerystore.project.entity.Order;

public class OrderMapper {
	public static Order convertOrderDTOToOrder(OrderDTO order) {
		if (order != null) {
			Order o = new Order();
			o.setStatus(order.getStatus());
			o.setTotalCost(order.getTotalCost());
			return o;
		}
		return null;

	}
}
