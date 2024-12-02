package com.electronicregion.de2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Entity
@Table(name = "dismissed_empoyees")
public class DismissedEmpoyeesEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id", nullable = false)
    private long employeeId;
    @Basic
    @Column(name = "employee_name", nullable = true, length = 255)
    private String employeeName;
    @Basic
    @Column(name = "employee_number_of_snils", nullable = true)
    private Long employeeNumberOfSnils;
    @Basic
    @Column(name = "employee_organization", nullable = true, length = 255)
    private String employeeOrganization;
    @Basic
    @Column(name = "employee_patronymic", nullable = true, length = 255)
    private String employeePatronymic;
    @Basic
    @Column(name = "employee_reason_of_dismissal", nullable = true, length = 255)
    private String employeeReasonOfDismissal;
    @Basic
    @Column(name = "employee_sur_name", nullable = true, length = 255)
    private String employeeSurName;
    @ManyToOne(fetch = FetchType.LAZY)
    private RegionEntity region_id;


    @Basic
    @Column(name = "employee_dolhnost", nullable = true, length = 150)
    private String employeeDolhnost;


}
