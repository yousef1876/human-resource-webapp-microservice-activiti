package com.hr.framework.po.bug.tracking.users;

import java.util.Date;

import javax.persistence.*;

import com.enums.BugPriority;
import com.hr.framework.po.employee.base.Employee;

@Entity
@Table(name = "bugs_tasks" )
public class Bugs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bug_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "bugs_name" , nullable = false)
	private String bugName;
	
	@Column(name = "bug_title" , nullable = false)
	private String bugTitle;
	
	@Column(name  = "added_date" , nullable = false)
	private Date addedDate;
	
	/* AddedBy FK */
	@ManyToOne
	@JoinColumn(name  = "employee_id" , nullable = false)
     private Employee employees;

	@Column(name = "modified_date" , nullable = true)
	private Date modifiedDate;
	
	/* ModifiedBY FK */
	@ManyToOne
	@JoinColumn(name  = "modify_id" , nullable = false)
	private Employee modifyBugs;


	@Column(name = "bugs_priority" , nullable = false)
	private BugPriority bugsP;
	
	@Column(name = "open" , nullable = false)
	private boolean open;
	
	@Column(name = "closed" , nullable = true)
	private boolean closed;
	
	@Column(name = "reopen" , nullable = true)
	private boolean reopen;
	
	/* Assign TO FK*/

	@ManyToOne
	@JoinColumn(name  = "assign_id" , nullable = false)
	private Employee assignTo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public String getBugTitle() {
		return bugTitle;
	}

	public void setBugTitle(String bugTitle) {
		this.bugTitle = bugTitle;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Employee getModifyBugs() {
		return modifyBugs;
	}

	public void setModifyBugs(Employee modifyBugs) {
		this.modifyBugs = modifyBugs;
	}

	public BugPriority getBugsP() {
		return bugsP;
	}

	public void setBugsP(BugPriority bugsP) {
		this.bugsP = bugsP;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public boolean isReopen() {
		return reopen;
	}

	public void setReopen(boolean reopen) {
		this.reopen = reopen;
	}

	public Employee getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(Employee assignTo) {
		this.assignTo = assignTo;
	}
}
