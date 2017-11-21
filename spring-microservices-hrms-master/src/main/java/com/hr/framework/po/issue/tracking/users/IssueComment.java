package com.hr.framework.po.issue.tracking.users;

import com.hr.framework.po.employee.base.Employee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "issue_comment")
public class IssueComment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "title" , nullable = false)
	private String title;

	@Column(name  = "text" , nullable = false)
	private String text;

	@Column(name  = "comments" , nullable = false)
	private String comments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "issue_id" , nullable = false)
	private Issue issues;

	@Column(name  = "created_date" , nullable = false)
	@Temporal( TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name  = "updated_date" , nullable = true)
	private Date updatedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "created_by" , nullable = false)
	private Employee createdBy;



	
}
