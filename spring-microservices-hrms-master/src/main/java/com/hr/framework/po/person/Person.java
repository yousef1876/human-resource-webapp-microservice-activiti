package com.hr.framework.po.person;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person_table")
public class Person {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name = "second_name" , nullable = false)
	private String secondName;
	
	@Column(name = "last_name" , nullable = false)
	private String lastName;
	
	@Column(name = "birth_place" , nullable = true)
	private String birthName;
	
	@Column(name = "birth_place" , nullable = true)
	private String birthPlace;

	@Column(name = "religious_name" , nullable = false)
	private String religiuosName;

	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Citizen> citizens;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Contact> contacts;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<DegreeObtained> degrees;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Employeed> employeed;
	
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Identification> identification;
	
	@OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "maritals")
	@JoinColumn(name = "marital_id" , nullable = true)
	private MaritalStatus status;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Passport> passports;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<SkillsProcessed> skills;
	
	
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<DegreeObtained> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<DegreeObtained> degrees) {
		this.degrees = degrees;
	}

	public List<Employeed> getEmployeed() {
		return employeed;
	}

	public void setEmployeed(List<Employeed> employeed) {
		this.employeed = employeed;
	}

	public List<Identification> getIdentification() {
		return identification;
	}

	public void setIdentification(List<Identification> identification) {
		this.identification = identification;
	}

	public MaritalStatus getStatus() {
		return status;
	}

	public void setStatus(MaritalStatus status) {
		this.status = status;
	}

	public List<Passport> getPassports() {
		return passports;
	}

	public void setPassports(List<Passport> passports) {
		this.passports = passports;
	}

	public List<SkillsProcessed> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillsProcessed> skills) {
		this.skills = skills;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthName() {
		return birthName;
	}

	public void setBirthName(String birthName) {
		this.birthName = birthName;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getReligiuosName() {
		return religiuosName;
	}

	public void setReligiuosName(String religiuosName) {
		this.religiuosName = religiuosName;
	}
	
    /*Address BirthCode*/
	
	/*Living Address*/
	
	
}
