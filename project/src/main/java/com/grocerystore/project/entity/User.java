package com.grocerystore.project.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="STORE_NAME")
	private String storeName;
	@Column(name="USER_TYPE")
	private String userType;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="DATE_OF_REGISTRATION")
	private Date dateOfReg;
}
