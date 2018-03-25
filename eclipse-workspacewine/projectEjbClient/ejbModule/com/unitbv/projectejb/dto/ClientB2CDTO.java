package com.unitbv.projectejb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ClientB2CDTO extends PlatformUserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	
	private String lastName;
	
	private Date dateRegister;

	private String CNP;

	private List<ClientOrderDTO> orders;
	
	public ClientB2CDTO() {
		super();
	}

	public ClientB2CDTO(String firstName, String lastName, Date dateRegister, String cNP, List<ClientOrderDTO> orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateRegister = dateRegister;
		CNP = cNP;
		this.orders = orders;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public List<ClientOrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<ClientOrderDTO> orders) {
		this.orders = orders;
	}
}
