package com.unitbv.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ClientOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String orderNo;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="CLIENTB2CID")
	private ClientB2C clientB2C;
	
	@OneToMany(mappedBy="order")
	private List<Order_Item> orderItems;

	public ClientOrder() {
		super();
	}

	public ClientOrder(String orderNo, Date date, ClientB2C clientB2C, List<Order_Item> orderItems) {
		super();
		this.orderNo = orderNo;
		this.date = date;
		this.clientB2C = clientB2C;
		this.orderItems = orderItems;
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

	public ClientB2C getClientB2C() {
		return clientB2C;
	}

	public void setClientB2C(ClientB2C clientB2C) {
		this.clientB2C = clientB2C;
	}

	public List<Order_Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Order_Item> orderItems) {
		this.orderItems = orderItems;
	}
}
