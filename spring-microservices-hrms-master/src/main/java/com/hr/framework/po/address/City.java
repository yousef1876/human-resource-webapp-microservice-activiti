package com.hr.framework.po.address;

import com.hr.framework.po.applicant.Applicant;
import com.hr.framework.po.applicant.ApplicantQualification;
import com.hr.framework.po.applicant.Interviews;
import com.hr.framework.po.applicant.Positions;
import com.hr.framework.po.employee.base.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "city")
public class City {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	/*Country FK*/
	
	@ManyToOne(fetch  = FetchType.LAZY)
	@JoinColumn(name = "country_id" , nullable = false)
	private Country countries;
	
	/*State FK*/
	@ManyToOne(fetch  = FetchType.LAZY)
	@JoinColumn(name = "state_id" , nullable = true)
	private State states;
	
	
	@Column(name = "city" , nullable = false)
	private String city;
	
	@Column(name  = "code" , nullable = true)
	private String code;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "city" , cascade = CascadeType.ALL)
	private List<ApplicantQualification> applicantQualificationList;


	@OneToMany(fetch = FetchType.LAZY , mappedBy = "city" , cascade = CascadeType.ALL)
	private List<Applicant> applicant;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "city")
	private List<Interviews> interviews;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "city")
	private List<Positions> positions;


	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "city")
	private List<Employee> employees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Country getCountries() {
		return countries;
	}

	public void setCountries(Country countries) {
		this.countries = countries;
	}

	public State getStates() {
		return states;
	}

	public void setStates(State states) {
		this.states = states;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
