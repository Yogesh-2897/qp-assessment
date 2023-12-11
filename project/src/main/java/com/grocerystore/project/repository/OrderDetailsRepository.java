package com.grocerystore.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.project.entity.Grocery;
import com.grocerystore.project.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{
	/*
	 * @Modifying
	 * 
	 * @Transactional public Integer updateOrderDetails(Grocery grocery);
	 */
}
