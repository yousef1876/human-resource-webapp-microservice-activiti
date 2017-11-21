package com.hr.framework.po.survey;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "response")
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "response_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "response_name" , nullable = false)
	private String responseName;
	
	@Column(name  = "response_title" , nullable = false)
	private String responseTitle;
	
	@Column(name  = "added_date" , nullable = false)
	private Date addedDate;
	
	@Column( name = "survey_code" , nullable = false)
    private String surveyCode;
	
	
   
    
	
}
