package com.hr.framework.po.survey;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "survey_participate")
public class SurveyParticipate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "part_id", updatable = false, nullable = false)
	private Long id;
	
	/* Survey FK	*/
	/* Person FK    */
	
	@Column(name  = "email" , nullable = false)
	private String email;
	
	@Column(name  = "participation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date   participationDate;
	
	

}
