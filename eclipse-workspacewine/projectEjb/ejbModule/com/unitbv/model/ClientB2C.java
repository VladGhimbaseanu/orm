package com.unitbv.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class ClientB2C extends PlatformUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dateRegister;

	private String CNP;

	@OneToMany(mappedBy="clientB2C")
	private List<ClientOrder> orders;

	public ClientB2C() {
		super();
	}

	public ClientB2C(String firstName, String lastName, Date dateRegister, String cNP, List<ClientOrder> orders) {
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

	public List<ClientOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ClientOrder> orders) {
		this.orders = orders;
	}
}
