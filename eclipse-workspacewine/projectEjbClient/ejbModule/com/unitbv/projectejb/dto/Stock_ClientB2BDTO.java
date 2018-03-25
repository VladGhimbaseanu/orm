package com.unitbv.projectejb.dto;

import java.io.Serializable;
import java.util.List;

public class Stock_ClientB2BDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private int price;
	
	private int quantity;
	
	private boolean active;
	
	private int limitQuanity;
	
	private ClientB2BDTO clientB2B;
	
	private List<Order_ItemDTO> orderItems;
	
	private List<Stock_SupplierDTO> stockSuppliers;

	public Stock_ClientB2BDTO() {
		super();
	}

	public Stock_ClientB2BDTO(int price, int quantity, boolean active, int limitQuanity, ClientB2BDTO clientB2B,
			List<Order_ItemDTO> orderItems, List<Stock_SupplierDTO> stockSuppliers) {
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

	public ClientB2BDTO getClientB2B() {
		return clientB2B;
	}

	public void setClientB2B(ClientB2BDTO clientB2B) {
		this.clientB2B = clientB2B;
	}

	public List<Order_ItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Order_ItemDTO> orderItems) {
		this.orderItems = orderItems;
	}

	public List<Stock_SupplierDTO> getStockSuppliers() {
		return stockSuppliers;
	}

	public void setStockSuppliers(List<Stock_SupplierDTO> stockSuppliers) {
		this.stockSuppliers = stockSuppliers;
	}

}
