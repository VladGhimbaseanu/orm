package com.unitbv.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class ClientB2B extends PlatformUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private boolean visibility;
	
	private String companyName;
	
	private String CUI;
	
	private boolean subscribed;

	@OneToMany(mappedBy="clientB2B")
	private List<Stock_ClientB2B> stocClientB2B;

	public ClientB2B() {
		super();
	}

	public ClientB2B(boolean visibility, String companyName, String cUI, boolean subscribed,
			List<Stock_ClientB2B> stocClientB2B) {
		super();
		this.visibility = visibility;
		this.companyName = companyName;
		CUI = cUI;
		this.subscribed = subscribed;
		this.stocClientB2B = stocClientB2B;
	}

	public boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String cUI) {
		CUI = cUI;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public List<Stock_ClientB2B> getStocClientB2B() {
		return stocClientB2B;
	}

	public void setStocClientB2B(List<Stock_ClientB2B> stocClientB2B) {
		this.stocClientB2B = stocClientB2B;
	}
}
