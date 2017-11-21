package com.hr.framework.po.issue.tracking.users;

import com.hr.framework.annotation.SizeField;
import springfox.documentation.spring.web.scanners.ApiListingScanner;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "issue_status")
public class IssueStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "status" , nullable = false)
	private String status;
	
	@Column(name  = "rank" , nullable = false)
	private String rank;
	
	@Column(name  = "note" , nullable = true)
	private String note;
	
	@Column(name  = "description" , nullable = true)
	private String description;





}
