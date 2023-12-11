package com.grocerystore.project.util;


import com.grocerystore.project.dto.UserDTO;
import com.grocerystore.project.entity.User;

public class RegistrationMapper {
	public static User convertuserDtoToEntity(UserDTO user) {
		if (user != null) {
			User u = new User();
			u.setDateOfReg(user.getDateOfReg());
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			u.setPassword(user.getPassword());
			u.setPhoneNumber(user.getPhoneNumber());
			u.setStoreName(user.getStoreName());
			u.setUserName(user.getUserName());
			u.setUserType(user.getUserType());
			return u;
		}
		return null;
	}
}
