package com.hr.framework.po.employee.base;

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
@Table(name  = "employee_bouns")
public class Bouns {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "bouns" , nullable = false)
	private String bouns;

	@Column(name = "created_date" , nullable = false)
	private Date createdDate;
	
    /*Employee FK*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id" , nullable = false)
	private Employee employees;
	
	
	/* CreatedBY (Employee FK)  */
	@ManyToOne(fetch = FetchType.LAZY )
	@Column(name = "created_by" , nullable = false)
	private Employee createdBy;
	
	
	@Column(name  = "description" , nullable = true )
	private String description;

	@Column(name = "note" , nullable = true)
	private String note;

	@Column(name  = "started_month" , nullable = false)
	private Date startedMonth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBouns() {
		return bouns;
	}

	public void setBouns(String bouns) {
		this.bouns = bouns;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
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

	public Date getStartedMonth() {
		return startedMonth;
	}

	public void setStartedMonth(Date startedMonth) {
		this.startedMonth = startedMonth;
	}
}
