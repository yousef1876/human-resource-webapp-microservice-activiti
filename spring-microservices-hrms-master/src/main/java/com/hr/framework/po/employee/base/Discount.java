package com.hr.framework.po.employee.base;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name  = "employee_deductions")
public class Discount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "types" , nullable = false)
	private String type;

	@Column(name  = "description" , nullable = true)
	private String description;

	@Column(name  = "note" , nullable =  true)
	private String note;

	@Column(name  = "created_date" , nullable = false)
	private Date createdDate;
	
	/* Employee FK*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id" ,  nullable = false)
	private Employee employees;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_id" ,  nullable = false)
	private Employee createdBy;

	/*Created By (Employee FK)*/
	

}
