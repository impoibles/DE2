package com.electronicregion.de2.conrollers;

import com.electronicregion.de2.models.DismissedEmpoyeesEntity;
import com.electronicregion.de2.repositories.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EmployeesRepo employeesRepo;

    public AdminController(EmployeesRepo employeesRepo) {
        this.employeesRepo = employeesRepo;
    }


    //    @GetMapping("/all")
//    public List<Employee> getAllEmloyees(){
//        return employeeRepo.findAll();
//    }
    @GetMapping("")
    public String getAdmin(Model model){
      List<DismissedEmpoyeesEntity> employees = employeesRepo.findAll();
        System.out.println(employees.size());
       model.addAttribute("employeeRepo",employees);
        return "admin";
    }
}
