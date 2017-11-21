package com.hr.framework.po.employee.base;

import javax.persistence.*;

@Entity
@Table( name  = "employee_picture")
public class EmployeePicture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "image" , nullable = false)
	@Lob
	private byte[] picture;

	@Column(name  = "file_name" , nullable = false)
	private String file;


	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name  = "employee_id" , nullable = false)
	private Employee employees;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}



}
