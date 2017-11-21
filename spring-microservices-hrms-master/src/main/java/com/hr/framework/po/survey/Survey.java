package com.hr.framework.po.survey;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hr.framework.po.transaction.logger.Roles;

@Entity
@Table(name  = "survey")
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "survey_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "survey_code" , nullable = false)
	private String surveyCode;
	
	@Column(name  = "survey_name" , nullable = false)
	private String surveyName;
	
	@Column(name  = "description" , nullable = false)
	private String description;
	
	@Column(name  = "summary" , nullable = false)
	private String summary;
	
	@Column(name  = "welcom_msg" , nullable = false)
	private String welcomMsg;
	
	@Column(name  = "end_msg" , nullable = false)
	private String endMsg;
	
	@Column(name = "start_date" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date   startDate;
	
	@Column(name = "expire_date" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date   expireDate;
	
	@Column(name = "public_date" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date   publicationDate;
	
	
	
}
