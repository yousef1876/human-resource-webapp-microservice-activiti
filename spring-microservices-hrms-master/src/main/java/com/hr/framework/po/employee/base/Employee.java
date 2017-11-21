package com.hr.framework.po.employee.base;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.persistence.*;

import com.enums.GenderType;
import com.enums.MaritalStatusType;
import com.hr.framework.po.address.City;
import com.hr.framework.po.address.Country;
import com.hr.framework.po.address.State;
import com.hr.framework.po.applicant.ApplicantInterviewedBy;
import com.hr.framework.po.applicant.InterviewQuestion;
import com.hr.framework.po.applicant.Interviews;
import com.hr.framework.po.bug.tracking.users.Bugs;
import com.hr.framework.po.bug.tracking.users.TaskAssignee;
import com.hr.framework.po.bug.tracking.users.Tasks;
import com.hr.framework.po.bug.tracking.users.Teams;
import com.hr.framework.po.employee.base.reports.*;
import com.hr.framework.po.employee.performance.EmployeeCourses;
import com.hr.framework.po.employee.performance.EmployeeJobAssignment;
import com.hr.framework.po.employee.performance.PerformanceReview;
import com.hr.framework.po.issue.tracking.users.IssueComment;

@Entity
@Table(name  = "employees_")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	


	@Column(name = "first_name" , nullable = false)
	private String firstName;

	@Column(name  = "last_name" , nullable = false)
	private String lastName;


	@Column(name  = "minit" , nullable =  true)
	private String minit;

	@Column(name  = "date_of_birth" , nullable =  false)
	private Date dob;

	@Column(name = "ssn" , nullable = false)
	private String ssn;

	@Column(name  = "gender_type" , nullable = false)
	private GenderType genderType;

	@Column(name  = "maital_status" , nullable = false)
	private MaritalStatusType maritalType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id" , nullable = true)
	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id" , nullable = true)
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id" , nullable = true)
	private State state;

	@Column(name  = "email" , nullable = false)
	private String email;

	@Column(name  = "phone" , nullable = false)
	private String phone;

	@Column(name  = "mobile" , nullable = false)
	private String mobile;

	@Column(name  = "work_mobile" , nullable = true)
	private String workMobile;

	@Column(name  = "work_phone" , nullable = true)
	private String workPhone;

	@Column(name  = "login_username" , nullable = false)
	private String login;

	@Column(name  = "password" , nullable = false)
	private String password;

	@Column(name  = "is_admin" , nullable = false)
	private boolean admin;

	@Column(name  = "super_admin" , nullable = false)
	private boolean superadmin;

	@Column(name = "nums_logins" , nullable = false)
	private String numLogins;

	@Column(name  = "last_login_date" , nullable = false)
	private Date lastLoginDate;

	@Column(name  = "date_created" , nullable = false)
	private Date dateCreated;

	@Column(name  = "updated_date" , nullable = true)
	private Date updatedDate;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name  = "department_id" , nullable = false)
	private Department depts;


	@OneToMany(mappedBy = "employees" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Bouns> employees;

	@OneToMany(mappedBy = "createdBy" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Bouns> createdByBouns;




	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "employees" , cascade = CascadeType.ALL)
	private List<Discount> employeesDiscount;

	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "createdBy" , cascade = CascadeType.ALL)
	private List<Discount>  createdBy;

	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "employees" , cascade = CascadeType.ALL)
	private List<EmployeePicture>  pictures;


	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "employees" , cascade = CascadeType.ALL)
	private List<EmployeeType>  types;

	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "employees" , cascade = CascadeType.ALL)
	private List<Holidays> employeesHolidays;

	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "createdBy" , cascade = CascadeType.ALL)
	private List<Holidays> employeesHoliday;


	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "employees" , cascade = CascadeType.ALL)
	private List<Hourly> employeesHourly;


	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "employees" , cascade = CascadeType.ALL)
	private List<JobTitle> employeesJobTitles;


	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "supervisors" , cascade = CascadeType.ALL)
	private List<JobTitle> employeesSupervisors;

	@OneToMany(fetch = FetchType.LAZY ,  mappedBy = "createdBy" , cascade = CascadeType.ALL)
	private List<JobTitle> employeesCreatedBy;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "employees" , cascade =  CascadeType.ALL)
	private List<PayRoll> roles;

	@OneToMany(fetch = FetchType.LAZY , mappedBy =  "employees" , cascade = CascadeType.ALL)
	private List<Salary> salaries;

	@OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "employees" )
	private List<Bugs> bugs;

	@OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "modifyBugs" )
	private List<Bugs> modifyBugs;


	@OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "assignTo" )
	private List<Bugs> assignTo;

	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "createdBy" , cascade =  CascadeType.ALL)
	private List<Teams> teams;

	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "superRole" , cascade =  CascadeType.ALL)
	private List<Teams> superRolesTeam;

	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "assignTo" , cascade =  CascadeType.ALL)
	private List<TaskAssignee> assignToTasksAssignee;

	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "superRole" , cascade =  CascadeType.ALL)
	private List<TaskAssignee> superRolesTasksAssignee;


	@OneToMany(fetch = FetchType.LAZY , mappedBy = "employees" , cascade =  CascadeType.ALL)
	private List<Tasks> tasks;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "employeesModified" , cascade =  CascadeType.ALL)
	private List<Tasks> employeesModified;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "assignTo" , cascade =  CascadeType.ALL)
	private List<Tasks> assignToTasks;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employees")
	private List<EmployeeCourses> courses;


	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "admins")
	private List<EmployeeCourses> coursesAdmins;

	@OneToMany(mappedBy = "employees" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<EmployeeJobAssignment> assignments;


	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employees")
	private List<PerformanceReview> performnaces;


	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "admins")
	private List<PerformanceReview> adminsPerformance;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "createdBy")
	private List<IssueComment> comments;


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "createdBy")
	private List<EmployeeAttendanceTracker> trackers;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employees")
	private List<EmployeeAttendanceTracker> employeeAttendanceTrackerList;


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "createdBy")
	private List<EmployeeEvaluationTemplate> templates;


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employees")
	private List<EmployeeEvaluationTemplate> employeeEvaluationTemplateList;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "createdBy")
	private List<EmployeeScheduleTemplate> scheduleTemplates;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employees")
	private List<EmployeeScheduleTemplate> employeeScheduleTemplateList;


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "createdBy")
    private List<HireCheckList> checkLists;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employees")
	private List<HiringFiles> employeeFiles;


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employees")
	private List<MonthlyTeamWorkSchedule> monthlyTeamWorkSchedules;


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "createdBy")
	private List<MonthlyWorkSchedule> monthlyWorkSchedules;


	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "createdBy")
	private List<PayrollTemplate> payrollTemplates;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employees")
	private List<PayrollTemplate> payrollTemplateList;


    @OneToMany(mappedBy = "createdBy" ,  cascade = CascadeType.ALL , fetch =  FetchType.LAZY)
    private List<RecruitingPlan> recruitingPlans;

	@OneToMany(mappedBy = "employees" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<RecruitingPlan> recruitingPlanList;



	@OneToMany(mappedBy = "createdBy" ,  cascade = CascadeType.ALL , fetch =  FetchType.LAZY)
	private List<TimesheetPlan> timesheetPlans;

	@OneToMany(mappedBy = "employees" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<TimesheetPlan> timesheetPlanList;


	@OneToMany(mappedBy = "createdBy" ,  cascade = CascadeType.ALL , fetch =  FetchType.LAZY)
	private List<TransitionPlanTemplate> transitionPlanTemplates;

	@OneToMany(mappedBy = "employees" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<TransitionPlanTemplate> transitionPlanTemplateList;

	@OneToMany(mappedBy = "createdBy" ,  cascade = CascadeType.ALL , fetch =  FetchType.LAZY)
	private List<VacationScheduleTemplate> vacationScheduleTemplates;

	@OneToMany(mappedBy = "employees" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<VacationScheduleTemplate> vacationScheduleTemplateList;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employee")
	private List<ApplicantInterviewedBy> applicantInterviewedByList;


	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "createdBy")
	private List<ApplicantInterviewedBy> employeeInterviews;


	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "createdBy")
	private List<Interviews> interviews;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "createdBy")
	private List<InterviewQuestion> interviewQuestions;




}
