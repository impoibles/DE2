package com.electronicregion.de2.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "dismissed_empoyees")
public class DismissedEmpoyeesEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id", nullable = false)
    private long Id;
    @Basic
    @Column(name = "employee_sur_name", nullable = false, length = 255)
    private String SurName;
    @Basic
    @Column(name = "employee_name", nullable = false, length = 255)
    private String Name;
    @Basic
    @Column(name = "employee_patronymic", nullable = true, length = 255)
    private String Patronymic;
    @Basic
    @Column(name = "employee_number_of_snils", nullable = false)
    private Long Snils;
    @Basic
    @Column(name = "employee_organization", nullable = false, length = 255)
    private String Organization;
    @Basic
    @Column(name = "employee_dolhnost", nullable = false, length = 150)
    private String employeeDolhnost;
    @Basic
    @Column(name = "employee_reason_of_dismissal", nullable = false, length = 255)
    private String ReasonOfDismissal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId")
    private RegionEntity region_id;
}
