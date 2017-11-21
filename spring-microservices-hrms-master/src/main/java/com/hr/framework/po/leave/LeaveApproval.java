package com.hr.framework.po.leave;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "leave_approval")
public class LeaveApproval {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private boolean isFullyApproved;
	
	/*person FK*/
	
	/*Leave FK*/
	
	
	
	

}
