package com.electronicregion.de2.models;

import jakarta.persistence.*;



@Entity
@Table(name = "DismissedEmpoyees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @Column
    private String employee_name;
    @Column
    private  String employee_surName;
    @Column
    private String employee_patronymic;

    @Column(unique = true)
    private Long employee_number_of_snils;

    @Column
    private String employee_reason_of_dismissal;
    @Column
    private String employee_organization;

    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
    public String getEmployee_organization() {
        return employee_organization;
    }

    public void setEmployee_organization(String employee_organization) {
        this.employee_organization = employee_organization;
    }



    public Long getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_surName() {
        return employee_surName;
    }

    public void setEmployee_surName(String employee_surName) {
        this.employee_surName = employee_surName;
    }

    public String getEmployee_patronymic() {
        return employee_patronymic;
    }

    public void setEmployee_patronymic(String employee_patronymic) {
        this.employee_patronymic = employee_patronymic;
    }

    public Long getEmployee_number_of_snils() {
        return employee_number_of_snils;
    }

    public void setEmployee_number_of_snils(Long employee_number_of_snils) {
        this.employee_number_of_snils = employee_number_of_snils;
    }

    public String getEmployee_reason_of_dismissal() {
        return employee_reason_of_dismissal;
    }

    public void setEmployee_reason_of_dismissal(String employee_reason_of_dismissal) {
        this.employee_reason_of_dismissal = employee_reason_of_dismissal;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}

