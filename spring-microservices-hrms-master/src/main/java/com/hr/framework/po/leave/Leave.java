package com.hr.framework.po.leave;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enums.LeaveType;

@Entity
@Table(name = "employee_leave")
public class Leave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "leave_name" , nullable = false)
	private String leaveName;
	
	@Column(name  = "reason" , nullable = false)
	private String reason;
	
	@Column(name  = "note" , nullable = true)
	private String note;
	
	@Column(name  = "description" , nullable = true )
	private String description;
	
	@Column(name  = "from_date" , nullable = false)
	private Date fromDate;

	@Column(name = "to_date" , nullable = false)
	private Date toDate;
	
	@Column(name = "type" , nullable = false)
	private LeaveType type;
	
	/*Person FK*/
	
	
	
}
