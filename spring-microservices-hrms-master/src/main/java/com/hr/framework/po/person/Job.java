package com.hr.framework.po.person;

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
@Table( name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "job_title" , nullable = false)
	private String jobTitle;
	
	@Column(name = "company" , nullable = false)
	private String employeed;
	
	@Column(name = "contact_email" , nullable = false)
	private String contactEmail;
	
	@Column(name = "addrs" , nullable = false)
	private String addrs;
	
	@Column(name = "mobile" , nullable = false)
	private String mobile;
	
	@Column(name = "phone" , nullable = false)
	private String phone;
	
	
	@Column(name = "description" , nullable = true)
	private String description;
	
	@Column(name = "note" , nullable = true)
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id" , nullable = true)
	private Employer jobs;
	
	
	
	
	public Employer getJobs() {
		return jobs;
	}

	public void setJobs(Employer jobs) {
		this.jobs = jobs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmployeed() {
		return employeed;
	}

	public void setEmployeed(String employeed) {
		this.employeed = employeed;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	
}
