package com.hr.framework.po.bug.tracking.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.embedded.pk.CompositeKeyTeamMember;
import com.hr.framework.po.employee.base.Employee;
import com.hr.framework.po.person.Person;
import com.hr.framework.po.person.Skills;

@Entity
@Table(name = "project_team_member")
public class ProjectTeamMember {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id", updatable = false, nullable = false)
    private Long id;


	 @ManyToOne(fetch =  FetchType.LAZY)
	 @JoinColumn(name = "person_id" , nullable = true)
	 private Person persons;

	
	/*USER FK*/
	@ManyToOne
    @JoinColumn(name  = "employee_id" , nullable = false)
	private Employee employees;


	/*Project Version FK*/

	@ManyToOne
    @JoinColumn(name  = "version_id" , nullable = false)
    private ProjectVersion versions;
	
}
