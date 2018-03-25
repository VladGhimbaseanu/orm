package com.unitbv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.*;

@Entity
public class Promo  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private int discount;
	
	@ManyToOne
	@JoinColumn(name="STOCKSUPPLIERID")
	private Stock_Supplier stockSupplier;

	public Promo() {
		super();
	}

	public Promo(Date startDate, Date endDate, int discount, Stock_Supplier stockSupplier) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
		this.stockSupplier = stockSupplier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Stock_Supplier getStockSupplier() {
		return stockSupplier;
	}

	public void setStockSupplier(Stock_Supplier stockSupplier) {
		this.stockSupplier = stockSupplier;
	}
}
