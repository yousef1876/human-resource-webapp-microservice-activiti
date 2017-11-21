package com.hr.framework.po.issue.tracking.users;

import com.hr.framework.po.User;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name  = "issues_projects")
public class Project {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "project_name" , nullable = false)
	private String projectName;
	
	@Column(name  = "project_title" , nullable = true)
	private String projectTitle;
	
	@Column(name = "from_date" , nullable = false)
	private Date   fromDate;
	
	@Column(name  = "to_date" , nullable = false)
	private Date   toDate;
	
	@Column(name  = "note" , nullable = true)
	private String note;
	
	@Column(name  = "description" , nullable = true)
	private String description;
	
	@Column(name  = "project_code" , nullable = false)
	private String projectCode;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "projects" , cascade = CascadeType.ALL             )
	private List<Issue>  projects;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public List<Issue> getProjects() {
		return projects;
	}

	public void setProjects(List<Issue> projects) {
		this.projects = projects;
	}
}
