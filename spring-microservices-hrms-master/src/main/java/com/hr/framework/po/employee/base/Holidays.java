package com.hr.framework.po.employee.base;

import java.util.Date;

import javax.persistence.*;

import com.enums.HolidayType;

@Entity
@Table(name  = "employee_holidays")
public class Holidays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;


	@Column(name  = "start_day" , nullable = false)
	private Date startedDay;

	@Column(name = "end_day" , nullable = false)
	private Date endDay;

	@Column(name = "description" , nullable = true)
	private String description;


	/*Employee FK*/
     @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name  = "employee_id" , nullable = false)
	 private Employee employees;

	
	/*Employee FK created by*/
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "created_by" , nullable = false)
	private Employee createdBy;



	@Column(name  = "is_paid" , nullable = false)
	private boolean  isPaid;

	@Column(name = "holiday_type" , nullable = false)
	private HolidayType type;

	@Column(name  = "is_open" , nullable = true)
	private boolean isOpen;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartedDay() {
		return startedDay;
	}

	public void setStartedDay(Date startedDay) {
		this.startedDay = startedDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean paid) {
		isPaid = paid;
	}

	public HolidayType getType() {
		return type;
	}

	public void setType(HolidayType type) {
		this.type = type;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean open) {
		isOpen = open;
	}
}
