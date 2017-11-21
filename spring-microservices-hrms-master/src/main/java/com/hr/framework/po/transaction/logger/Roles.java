package com.hr.framework.po.transaction.logger;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name  = "roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "role_name" , nullable = false)
	private String roleName;
	
	@Column(name  = "description" , nullable = true)
	private String description;
	
	@Column(name  = "note" , nullable = true)
	private String note;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "users")
	private List<Permissions> users;

}
