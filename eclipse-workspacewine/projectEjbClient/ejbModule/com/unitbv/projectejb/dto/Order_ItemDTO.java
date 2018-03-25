package com.unitbv.projectejb.dto;

import java.io.Serializable;

public class Order_ItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private int quantity;
	
	private int price;
	
	private Stock_ClientB2BDTO stockClientB2B;
	
	private ClientOrderDTO order;
	
	public Order_ItemDTO() {
		super();
	}

	public Order_ItemDTO(int quantity, int price, Stock_ClientB2BDTO stockClientB2B, ClientOrderDTO order) {
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

	public Stock_ClientB2BDTO getStockClientB2B() {
		return stockClientB2B;
	}

	public void setStockClientB2B(Stock_ClientB2BDTO stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
	}

	public ClientOrderDTO getOrder() {
		return order;
	}

	public void setOrder(ClientOrderDTO order) {
		this.order = order;
	}
}
