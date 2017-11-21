package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "fourms")
public class Fourms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fourm_id", updatable = false, nullable = false)
	private Long id;
	
	private String fourmName;
	
	private String title;
	
	/* FourmGroup FK*/
	
	private String description;
	
	private String note;

}
