package com.unitbv.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Supplier extends PlatformUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nameWineCellar;
	
	private boolean visibility;
	
	private int age;

	@OneToMany(mappedBy="supplier")
	private List<Stock_Supplier> stockSuppliers;

	public Supplier() {
		super();
	}

	public Supplier(String nameWineCellar, boolean visibility, int age, List<Stock_Supplier> stockSuppliers) {
		super();
		this.nameWineCellar = nameWineCellar;
		this.visibility = visibility;
		this.age = age;
		this.stockSuppliers = stockSuppliers;
	}

	public String getNameWineCellar() {
		return nameWineCellar;
	}

	public void setNameWineCellar(String nameWineCellar) {
		this.nameWineCellar = nameWineCellar;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Stock_Supplier> getStockSuppliers() {
		return stockSuppliers;
	}

	public void setStockSuppliers(List<Stock_Supplier> stockSuppliers) {
		this.stockSuppliers = stockSuppliers;
	}
}