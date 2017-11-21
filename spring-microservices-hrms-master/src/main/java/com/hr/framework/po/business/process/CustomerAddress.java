package com.hr.framework.po.business.process;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table" )
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "address_name" , nullable = false)
	private String addressName;
	
	@Column(name = "city" , nullable = true)
	private String city;
	
	@Column(name = "country" , nullable = true)
	private String country;
	
	@Column(name = "state" , nullable = true)
	private String state;
	
	@Column(name = "from_date" , nullable = false)
	private Date fromDate;
	
	@Column(name  = "to_date" , nullable = true)
	private Date toDate;
	
	@Column(name = "present" , nullable = true)
	private boolean present;
	
	@Column(name = "description" , nullable = true)
	private String description;
	
	@Column(name = "note" , nullable = true)
	private String note;
	
	
	/*Customer FK*/
	
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "customer_id" , nullable = false )
	private Customer customers;


	public Long getId() {
		return id;
	}
	


	public void setId(Long id) {
		this.id = id;
	}
	


	public String getAddressName() {
		return addressName;
	}
	


	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	


	public String getCity() {
		return city;
	}
	


	public void setCity(String city) {
		this.city = city;
	}
	


	public String getCountry() {
		return country;
	}
	


	public void setCountry(String country) {
		this.country = country;
	}
	


	public String getState() {
		return state;
	}
	


	public void setState(String state) {
		this.state = state;
	}
	


	public Date getFromDate() {
		return fromDate;
	}
	


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	


	public Date getToDate() {
		return toDate;
	}
	


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	


	public boolean isPresent() {
		return present;
	}
	


	public void setPresent(boolean present) {
		this.present = present;
	}
	


	public String getDescription() {
		return description;
	}
	


	public void setDescription(String description) {
		this.description = description;
	}
	


	public String getNote() {
		return note;
	}
	


	public void setNote(String note) {
		this.note = note;
	}
	


	public Customer getCustomers() {
		return customers;
	}
	


	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
	
}
