package com.eshop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WISH")
public class Wish {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "PRODUCT_FK"))
	private Product product;

	@ManyToOne
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "USER_FK") )
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
