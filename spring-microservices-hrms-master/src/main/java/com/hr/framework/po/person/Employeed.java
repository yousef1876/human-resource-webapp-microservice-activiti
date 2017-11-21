package com.hr.framework.po.person;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.enums.JobType;

@Entity
@Table(name = "person_employeed")
public class Employeed {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	/*Person FK*/
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "person_id" , nullable = false)
	private Person persons;
	
	
	/*Employer FK*/
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "employer_id" , nullable = false)
	private Employer employers;
	
	
	
	private boolean present = true;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "employeeds")
    private List<PersonExperience> employeeds;
	
	
	
	public Employer getEmployers() {
		return employers;
	}

	public void setEmployers(Employer employers) {
		this.employers = employers;
	}

	public Person getPersons() {
		return persons;
	}

	public void setPersons(Person persons) {
		this.persons = persons;
	}

	public List<PersonExperience> getEmployeeds() {
		return employeeds;
	}

	public void setEmployeeds(List<PersonExperience> employeeds) {
		this.employeeds = employeeds;
	}

	@Column(name = "type" , nullable = false)
	private JobType type;
	
	@Column(name = "description" , nullable = true)
	private String description;
	
	@Column(name = "note" , nullable = true)
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

}
