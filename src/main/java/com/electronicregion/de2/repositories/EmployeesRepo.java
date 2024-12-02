package com.electronicregion.de2.repositories;

import com.electronicregion.de2.models.DismissedEmpoyeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepo extends JpaRepository<DismissedEmpoyeesEntity, Long> {
}
