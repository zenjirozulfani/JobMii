package com.jobmii.JobMii.controllers;

import java.util.List;
import lombok.AllArgsConstructor;

import com.jobmii.JobMii.models.Apply_Employee;
import com.jobmii.JobMii.models.Employee;
import com.jobmii.JobMii.services.ApplyEmployeeService;
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
public class ApplyEmployeeController {

	private ApplyEmployeeService applyEmployeeService;

	@GetMapping("/apply-employee")
	public List<Apply_Employee> getAll() {
		return applyEmployeeService.getAll();
	}

	@GetMapping("/apply-employee/{id}")
	public Apply_Employee getById(@PathVariable Integer id) {
		return applyEmployeeService.getById(id);
	}

	@PostMapping("/apply-employee/create")
	public void create(@RequestBody Apply_Employee applyEmployee) {
		applyEmployeeService.create(applyEmployee);
	}

	@PutMapping("/apply-employee/{id}")
	public void update(
			@PathVariable Integer id,
			@RequestBody Apply_Employee applyEmployee) {
		applyEmployeeService.update(id, applyEmployee);
	}

	@DeleteMapping("/apply-employee/{id}")
	public void delete(@PathVariable Integer id) {
		applyEmployeeService.delete(id);
	}
}
