package com.hr.framework.po.employee.base;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name  = "employee_time_sheet")
public class TimeSheet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "sheet_name" , nullable = false)
	private String sheetName;

	@Column(name  = "sheet_date" , nullable = false)
	private Date sheetDate;

	@Column(name = "check_in" , nullable = false )
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkIn;


	@Column(name  = "check_out" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkOut;

	@Column(name  = "work_description" , nullable = false)
	private String workDescription;


	@Column(name  = "note" , nullable = true)
	private String note;

	@Column(name = "description" , nullable = true)
	private String description;
	

	/* Employee FK*/
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name  = "employees_id" , nullable = false)
	private Employee employess;



	/* Project FK */
	
	
}
