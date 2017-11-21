package com.hr.framework.po.employee.base;

import javax.persistence.*;

@Entity
@Table(name  = "employee_hours_rate")
public class Hourly {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	/*Employee FK*/
	@ManyToOne
	@JoinColumn(name  = "employee_id" , nullable = false)
	private Employee employees;


	@Column(name  ="rate" , nullable = false)
	private String rate;

	@Column(name = "note" , nullable = true)
	private String note;

	@Column(name  ="description" , nullable = true)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
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
