package com.hr.framework.po.applicant;

import javax.persistence.*;

@Entity
@Table(name  = "applicant_skills")
public class ApplicantSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "employer_name" , nullable = false)
    private String employerName;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "employer_code" , nullable = false)
    private String employerCode;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "head_addrs_name" , nullable = false)
    private String headAddName;

    @Column(name = "head_phone" )
    private String headphone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "applicant_id" , nullable = false)
    private Applicant applicant;
}
