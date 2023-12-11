package com.grocerystore.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.project.entity.Order;

@Repository
@Transactional
public interface OrderRepository  extends JpaRepository<Order, Integer>{

}
