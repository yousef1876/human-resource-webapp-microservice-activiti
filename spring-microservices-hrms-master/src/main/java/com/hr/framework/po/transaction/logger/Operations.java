package com.hr.framework.po.transaction.logger;

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

@Entity
@Table(name = "methods_operation")
public class Operations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "operation_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "methods" , nullable = false)
	private String method; 
	
	@Column(name  = "operation" , nullable = false)
	private String operation;
	
	@Column(name  = "clazz" , nullable = false)
	private String clazz;
	
	@Column(name  = "package_name" , nullable = false)
	private String packageName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "logger_permission_operations", catalog = "crmmix", joinColumns = {@JoinColumn(name = "object_id", nullable = false, updatable = false) },inverseJoinColumns = { @JoinColumn(name = "role_id",nullable = false, updatable = false) })
	private List<Permissions> permissions;

}
