package com.hr.framework.po.issue.tracking.users;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name  = "issue_resolution")
public class Resolution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "solution_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "summary" , nullable = false)
	private String summary;
	
	@Column(name  = "note" , nullable = true)
	private String note;
	
	@Column(name  = "description" , nullable = true)
	private String description;
	
	@Column(name  = "added_date" , nullable = false)
	private Date addedDate;
	
	@Column(name  = "added_by" , nullable = false)
	private Users addedBy;
	
	@Column(name  = "modified_date" , nullable = true)
	private Date modifiedDate;
	
	@Column(name = "modified_by" , nullable = true)
	private Users modifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Users getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Users addedBy) {
		this.addedBy = addedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Users getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Users modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
