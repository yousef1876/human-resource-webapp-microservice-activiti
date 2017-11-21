package com.store.framework.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "blog_comments")
public class BlogComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_id", updatable = false, nullable = false)
	private Long id;
	
	private String content;
	
	private String title;
	
	private String contentName;
	
	
	private String email;
	
	private Date creationDate;
	
	/*  Customer FK   */
	
	/* BlogPost FK   */

}
