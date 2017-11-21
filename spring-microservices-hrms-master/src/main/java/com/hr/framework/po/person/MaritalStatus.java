package com.hr.framework.po.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.enums.MaritalStatusType;

@Entity
@Table(name = "marital_status")
public class MaritalStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "from_date" , nullable = false)
	private String fromDate;
	
	@Column(name = "end_date" , nullable = false)
	private String endDate;
	
	@Column(name = "status" , nullable = false)
	private MaritalStatusType status;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Person maritals;
	
	
	public Person getMaritals() {
		return maritals;
	}

	public void setMaritals(Person maritals) {
		this.maritals = maritals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public MaritalStatusType getStatus() {
		return status;
	}

	public void setStatus(MaritalStatusType status) {
		this.status = status;
	}
	

}
