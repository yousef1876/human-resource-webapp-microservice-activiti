package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "blog_post_comments_imgs")
public class BlogCommentRelatedImages {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iamge_id", updatable = false, nullable = false)
	private Long id;
	
	
	private String imageName;
	
	private String fileSystemPath;
	
	/* Customer FK */
	
	/* BlogPost FK */
	
}
