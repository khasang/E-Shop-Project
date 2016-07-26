package com.eshop.model.cart;

public class UpdatedItem {
  private int productId;
  private int newQuantity;
  
public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getNewQuantity() {
	return newQuantity;
  }
  
  public void setNewQuantity(int newQuantity) {
	this.newQuantity = newQuantity;
  }  
}
