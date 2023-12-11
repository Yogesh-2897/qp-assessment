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
@Table(name = "ORDER_DETAILS")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderDetailsId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="groceryId")
	private Grocery grocery;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "cost")
	private Double cost;
	@Column(name = "ORDER_ID")
	private Integer orderId;
}
