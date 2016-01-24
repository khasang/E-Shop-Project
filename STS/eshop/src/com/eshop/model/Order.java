package com.eshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 3519197382852486774L;
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "order_name", nullable = false)
	@NotNull
	private String orderName;
	@OneToMany
	@Column(name = "product_id")
	private List<Product> products;

	public Order() {
		super();
	}

	public Order(String orderName, User user) {
		this.orderName = orderName;
		this.user = user;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProductsInOrder() {
		return products;
	}

	public void setProductsInOrder(List<Product> products) {
		this.products = products;
	}
}
