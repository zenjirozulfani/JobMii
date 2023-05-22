package com.jobmii.JobMii.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import lombok.AllArgsConstructor;
import com.jobmii.JobMii.models.Employee;
import com.jobmii.JobMii.models.dto.requests.EmployeeRequest;
import com.jobmii.JobMii.services.EmailService;
import com.jobmii.JobMii.services.EmployeeService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
// @RequestMapping("/employee")
// @PreAuthorize("hasAnyRole('CLIENT')")
public class EmployeeController {

	private EmailService emailService;
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/employee-all")
	public int getAllEmployee() {
		return employeeService.getEmployee();
	}

	@GetMapping("/employee-free")
	public List<Employee> getEmployeeFree() {
		return employeeService.getForApplyEmployee();
	}

	@GetMapping("/employee-job")
	public int getEmployeeJob() {
		return employeeService.getEmployeeJob();
	}

	@GetMapping("/employee-nojob")
	public int getEmployeeNotJob() {
		return employeeService.getEmployeeNoJob();
	}

	@GetMapping("/employee-mii")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employee-cv")
	public List<Employee> getAllEmployeesCV() {
		return employeeService.getAllEmployeeCV();
	}

	@GetMapping("/employee-hr")
	public List<Employee> getAllHr() {
		return employeeService.getAllHr();
	}

	@GetMapping("/employee-client")
	public List<Employee> getAllClient() {
		return employeeService.getAllClient();
	}

	@GetMapping("/employee-login")
	public Employee getByUsername() {
		return employeeService.getByUsername();
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

	@PutMapping("/update-mapping/{id}")
	public Employee updateMapping(
			@PathVariable Integer id,
			@RequestBody Employee employee) {
		return employeeService.updateMapping(id, employee);
	}

	@PutMapping("/reject-mapping/{id}")
	public void rejectMapping(
			@PathVariable Integer id,
			@RequestBody Employee employee) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, MessagingException, IOException, TemplateException {
		employeeService.rejectMapping(id, employee);
		emailService.sendEmailReject(employee);
	}

	@PutMapping("/update-employee/{id}")
	public void updateEmployee(
			@PathVariable Integer id,
			@RequestBody EmployeeRequest employee) {
		employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable Integer id) {
		employeeService.delete(id);
	}
}
