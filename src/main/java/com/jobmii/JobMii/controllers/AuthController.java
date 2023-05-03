package com.jobmii.JobMii.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobmii.JobMii.models.User;
import com.jobmii.JobMii.models.dto.requests.ClientRequest;
import com.jobmii.JobMii.models.dto.requests.EmployeeRequest;
import com.jobmii.JobMii.models.dto.requests.LoginRequest;
import com.jobmii.JobMii.models.dto.responses.LoginResponse;
import com.jobmii.JobMii.services.AuthService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthController {
	private AuthService authService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}

	@PostMapping("/register-client")
	public User createClient(@RequestBody ClientRequest clientRequest) {
		return authService.createClient(clientRequest);
	}

	@PostMapping("/register-employee")
	public User createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		return authService.createEmployee(employeeRequest);
	}
}
