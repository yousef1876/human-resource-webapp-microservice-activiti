package com.hr.framework.po.applicant;


import com.hr.framework.po.employee.base.Employee;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "applicant_interviewed_by_employees")
public class ApplicantInterviewedBy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id" , nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "interview_id" , nullable = false)
    private Interviews interviews;

    @Column(name  = "created_date" , nullable = false)
    private Date createdDate;

    @Column(name  = "updated_date" , nullable = true)
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_date" , nullable = false)
    private Employee createdBy;

    @Column(name = "is_active" , nullable = false)
    private boolean isactive;


}
