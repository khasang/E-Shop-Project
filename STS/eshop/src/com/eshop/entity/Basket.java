package com.eshop.entity;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="BASKET")
public class Basket {
@Id
@GeneratedValue
private int id;

@Column(name="PRODUCT_ID")
private int productId;

@Column(name="COUNT")
private int count;

@Column(name="PRICE_TOTAL")
private BigDecimal priceTotal;

@Column(name="USER_ID")
private int userId;

@Column(name="status")
private int status;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public BigDecimal getPriceTotal() {
	return priceTotal;
}

public void setPriceTotal(BigDecimal priceTotal) {
	this.priceTotal = priceTotal;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}
}
