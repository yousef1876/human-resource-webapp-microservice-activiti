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

import com.hr.framework.po.bug.tracking.users.Groups;

@Entity
@Table(name  = "objects_permission")
public class Objects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "object_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "clazz_name" , nullable = false)
	private String clazzName;
	
	@Column(name  = "package_name" , nullable = false)
	private String packageName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "logger_object_permission_accounts", catalog = "crmmix", joinColumns = {@JoinColumn(name = "object_id", nullable = false, updatable = false) },inverseJoinColumns = { @JoinColumn(name = "role_id",nullable = false, updatable = false) })
	private List<Permissions> users;
	
}
