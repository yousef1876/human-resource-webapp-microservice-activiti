package com.hr.framework.po.person;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name  = "employer")
public class Employer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "employer_name" , nullable = false)
	private String employerName;
	
	@Column(name = "address" , nullable = false)
	private String address;
	
	@Column(name = "employer_code" , nullable = false)
	private String employerCode;
	
	@Column(name = "email" , nullable = false)
	private String email;
	
	@Column(name = "head_addrs_name" , nullable = false)
	private String headAddName;
	
	@Column(name = "head_phone" )
	private String headphone;

	/*Jobs FK*/
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "jobs")
	private List<Job> jobs;
	
	
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployerCode() {
		return employerCode;
	}

	public void setEmployerCode(String employerCode) {
		this.employerCode = employerCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadAddName() {
		return headAddName;
	}

	public void setHeadAddName(String headAddName) {
		this.headAddName = headAddName;
	}

	public String getHeadphone() {
		return headphone;
	}

	public void setHeadphone(String headphone) {
		this.headphone = headphone;
	}
	
    
	/* PersonName; FK */
	
	
}
