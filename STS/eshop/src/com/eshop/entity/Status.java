package com.eshop.entity;

import javax.persistence.*;

import com.eshop.model.OrderStatus;

@Entity
@Table(name = "STATUS")
public class Status {

	@Id
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_CODE")
	private OrderStatus statusCode;
	
	@Column(name = "NAME")
	private String name;
	
	public OrderStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(OrderStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
