package com.mp.springboot.thymeleafdemo.controller;

import com.mp.springboot.thymeleafdemo.entity.Employee;
import com.mp.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employeeList = this.employeeService.findAll();
        model.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    // add mapping for "/showFormForAdd"
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    // add mapping for "/save"
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        this.employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    // add mapping for "/showFormForUpdate"
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        // get the employee from the service
        Employee employee = this.employeeService.findById(id);

        // set employee in the model to prepopulate the form
        model.addAttribute("employee", employee);

        // send over to form
        return "employees/employee-form";
    }

    // add mapping for "/delete"
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        this.employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
