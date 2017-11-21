package com.enums;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name  = "payroll_check")
public enum PayrollCheck {

    RegularEarnings("RegularEarnings"),
    OvertimeEarnings("OvertimeEarnings"),
    BackPay("BackPay"),HolidayEarnings("HolidayEarnings"),VacationEarnings("VacationEarnings");

    private String url;

    PayrollCheck(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
