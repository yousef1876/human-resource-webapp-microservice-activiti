package com.hr.framework.po.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.enums.UniversityDegreeTyped;

@Entity
@Table( name = "degree_obtained")
public class DegreeObtained {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "university_name" , nullable = false)
	private String universityName;
	
	@Column(name = "from_date" , nullable = false)
	private Date fromDate;
	
	@Column(name = "to_date" , nullable = false)
	private Date toDate;
	
	@Column(name = "university_place" , nullable = false)
	private String universityPlace;
	
	@Column(name = "iscompleted" , nullable = false)
	private boolean iscompleted;
	
	@Column(name = "faculty_name" , nullable = false)
	private String facultyName;
	
	@Column(name = "major_name" , nullable = false)
	private String majorName;
	
	@Column(name = "gpa" , nullable = false)
	private String GPA;
	
	@Column(name = "degree_typed" , nullable = false)
	private UniversityDegreeTyped typed;
	
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "person_id" , nullable = false)
	private Person persons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getUniversityPlace() {
		return universityPlace;
	}

	public void setUniversityPlace(String universityPlace) {
		this.universityPlace = universityPlace;
	}

	public boolean isIscompleted() {
		return iscompleted;
	}

	public void setIscompleted(boolean iscompleted) {
		this.iscompleted = iscompleted;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getGPA() {
		return GPA;
	}

	public void setGPA(String gPA) {
		GPA = gPA;
	}

	public UniversityDegreeTyped getTyped() {
		return typed;
	}

	public void setTyped(UniversityDegreeTyped typed) {
		this.typed = typed;
	}
	
	/*Person FK*/
	
}
