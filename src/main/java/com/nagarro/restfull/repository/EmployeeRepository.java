package com.nagarro.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.restfull.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}