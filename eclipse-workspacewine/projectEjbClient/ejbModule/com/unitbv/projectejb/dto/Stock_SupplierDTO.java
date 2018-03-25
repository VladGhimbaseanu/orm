package com.unitbv.projectejb.dto;

import java.io.Serializable;
import java.util.List;

public class Stock_SupplierDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private int price;
	
	private int quantity;

	private Stock_ClientB2BDTO stockClientB2B;
	
	private List<PromoDTO> promos;

	private SupplierDTO supplier;
	
	private WineDTO wine;
	
	public Stock_SupplierDTO() {
		super();
	}

	public Stock_SupplierDTO(int price, int quantity, Stock_ClientB2BDTO stockClientB2B, List<PromoDTO> promos,
			SupplierDTO supplier, WineDTO wine) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.stockClientB2B = stockClientB2B;
		this.promos = promos;
		this.supplier = supplier;
		this.wine = wine;
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

	public Stock_ClientB2BDTO getStockClientB2B() {
		return stockClientB2B;
	}

	public void setStockClientB2B(Stock_ClientB2BDTO stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
	}

	public List<PromoDTO> getPromos() {
		return promos;
	}

	public void setPromos(List<PromoDTO> promos) {
		this.promos = promos;
	}

	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
		this.supplier = supplier;
	}

	public WineDTO getWine() {
		return wine;
	}

	public void setWine(WineDTO wine) {
		this.wine = wine;
	}
}
