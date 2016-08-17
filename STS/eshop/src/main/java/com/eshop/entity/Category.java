package com.eshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;
	
	@OrderBy("name")
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<Product> product = new ArrayList<>();
		
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
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
