package com.nagarro.restfull.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restfull.entity.Employee;
import com.nagarro.restfull.service.EmployeeRestService;

@RestController
public class EmployeeRestController {

	private final EmployeeRestService restService;;

	EmployeeRestController(EmployeeRestService restService) {
		this.restService = restService;
	}

	@GetMapping("/employees")
	List<Employee> all() {
		return restService.all();
	}

	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return restService.saveNewEmployee(newEmployee);
	}

	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {

		return restService.getEmployeeDetails(id);
	}

	@PutMapping("/employees/{id}")
	public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return restService.changeEmployeeDetails(newEmployee, id);
	}

}
