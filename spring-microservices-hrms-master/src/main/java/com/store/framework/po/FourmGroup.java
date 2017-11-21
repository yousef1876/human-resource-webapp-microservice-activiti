package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "fourm_group")
public class FourmGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "group_id", updatable = false, nullable = false)
	private Long id;
	
	private String groupName;
	
	private String groupRolePermession;
	
	private String description;
	
	private String note;

}
