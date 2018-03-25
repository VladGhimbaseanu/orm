package com.unitbv.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
public class Order_Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	private int price;
	
	@ManyToOne
	@JoinColumn(name="StockClientB2BID")
	private Stock_ClientB2B stockClientB2B;
	
	@ManyToOne
	private ClientOrder order;

	public Order_Item() {
		super();
	}

	public Order_Item(int quantity, int price, Stock_ClientB2B stockClientB2B, ClientOrder order) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.stockClientB2B = stockClientB2B;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Stock_ClientB2B getStockClientB2B() {
		return stockClientB2B;
	}

	public void setStockClientB2B(Stock_ClientB2B stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
	}

	public ClientOrder getOrder() {
		return order;
	}

	public void setOrder(ClientOrder order) {
		this.order = order;
	}
}
