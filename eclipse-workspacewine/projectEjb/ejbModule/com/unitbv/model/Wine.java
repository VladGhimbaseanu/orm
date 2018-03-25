package com.unitbv.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import winetype.WineType;

@Entity
public class Wine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	private String variety;
	
	private WineType type;
	
	@Temporal(TemporalType.DATE)
	private Date year;
	
	@OneToMany(mappedBy="wine")
	private List<Stock_Supplier> stockSupplier;

	public Wine() {
		super();
	}

	public Wine(String name, String description, String variety, WineType type, Date year,
			List<Stock_Supplier> stockSupplier) {
		super();
		this.name = name;
		this.description = description;
		this.variety = variety;
		this.type = type;
		this.year = year;
		this.stockSupplier = stockSupplier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public WineType getType() {
		return type;
	}

	public void setType(WineType type) {
		this.type = type;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public List<Stock_Supplier> getStockSupplier() {
		return stockSupplier;
	}

	public void setStockSupplier(List<Stock_Supplier> stockSupplier) {
		this.stockSupplier = stockSupplier;
	}
}
