package com.unitbv.projectejb.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PromoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private Date startDate;
	
	private Date endDate;
	
	private int discount;
	
	public PromoDTO() {
		super();
	}

	public PromoDTO(Date startDate, Date endDate, int discount, Stock_SupplierDTO stockSupplier) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
		this.stockSupplier = stockSupplier;
	}

	@ManyToOne
	@JoinColumn(name="STOCKSUPPLIERID")
	private Stock_SupplierDTO stockSupplier;

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

	public Stock_SupplierDTO getStockSupplier() {
		return stockSupplier;
	}

	public void setStockSupplier(Stock_SupplierDTO stockSupplier) {
		this.stockSupplier = stockSupplier;
	}
}
