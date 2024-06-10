package com.mp.springboot.thymeleafdemo.dao;

import com.mp.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();

}
