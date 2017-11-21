package com.hr.framework.po.survey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.enums.QuestionType;


@Entity
@Table( name  = "survey_questions")
@Inheritance(strategy=InheritanceType.JOINED)
public class Questions {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id", updatable = false, nullable = false)
	private Long id;
	
	@Column( name = "question" , nullable = false)
	private String question;
	
	@Column(name  = "text" , nullable = true)
	private String text;
	
	@Column(name  = "type" , nullable = false)
	private QuestionType type;
	
	@Column(name  = "expected_actual_answer" , nullable = false)
	private String expectedActualAnswer;
	
	/* Survey FK */
}
