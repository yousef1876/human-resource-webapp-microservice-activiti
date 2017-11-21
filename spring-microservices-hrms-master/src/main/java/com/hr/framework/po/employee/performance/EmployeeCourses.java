package com.hr.framework.po.employee.performance;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.hr.framework.po.employee.base.Department;
import com.hr.framework.po.employee.base.Employee;

@Entity
@Table(name  = "employee_courses")
public class EmployeeCourses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "start_date" , nullable = false)
	private Date startDate;

	@Column(name  = "end_date" , nullable = false)
	private Date endDate;

	@ManyToOne(  fetch = FetchType.LAZY)
	@JoinColumn(name  = "employee_id" , nullable = false)
	private Employee employees; /*Employee FK*/

	@ManyToOne
	@JoinColumn(name  = "department_id" , nullable = false)
	private Department departments; /*Department FK*/

	@Column(name  = "note" , nullable = true)
	private String note;

	@Column(name  = "description" , nullable = true)
	private String description;

	@Column(name = "course_name" , nullable = false)
	private String courseName;


	@ManyToOne
	@JoinColumn(name  = "admin_id" , nullable = false)
	private Employee admins; /* Employee FK*/


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "courses")
	private List<EmployeeTrainingHistory> courses;


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

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Employee getAdmins() {
		return admins;
	}

	public void setAdmins(Employee admins) {
		this.admins = admins;
	}
}
