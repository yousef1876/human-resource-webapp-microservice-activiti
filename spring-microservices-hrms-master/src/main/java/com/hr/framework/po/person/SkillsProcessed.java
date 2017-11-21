package com.hr.framework.po.person;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.embedded.pk.CompositeKeySkills;

@Entity
@Table(name = "skills_processed")
@IdClass(CompositeKeySkills.class)
public class SkillsProcessed implements Serializable{

	 @Column(name = "description" , nullable = true)
	 private String description;
	 
	 @Column(name = "note" , nullable = true)
	 private String note;
	 
	 @Column(name = "last_used" , nullable = false)
	 private Date lastUsed;

	 @Id
	 @ManyToOne(fetch =  FetchType.LAZY)
	 @JoinColumn(name = "skill_id" , nullable = false)
	 private Skills skills;
	 
	 @Id
	 @ManyToOne(fetch =  FetchType.LAZY)
	 @JoinColumn(name = "person_id" , nullable = false)
	 private Person persons;
	 
	 
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

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
	
	 	
	/*Skill FK*/
	
	/*FK person*/
	

}
