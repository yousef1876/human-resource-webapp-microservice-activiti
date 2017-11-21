package com.hr.framework.po.bug.tracking.users;


import com.hr.framework.po.employee.base.Department;
import com.hr.framework.po.employee.base.Employee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "team_name" , nullable = false)
    private String teamName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "department_id" , nullable = false)
    private Department depts;

    @Column(name  = "created_date" , nullable = false)
    @Temporal( TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private Employee createdBy;

    @Column(name  = "updated_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "super_role" , nullable = false)
    private Employee superRole;

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "note" , nullable = true)
    private String note;

    @Column(name  = "active" , nullable = true)
    private boolean active;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Department getDepts() {
        return depts;
    }

    public void setDepts(Department depts) {
        this.depts = depts;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Employee getSuperRole() {
        return superRole;
    }

    public void setSuperRole(Employee superRole) {
        this.superRole = superRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
