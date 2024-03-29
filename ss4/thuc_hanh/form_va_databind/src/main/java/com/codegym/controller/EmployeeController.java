package com.codegym.controller;


import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee/")
public class EmployeeController {

    @RequestMapping(value = "showForm" , method = RequestMethod.GET)
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String sumbit(@ModelAttribute("employee") Employee employee, ModelMap modelMap){
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("contractNumber", employee.getContractNumber());
        modelMap.addAttribute("id",employee.getId());
        return "employee/info";
    }
}
