package com.hr.framework.po.business.process;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.jpamodelgen.xml.jaxb.FetchType;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name = "second_name" , nullable = true)
	private String secondName;
	
	@Column(name = "last_name" , nullable = false)
	private String lastName;
	
	@Column(name = "email" , nullable = true)
	private String email;
	
	@Column(name = "phone" , nullable = true)
	private String phone;
	
	@Column(name = "address" , nullable =  true)
	private String address;
	
	@Column(name = "mobile" , nullable = false)
	private String mobile;
	
	@OneToMany(fetch = javax.persistence.FetchType.LAZY , mappedBy = "customers")
	private List<CustomerAddress> customers;
	
	@OneToMany(fetch = javax.persistence.FetchType.LAZY , mappedBy = "customers")
	private List<CustomerIdentification> customersIdent;
	

	public List<CustomerIdentification> getCustomersIdent() {
		return customersIdent;
	}
	
	public void setCustomersIdent(List<CustomerIdentification> customersIdent) {
		this.customersIdent = customersIdent;
	}
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getFirstName() {
		return firstName;
	}
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public String getSecondName() {
		return secondName;
	}
	

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	

	public String getLastName() {
		return lastName;
	}
	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getPhone() {
		return phone;
	}
	

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public String getAddress() {
		return address;
	}
	

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getMobile() {
		return mobile;
	}
	

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

	public List<CustomerAddress> getCustomers() {
		return customers;
	}
	

	public void setCustomers(List<CustomerAddress> customers) {
		this.customers = customers;
	}
	
}
