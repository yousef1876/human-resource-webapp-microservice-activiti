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

@Entity
@Table(name = "person_experience")
public class PersonExperience {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "from_date" , nullable = false)
	private Date fromDate;
	
	@Column(name = "to_date" , nullable = false)
	private Date toDate;
	
	@Column(name = "is_present" , nullable = true)
	private boolean ispresent;
	
    @Column(name = "duties" , nullable = false)
	private String duties;
	
    @Column(name = "description" , nullable = true)
	private String description;
	
    @Column(name = "note" , nullable = true)
	private String note;
	
	@Column(name = "leave_reason" , nullable = true)
    private String leaveReason;
    
	@Column(name = "weakness" , nullable = true)
    private String weakness;
    
	@Column(name = "strongness" , nullable = true)
    private String strongness;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "employeed_id" , nullable = false)
	private Employeed employeeds;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isIspresent() {
		return ispresent;
	}

	public void setIspresent(boolean ispresent) {
		this.ispresent = ispresent;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
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

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public String getStrongness() {
		return strongness;
	}

	public void setStrongness(String strongness) {
		this.strongness = strongness;
	}

}
