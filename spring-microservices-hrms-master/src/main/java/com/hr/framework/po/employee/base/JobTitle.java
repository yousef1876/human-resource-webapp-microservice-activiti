package com.hr.framework.po.employee.base;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name  = "employee_job_title")
public class JobTitle {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;


	@Column(name  = "job_name" , nullable = false)
	private String jobName;

	@Column(name  = "note" , nullable = true)
	private String note;

	@Column(name  = "description" , nullable = true)
	private String description;

	@Column(name  = "job_code" , nullable = false)
	private String jobCode;


	@Column(name  = "created_date" , nullable = false)
	private Date createdDate;


	@ManyToOne
	@JoinColumn(name  = "supervisor" , nullable = false)
	private Employee supervisors;

	@ManyToOne
	@JoinColumn(name  = "employeee_id" , nullable = false)
	private Employee employees;


	@ManyToOne
	@JoinColumn(name =  "createdby" , nullable = false)
	private Employee createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Employee getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(Employee supervisors) {
		this.supervisors = supervisors;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}
}
