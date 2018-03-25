package com.unitbv.projectejb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import winetype.WineType;

public class WineDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String name;
	
	private String description;
	
	private String variety;
	
	private WineType type;
	
	private Date year;
	
	private List<Stock_SupplierDTO> stockSupplier;

	public WineDTO() {
		super();
	}

	public WineDTO(String name, String description, String variety, WineType type, Date year,
			List<Stock_SupplierDTO> stockSupplier) {
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

	public List<Stock_SupplierDTO> getStockSupplier() {
		return stockSupplier;
	}

	public void setStockSupplier(List<Stock_SupplierDTO> stockSupplier) {
		this.stockSupplier = stockSupplier;
	}
}
