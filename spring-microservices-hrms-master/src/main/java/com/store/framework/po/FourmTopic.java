package com.store.framework.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "fourm_topic")
public class FourmTopic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "topic_id", updatable = false, nullable = false)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String note;
	
	/* Catogery Fourm FK*/
	
	private Date creationDate;
	
	private Date updatedDate;
	
	
	/*  Users PO FK */
	
	
	
}
