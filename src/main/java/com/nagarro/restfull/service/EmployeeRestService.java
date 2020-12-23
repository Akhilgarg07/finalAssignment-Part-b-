package com.nagarro.restfull.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.restfull.entity.Employee;
import com.nagarro.restfull.exception.EmployeeNotFoundException;
import com.nagarro.restfull.repository.EmployeeRepository;

@Service
public class EmployeeRestService {

	private final EmployeeRepository repository;

	EmployeeRestService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public List<Employee> all() {
		return repository.findAll();
	}

	public Employee saveNewEmployee(Employee newEmployee) {
		return repository.save(newEmployee);
	}

	public Employee getEmployeeDetails(Long id) {

		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	public Employee changeEmployeeDetails(Employee newEmployee, Long id) {

		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setLocation(newEmployee.getLocation());
			employee.setEmail(newEmployee.getEmail());
			employee.setDateOfBirth(newEmployee.getDateOfBirth());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}

}
