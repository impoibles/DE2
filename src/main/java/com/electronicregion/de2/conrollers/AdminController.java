package com.electronicregion.de2.conrollers;

import com.electronicregion.de2.models.DismissedEmpoyeesEntity;
import com.electronicregion.de2.repositories.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EmployeesRepo employeesRepo;

    public AdminController(EmployeesRepo employeesRepo) {
        this.employeesRepo = employeesRepo;
    }

    @GetMapping("")
    public String getAdmin(Model model, @RequestParam(required = false) String parametr){
      List<DismissedEmpoyeesEntity> employees = employeesRepo.findAll();
      if(parametr == null || parametr.isEmpty())
          model.addAttribute("employees",employees);
      else {
          List<DismissedEmpoyeesEntity> employeesWithParametr = new ArrayList<>();
          for(DismissedEmpoyeesEntity employee:employees){
              if(employee.getSnils().toString().equals(parametr) ||  employee.getRegion_id().getName().contains(parametr) || employee.getOrganization().contains(parametr) || employee.getEmployeeDolhnost().contains(parametr)|| employee.getReasonOfDismissal().contains(parametr))
                  employeesWithParametr.add(employee);
          }
          model.addAttribute("employees",employeesWithParametr);
      }
        return "admin";
    }

}
