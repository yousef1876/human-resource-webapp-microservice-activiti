package com.hr.framework.po.applicant;


import com.hr.framework.po.employee.base.Employee;
import com.hr.framework.po.person.Employer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "applicant_experience")
public class ApplicantExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name  = "created_date" , nullable = false)
    private Date createdDate;

    @Column(name  = "updated_dated" , nullable = true)
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "applicant_id" , nullable = false)
    private Applicant applicant;

    @Column(name  = "summary" , nullable = false)
    private String summary;

    @Column(name  = "experience" , nullable = false)
    private String experienceYears;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "employer_id" , nullable = false)
    private Employer employer;


}
