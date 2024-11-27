package com.electronicregion.de2.repositories;

import com.electronicregion.de2.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long>
{
}
