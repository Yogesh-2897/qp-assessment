package com.grocerystore.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocerystore.project.entity.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{
	public User findUserByUserName(String username);
}
