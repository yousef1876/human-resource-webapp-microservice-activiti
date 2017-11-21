package com.hr.framework.po.applicant;

import com.enums.PositionType;
import com.hr.framework.po.address.City;
import com.hr.framework.po.address.Country;
import com.hr.framework.po.employee.base.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "interviews")
public class Interviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @Column(name  = "title" , nullable = false)
    private String title;

    @Column(name  = "created_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name  = "updated_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by" , nullable = false)
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name = "city_id" , nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name  = "country_id" , nullable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "applicant" , nullable = false)
    private Applicant applicant;


    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "position_id" , nullable = false)
    private Positions position;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "interview")
    private List<InterviewQuestion> interviewQuestions;


}
