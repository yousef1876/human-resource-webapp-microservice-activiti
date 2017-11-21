package com.hr.framework.po.bug.tracking.users;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name  = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "project_name" , nullable = false)
	private String projectName;
	
	@Column(name  = "project_title" , nullable = false)
	private String projectTitle;
	
	@Column(name = "from_date" , nullable = false)
	private Date fromDate;
	
	@Column(name = "to_date" , nullable = false)
	private Date toDate;
	
	@Column(name = "note" , nullable = true)
	private String notes;
	
	@Column(name = "description" , nullable = true)
	private String description;


	@OneToMany(mappedBy = "projects" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Attachment> attchments;

	@OneToMany(mappedBy = "projects" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Phases> phases;

	@OneToMany(mappedBy = "projects" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<ProjectVersion> versions;

	@OneToMany(mappedBy = "projects" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<TaskAssignee> assignTasksAssignee;


	@OneToMany(mappedBy = "projects" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Tasks> assignTasks;

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
