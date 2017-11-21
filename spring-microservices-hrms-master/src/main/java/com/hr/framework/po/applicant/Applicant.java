package com.hr.framework.po.applicant;

import com.hr.framework.po.address.City;
import com.hr.framework.po.address.Country;
import com.hr.framework.po.address.State;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name  = "first_name" , nullable = false)
    private String firstName;

    @Column(name  = "second_name" , nullable = false)
    private String secondName;

    @Column(name  = "last_name" , nullable = false)
    private String lastName;

    @Column(name  = "initial" , nullable = false)
    private String initial;

    @Column(name  = "id_no" , nullable = false)
    private String idNo;

    @Column(name  = "passport" , nullable = true)
    private String passportNo;

    @ManyToOne()
    @JoinColumn(name = "city_id" , nullable = true)
    private City city;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "country_id" , nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "state_id" , nullable = true)
    private State state;

    @Column(name = "mobile" , nullable = false)
    private String mobile;

    @Column(name  = "phone" , nullable = true)
    private String phone;

    @Column(name = "login" , nullable = false)
    private String login;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "is_active" , nullable = false)
    private boolean isactive;

    @Column(name  = "is_blocked" , nullable = true)
    private boolean isblock;




    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "applicant")
    private List<ApplicantAttachment> applicantAttachmentList;


    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "applicant")
    private List<ApplicantExperience>  applicantExperienceList;


    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "applicant")
    private List<ApplicantQualification>  applicantQualificationList;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "applicant")
    private List<ApplicantSkills>  applicantSkillsList;


    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "applicant")
    private List<Interviews> interviews;





}
