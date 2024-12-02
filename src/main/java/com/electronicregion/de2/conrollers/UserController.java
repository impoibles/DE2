package com.electronicregion.de2.conrollers;

import com.electronicregion.de2.models.RegionEntity;
import com.electronicregion.de2.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

        @Autowired
        RegionRepo regionRepo;

        //    @GetMapping("/all")
//    public List<Employee> getAllEmloyees(){
//        return employeeRepo.findAll();
//    }
        @GetMapping("")
        public String getUser(Model model){
           List<RegionEntity> regions = regionRepo.findAll();
           model.addAttribute("regions",regions);
            return "user";
        }


}
