package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fourm_post")
public class FourmPost {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id", updatable = false, nullable = false)
	private Long id;
	
	
	private String title;
	
	private String text;
	
	
	private String description;
	
	private String note;
	
	/* Customer Id FK */
	
	/* Topic FK */
	
	
	
}
