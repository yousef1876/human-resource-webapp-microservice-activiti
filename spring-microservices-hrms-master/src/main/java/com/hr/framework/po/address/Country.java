package com.hr.framework.po.address;

import com.hr.framework.po.applicant.Applicant;
import com.hr.framework.po.applicant.ApplicantQualification;
import com.hr.framework.po.applicant.Interviews;
import com.hr.framework.po.applicant.Positions;
import com.hr.framework.po.employee.base.Employee;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "country_name" , nullable = false)
	private String countryName;
	
	@Column(name = "description" , nullable = true)
	private String description;
	
	@Column(name = "note" , nullable = true)
	private String note;
	
	@OneToMany(fetch  = FetchType.LAZY , mappedBy = "countries")
	private List<State> states;

	@OneToMany(fetch  = FetchType.LAZY , mappedBy = "countries")
	private List<City> cities;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "country")
	private List<ApplicantQualification> applicantQualificationList;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "country" , cascade = CascadeType.ALL)
	private List<Applicant> applicant;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "country")
	private List<Interviews> interviews;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "country")
	private List<Positions> positions;


	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "country")
	private List<Employee> employees;

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	
}
