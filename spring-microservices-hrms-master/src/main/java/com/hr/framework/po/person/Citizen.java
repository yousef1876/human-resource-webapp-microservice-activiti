package com.hr.framework.po.person;

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
@Table( name = "citizen")
public class Citizen {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	/* person  FK*/
    /* Country FK*/
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "person_id" , nullable = false)
	private Person persons;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "country_id" , nullable = false)
	private CountryCode codes;
	
	
	@Column(name = "citizen_name" , nullable = false)
	private String citizenName;
	
	@Column(name = "citizen_type" , nullable = false)
	private String citizenType;
	
	@Column(name = "citizen_no" , nullable = false)
	private String citizenNo;
	
	@Column(name = "from_date" , nullable = false)
	private Date fromDate;
	
	@Column(name= "to_date" , nullable = true)
	private Date toDate;
	
	@Column(name = "note" , nullable = true)
	private String note;
	
	@Column(name = "description" , nullable = true)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenType() {
		return citizenType;
	}

	public void setCitizenType(String citizenType) {
		this.citizenType = citizenType;
	}

	public String getCitizenNo() {
		return citizenNo;
	}

	public void setCitizenNo(String citizenNo) {
		this.citizenNo = citizenNo;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
