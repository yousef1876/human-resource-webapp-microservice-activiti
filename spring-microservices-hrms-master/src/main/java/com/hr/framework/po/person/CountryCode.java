package com.hr.framework.po.person;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country_code")
public class CountryCode {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "country_name" , nullable = false)
	private String countryCode;
	
	
	@Column(name = "country_name" , nullable = false)
	private String countryName;


	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "codes")
	private List<Citizen> citizens;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "codes")
	private List<Passport> passports;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "codes")
	private List<PersonLanguage> langs;
	
	
	
	public List<PersonLanguage> getLangs() {
		return langs;
	}


	public void setLangs(List<PersonLanguage> langs) {
		this.langs = langs;
	}


	public List<Passport> getPassports() {
		return passports;
	}


	public void setPassports(List<Passport> passports) {
		this.passports = passports;
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


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	
	
}
