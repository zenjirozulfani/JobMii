package com.jobmii.JobMii.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobmii.JobMii.models.User;
import com.jobmii.JobMii.models.dto.requests.ClientRequest;
import com.jobmii.JobMii.models.dto.requests.EmployeeRequest;
import com.jobmii.JobMii.models.dto.requests.LoginRequest;
import com.jobmii.JobMii.models.dto.responses.LoginResponse;
import com.jobmii.JobMii.services.AuthService;
import com.jobmii.JobMii.services.EmailService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthController {
	private EmailService emailService;
	private AuthService authService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}

	@PostMapping("/register-client")
	public void createClient(@RequestBody ClientRequest clientRequest) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, MessagingException, IOException, TemplateException {
		authService.createClient(clientRequest);
		emailService.sendEmailClient(clientRequest);
	}

	@PostMapping("/register-hr")
	public void createHr(@RequestBody EmployeeRequest employeeRequest) throws MessagingException,
			TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {

		authService.createHr(employeeRequest);
		emailService.sendEmailFix(employeeRequest);
	}

	@PostMapping("/register-employee")
	public void createEmployee(@RequestBody EmployeeRequest employeeRequest) throws MessagingException,
			TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {

		authService.createEmployee(employeeRequest);
		emailService.sendEmailFix(employeeRequest);
	}
}
