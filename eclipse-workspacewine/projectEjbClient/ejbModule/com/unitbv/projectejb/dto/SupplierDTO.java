package com.unitbv.projectejb.dto;

import java.io.Serializable;
import java.util.List;

public class SupplierDTO extends PlatformUserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nameWineCellar;
	
	private Boolean visibility;
	
	private int Age;

	private List<Stock_SupplierDTO> stockSuppliers;
	
	public SupplierDTO() {
		super();
	}

	public SupplierDTO(String nameWineCellar, Boolean visibility, int age, List<Stock_SupplierDTO> stockSuppliers) {
		super();
		this.nameWineCellar = nameWineCellar;
		this.visibility = visibility;
		Age = age;
		this.stockSuppliers = stockSuppliers;
	}

	public String getNameWineCellar() {
		return nameWineCellar;
	}

	public void setNameWineCellar(String nameWineCellar) {
		this.nameWineCellar = nameWineCellar;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public List<Stock_SupplierDTO> getStockSuppliers() {
		return stockSuppliers;
	}

	public void setStockSuppliers(List<Stock_SupplierDTO> stockSuppliers) {
		this.stockSuppliers = stockSuppliers;
	}
}