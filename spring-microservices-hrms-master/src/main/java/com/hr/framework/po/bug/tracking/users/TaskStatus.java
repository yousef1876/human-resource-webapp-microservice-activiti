package com.hr.framework.po.bug.tracking.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "task_status")
public class TaskStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id", updatable = false, nullable = false)
	private Long id;
	
	/*Task FK*/
	
	@Column(name = "note" , nullable = true)
	private String note;
	
	@Column(name = "description" , nullable = false)
	private String description;
	
	@Column(name = "added_date" , nullable = false)
	private Date addedDate;
	
	@Column(name = "modified_name" , nullable = true)
	private Date modifiedDate;
	
	/*User FK*/
	
}
