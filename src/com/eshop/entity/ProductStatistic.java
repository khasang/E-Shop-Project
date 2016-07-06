/*package com.eshop.entity;


import javax.persistence.*;

@Entity
@Table(name = "ProductStatistic")
public class ProductStatistic {
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "PRODUCT_FK") )
	private Product product;
	
	private int viewCount;
	
	
	public ProductStatistic(Product product, int viewCount) {
		this.product = product;
		this.viewCount = viewCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}*/