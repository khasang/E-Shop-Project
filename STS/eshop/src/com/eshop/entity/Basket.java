package com.eshop.entity;

import javax.persistence.*;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "BASKET")
public class Basket {	
	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "PRODUCT_FK") )
	private Product product;

	@Column(name = "CNT")
	private int count;

	@Formula("(select p.price*b.cnt from Basket b, Product p where p.id = b.product_id and p.id = product_id)")
	private int priceTotal;

	@OneToOne
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "USER_FK") )
	private User user;

	@OneToOne
	@JoinColumn(name = "STATUS_ID", foreignKey = @ForeignKey(name = "STATUS_FK") )
	private Status status;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(int priceTotal) {
		this.priceTotal = priceTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
