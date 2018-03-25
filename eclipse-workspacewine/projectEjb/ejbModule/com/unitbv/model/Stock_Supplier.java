package com.unitbv.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Stock_Supplier  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int price;
	
	private int quantity;

	@ManyToOne
	@JoinColumn(name="STOCKCLIENTB2BID")
	private Stock_ClientB2B stockClientB2B;
	
	@OneToMany(mappedBy="stockSupplier")
	private List<Promo> promos;

	@ManyToOne
	@JoinColumn(name="SUPPLIERID")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="WINEID")
	private Wine wine;

	public Stock_Supplier() {
		super();
	}

	public Stock_Supplier(int price, int quantity, Stock_ClientB2B stockClientB2B, List<Promo> promos,
			Supplier supplier, Wine wine) {
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

	public Stock_ClientB2B getStockClientB2B() {
		return stockClientB2B;
	}

	public void setStockClientB2B(Stock_ClientB2B stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
	}

	public List<Promo> getPromos() {
		return promos;
	}

	public void setPromos(List<Promo> promos) {
		this.promos = promos;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}
}