package com.eshop.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOG_ORDERS")
public class LogOrders {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
    @JoinColumn(name="basket_id", foreignKey = @ForeignKey(name = "BASKET_FK"))  	
	private Basket basket;

	@Column(name = "DATE", columnDefinition = "DATETIME DEFAULT NOW", insertable=false)
	private Timestamp timestamp;

	@OneToOne
	@JoinColumn(name = "STATUS", foreignKey = @ForeignKey(name = "STATUS_FK"))
	private Status status;

	public LogOrders() {
	}

	public int getId() {
		return id;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
