package com.eshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 8221363237645457476L;
	@Id
	private int id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_description")
	private String productDescription;
	@ManyToOne()
	@JoinColumn(name = "order_id")
	private Order inOrder;

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public Order getInOrder() {
		return inOrder;
	}

	public void setInOrder(Order inOrder) {
		this.inOrder = inOrder;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
}
