package com.hr.framework.po.employee.performance;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name  = "employee_training_history")
public class EmployeeTrainingHistory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "results" , nullable = false)
	private String results;

	@Column(name  = "note" , nullable = true)
	private String note;

	@Column(name  = "description" , nullable = true)
	private String description;

	@Column(name  = "start_date" , nullable = false)
	private Date startDate;

	@Column(name  = "end_date" , nullable = false)
	private Date endDatre;

	@ManyToOne
	@JoinColumn(name  = "course_id" , nullable = false)
	private EmployeeCourses courses; /*Courses FK*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDatre() {
		return endDatre;
	}

	public void setEndDatre(Date endDatre) {
		this.endDatre = endDatre;
	}

	public EmployeeCourses getCourses() {
		return courses;
	}

	public void setCourses(EmployeeCourses courses) {
		this.courses = courses;
	}
}
