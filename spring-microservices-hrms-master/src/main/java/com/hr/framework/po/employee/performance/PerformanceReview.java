package com.hr.framework.po.employee.performance;

import java.util.Date;

import javax.persistence.*;

import com.hr.framework.po.employee.base.Department;
import com.hr.framework.po.employee.base.Employee;

@Entity
@Table(name = "employee_performance_review")
public class PerformanceReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "start_date" , nullable = false)
	private Date startDate;

	@Column(name = "end_date" , nullable = false)
	private Date endDate;

	@Column(name  = "details" , nullable = false)
	private String details;

	@Column(name  = "description" , nullable = true)
	private String description;

	@Column(name  = "note" , nullable = true)
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id" , nullable = false)
	private Employee employees; /*Employee FK*/

	@ManyToOne
	@JoinColumn(name  = "department_id" , nullable = false)
	private Department depts; /*Department FK*/

	@Column(name  = "stage_name" , nullable = false)
	private String stageName;

	@ManyToOne
	@JoinColumn(name = "admin_id" , nullable = false)
	private Employee admins; /*Employee FK*/


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Department getDepts() {
		return depts;
	}

	public void setDepts(Department depts) {
		this.depts = depts;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public Employee getAdmins() {
		return admins;
	}

	public void setAdmins(Employee admins) {
		this.admins = admins;
	}
}
