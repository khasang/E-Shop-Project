package com.eshop.model.cart;

import java.util.ArrayList;
import java.util.List;

import com.eshop.entity.Product;

public class Cart {
	private List<Item> items = new ArrayList<>();

	public Cart() {
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void addtem(Product product) {
		Item item = findItemByProductId(product.getId());
		if (item == null) {
			items.add(new Item(product, 1));
		}
	}

	public void deleteItem(Product product) {
		Item item = findItemByProductId(product.getId());
		if (item != null) {
			items.remove(item);
		}
	}

	public void updateItem(Product product, int quantity) {
		Item item = findItemByProductId(product.getId());
		if (item != null) {
			item.setQuantity(quantity);
		}
	}

	public Item findItemByProductId(int productId) {
		for (int i = 0; i < items.size(); i++) {
			if (productId == items.get(i).getProduct().getId()) {
				return items.get(i);
			}
		}
		return null;
	}

	public int getQuantityTotal() {
		int quantity = 0;
		for (Item item : items) {
			quantity += item.getQuantity();
		}
		return quantity;
	}

	public int getAmountTotal() {
		int amountTotal = 0;
		for (Item item : items) {
			amountTotal += item.getAmount();
		}
		return amountTotal;
	}
}
