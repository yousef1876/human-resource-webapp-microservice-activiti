package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "blog_post")
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "blog_id", updatable = false, nullable = false)
	private Long id;
	
	private String blogName;
	
	private String blogTitle;
	
	private String description;
	
	
	private String note;
	
	private String content;
	
	/* Fourm FK */
	

}
