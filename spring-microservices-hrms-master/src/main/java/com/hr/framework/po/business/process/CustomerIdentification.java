package com.hr.framework.po.business.process;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.enums.CustomerIdentificationType;

@Entity
@Table(name = "customer_identification")
public class CustomerIdentification {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "id_number" , nullable = false)
	private String idNumber;
	
	@Column(name = "type" , nullable = false)
	private CustomerIdentificationType type;
	
	@Column(name = "expire_date" , nullable = true)
	private Date expireDate;
	
	@Column(name = "from_date" , nullable = false)
	private Date fromDate;
	
	@Column(name = "issue_by" , nullable = false)
	private String issueBy;
	
	@Column(name = "issue_country" , nullable = false)
	private String issueCountry;
	
	@Column(name = "note" , nullable = true)
	private String note;
	
	@Column(name = "description" , nullable = true)
	private String description;
	
	/*Customer FK*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id" , nullable = false)
	private Customer customers;
	
}
