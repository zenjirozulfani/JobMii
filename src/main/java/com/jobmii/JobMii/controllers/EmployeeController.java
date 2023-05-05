package com.jobmii.JobMii.controllers;

import java.util.List;
import lombok.AllArgsConstructor;
import com.jobmii.JobMii.models.Employee;
import com.jobmii.JobMii.services.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
// @RequestMapping("/employee")
// @PreAuthorize("hasAnyRole('USER','ADMIN')")
public class EmployeeController {

	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("employee-mii")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("employee-client")
	public List<Employee> getAllClient() {
		return employeeService.getAllClient();
	}

	@GetMapping("/employee/{id}")
	public Employee getById(@PathVariable Integer id) {
		return employeeService.getById(id);
	}

	@PutMapping("/employee/{id}")
	public Employee update(
			@PathVariable Integer id,
			@RequestBody Employee employee) {
		return employeeService.update(id, employee);
	}

	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable Integer id) {
		employeeService.delete(id);
	}
}
