package com.eshop.entity;

import java.util.ArrayList;
import java.util.List;

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

	
	@OneToMany(mappedBy="status", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<LogOrders> logOrders = new ArrayList<>();
	
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

	public List<LogOrders> getLogOrders() {
		return logOrders;
	}

	public void setLogOrders(List<LogOrders> logOrders) {
		this.logOrders = logOrders;
	}	
}
