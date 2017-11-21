package com.hr.framework.po.employee.base.reports;


import com.hr.framework.po.employee.base.Employee;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "time_sheet_plan")
public class TimesheetPlan {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name  = "created_date" , nullable = false)
    private Date createdDate;

    @Column(name  = "updated_date" , nullable = true)
    private Date updatedDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "created_by" , nullable = false)
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name  = "employee_id" , nullable = false)
    private Employee employees;

    @Column(name  = "fromDate" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fromDate;

    @Column(name = "toDate" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date toDate;


    @Column(name  = "regular_hours" , nullable = false)
    private String regularHours;

    @Column(name  = "over_time_hourly_rate" , nullable = true)
    private String overTimeHourlyRate;

    @Column(name  = "sick" , nullable = true)
    private boolean sick;

    @Column(name  = "vacation" , nullable = true)
    private boolean vaction;

    @Column(name  = "holiday" , nullable = true)
    private boolean holidy;

    @Column(name = "others" , nullable = true)
    private boolean others;

    @Column(name  = "total_hours" , nullable = true)
    private String totalHours;



}
