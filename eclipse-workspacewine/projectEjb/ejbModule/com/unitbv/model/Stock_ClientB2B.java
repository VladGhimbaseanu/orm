package com.unitbv.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Stock_ClientB2B implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int price;
	
	private int quantity;

	private boolean active;
	
	private int limitQuanity;
	
	@ManyToOne
	@JoinColumn(name="CLIENTB2BID")
	private ClientB2B clientB2B;
	
	@OneToMany(mappedBy="stockClientB2B")
	private List<Order_Item> orderItems;
	
	@OneToMany(mappedBy="stockClientB2B")
	private List<Stock_Supplier> stockSuppliers;

	public Stock_ClientB2B() {
		super();
	}

	public Stock_ClientB2B(int price, int quantity, boolean active, int limitQuanity, ClientB2B clientB2B,
			List<Order_Item> orderItems, List<Stock_Supplier> stockSuppliers) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.active = active;
		this.limitQuanity = limitQuanity;
		this.clientB2B = clientB2B;
		this.orderItems = orderItems;
		this.stockSuppliers = stockSuppliers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getLimitQuanity() {
		return limitQuanity;
	}

	public void setLimitQuanity(int limitQuanity) {
		this.limitQuanity = limitQuanity;
	}

	public ClientB2B getClientB2B() {
		return clientB2B;
	}

	public void setClientB2B(ClientB2B clientB2B) {
		this.clientB2B = clientB2B;
	}

	public List<Order_Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Order_Item> orderItems) {
		this.orderItems = orderItems;
	}

	public List<Stock_Supplier> getStockSuppliers() {
		return stockSuppliers;
	}

	public void setStockSuppliers(List<Stock_Supplier> stockSuppliers) {
		this.stockSuppliers = stockSuppliers;
	}
}
