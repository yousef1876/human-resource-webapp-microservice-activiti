package com.hr.framework.po.survey;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "survey_question_choices")

public class QuestionChoices implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "choice_id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "choice_name" , nullable = false)
	private String choiceName;
	
	/* Question FK */
	
}
