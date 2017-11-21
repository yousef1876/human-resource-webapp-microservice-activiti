package com.hr.framework.po.issue.tracking.users;

import java.util.Date;
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

import com.hr.framework.po.User;
import com.hr.framework.po.bug.tracking.users.Groups;


@Entity
@Table(name = "issue_users_account")
public class Users  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "first_name" , nullable = false)
	private String firstName;

	@Column(name = "second_name" , nullable = true)
	private String secondName;

	@Column(name  = "last_name" , nullable = false)
	private String lastName;

	@Column(name  = "user_name" , nullable = false)
	private String userName;

	@Column(name = "password" , nullable = false)
	private String password;

	@Column(name  = "last_login_date" , nullable = false)
	private Date lastLoginDate;

	@Column(name  = "email" , nullable = true)
	private String email;

	@Column(name  = "mobile" , nullable = false)
	private String mobile;

	@Column(name ="phone" , nullable = true)
	private String phone;

	@Column(name = "enabled" , nullable = false)
	private boolean enabled;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "issue_users_project_accounts", catalog = "crmmix", joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false) },inverseJoinColumns = { @JoinColumn(name = "project_id",nullable = false, updatable = false) })
	private List<Project> users;




}
