package com.jobmii.JobMii.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import java.io.ByteArrayOutputStream;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobmii.JobMii.models.Apply_Employee;
import com.jobmii.JobMii.services.ApplyEmployeeService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
// @RequestMapping("/employee")
// @PreAuthorize("hasAnyRole('CLIENT')")
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

	@GetMapping("/job-employee/{id}")
	public List<Apply_Employee> getJobApplicant(@PathVariable int id) {
		return applyEmployeeService.getJobApplicant(id);
	}

	@GetMapping("/data-accept/{id}")
	public List<Apply_Employee> getJobAcc(@PathVariable int id) {
		return applyEmployeeService.getDataAcc(id);
	}

	@GetMapping("/job-client/{id}")
	public List<Apply_Employee> getJobApplyClient(@PathVariable int id) {
		return applyEmployeeService.getJobApply(id);
	}

	@GetMapping("/apply-employee-id")
	public List<Apply_Employee> getByIdEmployee() {
		return applyEmployeeService.getByIdEmployee();
	}

	@PostMapping("/apply-employee/create")
	public void create(@RequestBody Apply_Employee applyEmployee) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, MessagingException, IOException, TemplateException {
		applyEmployeeService.create(applyEmployee);
	}

	@PutMapping("/apply-employee/{id}")
	public void update(
			@PathVariable Integer id,
			@RequestBody Apply_Employee applyEmployee) {
		applyEmployeeService.update(id, applyEmployee);
	}

	@PutMapping("/user-role/{id}")
	public void updateUserRole(
			@PathVariable Integer id) {
		applyEmployeeService.updateUserRole(id);
	}

	@DeleteMapping("/apply-employee/{id}")
	public void delete(@PathVariable Integer id) {
		applyEmployeeService.delete(id);
	}

	@GetMapping("/export/{vacancyId}")
	public ResponseEntity<Resource> dataEmployee(@PathVariable Integer vacancyId) {
		Workbook workbook = applyEmployeeService.dataEmploye(vacancyId);
		ByteArrayResource resource;
		HttpHeaders headers = new HttpHeaders();

		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			workbook.write(outputStream);
			resource = new ByteArrayResource(outputStream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		headers.add("Content-Disposition", "attachment; filename=employee_accepted.xlsx");
		headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		return ResponseEntity.ok()
				.headers(headers)
				.body(resource);
	}
}
