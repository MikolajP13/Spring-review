package com.mp.cruddemo.dao;

import com.mp.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
