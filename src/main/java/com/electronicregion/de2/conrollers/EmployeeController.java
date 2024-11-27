package com.electronicregion.de2.conrollers;

import com.electronicregion.de2.models.Employee;
import com.electronicregion.de2.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/dismissedEmployees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;


    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    //    @GetMapping("/{name}")
//    public List<Employee> getEmployee_for_name(@PathVariable String employeeName) {
//        return employeesRepo.findAllByFullName(employeeName);
//    }
//    @GetMapping("/{number_of_snils}")
//    public Optional<Employee> getEmployee_for_number_of_snils(@PathVariable Long number_of_snils) {
//        return employeesRepo.findAllByEmployee_number_of_snils(number_of_snils);
//    }
//    @GetMapping("/{region}")
//    public List<Employee> getEmployee_for_region(@PathVariable Regions region) {
//        return employeesRepo.findAllByRegion(region);
//    }

}
