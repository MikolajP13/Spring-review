package com.mp.springboot.thymeleafdemo.service;

import com.mp.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.mp.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);

        return optionalEmployee.orElseThrow(() -> new RuntimeException("Did not find employee id - " + id));
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
