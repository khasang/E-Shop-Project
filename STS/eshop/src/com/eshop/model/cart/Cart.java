package com.eshop.model.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.eshop.entity.Product;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
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
		} else {
			updateItem(product, item.getQuantity() + 1);
		}
	}

	public void deleteItem(Product product) {
		Item item = findItemByProductId(product.getId());
		if (item != null) {
			items.remove(item);
		}
	}

	public Item updateItem(Product product, int quantity) {
		Item item = findItemByProductId(product.getId());
		if (item != null) {
			item.setQuantity(quantity);
		}
		return item;
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
