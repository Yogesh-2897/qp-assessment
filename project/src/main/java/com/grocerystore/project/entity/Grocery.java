package com.grocerystore.project.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="GROCERY")
public class Grocery {
	@Id
	@Column(name="GROCERY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer groceryId;
	@Column(name="GROCERY_NAME")
	private String name;
	@Column(name="GROCERY_COST")
	private Double cost;
	@Column(name="GROCERY_QUANTITY")
	private Integer availableQuantity;
	@ManyToOne(cascade =CascadeType.DETACH)
	@JoinColumn(name="USER_ID")
	private User user;
}
