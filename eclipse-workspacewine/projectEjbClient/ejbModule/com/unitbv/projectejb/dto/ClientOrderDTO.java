package com.unitbv.projectejb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ClientOrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String orderNo;
	
	private Date date;
	
	private ClientB2CDTO clientB2C;
	
	private List<Order_ItemDTO> orderItems;

	public ClientOrderDTO() {
		super();
	}

	public ClientOrderDTO(String orderNo, Date date, ClientB2CDTO clientB2C, List<Order_ItemDTO> orderItems) {
		super();
		this.orderNo = orderNo;
		this.date = date;
		this.clientB2C = clientB2C;
		this.setOrderItems(orderItems);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ClientB2CDTO getClientB2C() {
		return clientB2C;
	}

	public void setClientB2C(ClientB2CDTO clientB2C) {
		this.clientB2C = clientB2C;
	}

	public List<Order_ItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Order_ItemDTO> orderItems) {
		this.orderItems = orderItems;
	}
}
