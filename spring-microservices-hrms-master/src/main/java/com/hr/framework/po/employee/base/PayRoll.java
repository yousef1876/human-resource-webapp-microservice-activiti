package com.hr.framework.po.employee.base;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "employee_pay_roll")
public class PayRoll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	/* Employee FK*/

	@Column(name  = "started_day" , nullable = false)
	private String startedDay;

	@Column(name  = "ended_day" , nullable = false)
	private String endedDay;

	@Column(name  = "hour_worked" , nullable = false)
	private String hourWorked;

	@Column(name  = "discount" , nullable = false)
	private String discount;

	@ManyToOne
	@JoinColumn(name  = "employee_id" , nullable = false)
	private Employee employees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartedDay() {
		return startedDay;
	}

	public void setStartedDay(String startedDay) {
		this.startedDay = startedDay;
	}

	public String getEndedDay() {
		return endedDay;
	}

	public void setEndedDay(String endedDay) {
		this.endedDay = endedDay;
	}

	public String getHourWorked() {
		return hourWorked;
	}

	public void setHourWorked(String hourWorked) {
		this.hourWorked = hourWorked;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}
}
