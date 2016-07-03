package com.eshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
	public Product() {
	}
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "IMAGEURL")
	private String imageURL;

	@OneToMany(mappedBy="product", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Basket> basket = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID", foreignKey = @ForeignKey(name = "CATEGORY_FK"))  
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public List<Basket> getBasket() {
		return basket;
	}

	public void setBasket(List<Basket> basket) {
		this.basket = basket;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
