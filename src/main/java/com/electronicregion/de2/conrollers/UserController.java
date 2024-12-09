package com.electronicregion.de2.conrollers;

import com.electronicregion.de2.models.DismissedEmpoyeesEntity;
import com.electronicregion.de2.models.RegionEntity;
import com.electronicregion.de2.models.addedEmployee;
import com.electronicregion.de2.repositories.EmployeesRepo;
import com.electronicregion.de2.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

        @Autowired
        RegionRepo regionRepo;

        @Autowired
        EmployeesRepo employeesRepo;

        @GetMapping("")
        public String getAdderForm(Model model){
           List<RegionEntity> regions = regionRepo.findAll();
           model.addAttribute("regions",regions);
            return "user";

        }

        @PostMapping("")
        public void addEmployee(@ModelAttribute addedEmployee employee){
            DismissedEmpoyeesEntity new_employee = new DismissedEmpoyeesEntity();
            List<RegionEntity> regions = regionRepo.findAll();
            RegionEntity region = regions.get(employee.getRegion_id()-1);
            new_employee.setSnils(employee.getSnils());
            new_employee.setOrganization(employee.getOrganization());
            new_employee.setReasonOfDismissal(employee.getReasonOfDismissal());
            new_employee.setRegion_id(region);
            new_employee.setEmployeeDolhnost(employee.getEmployeeDolhnost());
            String[] fio = employee.getFIO().split(" ");
            new_employee.setSurName(fio[0]);
            new_employee.setName(fio[1]);
            new_employee.setPatronymic(fio[2]);
            employeesRepo.save(new_employee);
        }


}
