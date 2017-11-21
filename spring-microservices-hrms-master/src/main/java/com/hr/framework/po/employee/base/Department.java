package com.hr.framework.po.employee.base;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.DepartmentCategory;
import com.hr.framework.po.employee.performance.EmployeeCourses;
import com.hr.framework.po.employee.performance.PerformanceReview;

@Entity
@Table(name  = "employee_department")
public class Department {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "dept_name" , nullable = false)
	private String deptName;

	@Column(name  = "dept_category" , nullable = false)
	private DepartmentCategory catogery;

	@Column(name  = "created_date" , nullable = false)
	private Date createdDate;

	@Column(name  = "updated_date" , nullable = true)
	private Date updatedDate;

	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private Department parent; /* FK */

	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "depts" , cascade = CascadeType.ALL)
	private List<Employee> employees;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "departments")
	private List<EmployeeCourses> courses;


	@OneToMany(mappedBy = "depts" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<PerformanceReview> performances;


	@Column(name  = "description")
	private String description;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public DepartmentCategory getCatogery() {
		return catogery;
	}

	public void setCatogery(DepartmentCategory catogery) {
		this.catogery = catogery;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
