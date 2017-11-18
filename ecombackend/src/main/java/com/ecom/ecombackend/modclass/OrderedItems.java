package com.ecom.ecombackend.modclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderedItemsId;
	private double orderedItemsTotalPrice;
	private int orderedItemsTotalQuantity;

	@ManyToOne
	private Orders orders;

	@OneToOne
	private Product product;

	private double unitPrice;

	public int getOrderedItemsId() {
		return orderedItemsId;
	}

	public void setOrderedItemsId(int orderedItemsId) {
		this.orderedItemsId = orderedItemsId;
	}

	public double getOrderedItemsTotalPrice() {
		return orderedItemsTotalPrice;
	}

	public void setOrderedItemsTotalPrice(double orderedItemsTotalPrice) {
		this.orderedItemsTotalPrice = orderedItemsTotalPrice;
	}

	public int getOrderedItemsTotalQuantity() {
		return orderedItemsTotalQuantity;
	}

	public void setOrderedItemsTotalQuantity(int orderedItemsTotalQuantity) {
		this.orderedItemsTotalQuantity = orderedItemsTotalQuantity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
