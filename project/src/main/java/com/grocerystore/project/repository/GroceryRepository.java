package com.grocerystore.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.project.entity.Grocery;
import com.grocerystore.project.entity.User;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

	public List<Grocery> findByUser(User userId);
	@Transactional
	@Modifying
	@Query("Update Grocery G set G.name = ?2, G.cost = ?4, G.availableQuantity = ?3 where G.groceryId = ?1")
	public Integer updateGrocery(Integer id, String name, Integer quantity, Double cost);
}
