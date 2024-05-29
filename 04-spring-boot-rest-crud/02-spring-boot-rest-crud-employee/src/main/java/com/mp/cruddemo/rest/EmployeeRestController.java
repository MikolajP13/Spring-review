package com.mp.cruddemo.rest;

import com.mp.cruddemo.entity.Employee;
import com.mp.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> employeeList() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        if (employeeId == null || employeeId < 1)
            throw new RuntimeException("Employee id not found - " + employeeId);

        return this.employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0L); // force save of a new item instead of update
        return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
       return this.employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        Employee employee = this.employeeService.findById(employeeId);
        if (employee == null || employeeId < 1)
            throw new RuntimeException("Employee id not found - " + employeeId);

        this.employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
