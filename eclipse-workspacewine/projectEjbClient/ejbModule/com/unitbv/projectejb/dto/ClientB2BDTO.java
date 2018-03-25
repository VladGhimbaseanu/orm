package com.unitbv.projectejb.dto;


import java.io.Serializable;
import java.util.List;

public class ClientB2BDTO extends PlatformUserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private boolean visibility;
	
	private String companyName;
	
	private String CUI;
	
	private boolean subscribed;

	private List<Stock_ClientB2BDTO> stocClientB2B;
	
	public ClientB2BDTO() {
		super();
	}

	public ClientB2BDTO(boolean visibility, String companyName, String cUI, boolean subscribed,
			List<Stock_ClientB2BDTO> stocClientB2B) {
		super();
		this.visibility = visibility;
		this.companyName = companyName;
		CUI = cUI;
		this.subscribed = subscribed;
		this.stocClientB2B = stocClientB2B;
	}

	public boolean isVisibility() {
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

	public List<Stock_ClientB2BDTO> getStocClientB2B() {
		return stocClientB2B;
	}

	public void setStocClientB2B(List<Stock_ClientB2BDTO> stocClientB2B) {
		this.stocClientB2B = stocClientB2B;
	}
	
	
}
