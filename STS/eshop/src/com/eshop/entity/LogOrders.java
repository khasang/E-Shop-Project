package com.eshop.entity;

import java.util.Calendar;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eshop.model.OrderStatus;

@Entity
@Table(name = "LOG_ORDERS")
public class LogOrders {
	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	@JoinColumn(name = "BASKET_ID", foreignKey = @ForeignKey(name = "BASKET_ID_FK") )
	private Basket basketId;

	@Column(name = "DATE")
	private Timestamp timestamp;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private OrderStatus status;

	public LogOrders(Basket basket) {
		basketId = basket;
		status = OrderStatus.PAID;
		timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	public int getId() {
		return id;
	}

	public Basket getBasketId() {
		return basketId;
	}

	public void setBasketId(Basket basketId) {
		this.basketId = basketId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
