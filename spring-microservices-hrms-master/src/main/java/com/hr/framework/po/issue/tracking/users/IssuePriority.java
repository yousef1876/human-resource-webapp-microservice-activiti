package com.hr.framework.po.issue.tracking.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "issue_priority")
public class IssuePriority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "priority_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "code" , nullable = false)
	private String code;
	
	@Column(name  = "rank" , nullable = false)
	private String rank;
	
	@Column(name  = "dewscription" , nullable = true)
	private String description;
	
	@Column(name  = "note" , nullable = true)
	private String note;


	
}
