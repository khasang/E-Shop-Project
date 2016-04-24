package com.eshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "BASKET")
public class Basket {	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "PRODUCT_FK"))
	private Product product;
	
	@OneToMany(mappedBy="basket", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<LogOrders> logOrders = new ArrayList<>();
	
	@Column(name = "CNT")
	private int count;

	@Formula("(select p.price*b.cnt from Basket b, Product p where p.id = b.product_id and p.id = product_id)")
	private int priceTotal;

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

	public List<LogOrders> getLogOrders() {
		return logOrders;
	}

	public void setLogOrders(List<LogOrders> logOrders) {
		this.logOrders = logOrders;
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
}
