package com.jobmii.JobMii.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobmii.JobMii.models.User;
import com.jobmii.JobMii.repositories.EmployeeRepository;
import com.jobmii.JobMii.repositories.UserRepository;
import com.jobmii.JobMii.services.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	private UserRepository userRepository;
	private EmployeeRepository employeeRepository;

	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Integer id) {
		return userService.getById(id);
	}

	@GetMapping("/count-employee")
	public int getCountEmployee() {
		return userService.countEmployee();
	}

	@GetMapping("/count-employee-job")
	public int getCountEmployeeJob() {
		return userService.countEmployeeJob();
	}

	@GetMapping("/count-client")
	public int getCountClient() {
		return userService.countClient();
	}

	@PutMapping("/{id}")
	public User update(@PathVariable Integer id, @RequestBody User user) {
		return userService.update(id, user);
	}

	@GetMapping("/check-username/{username}")
	public Map<String, Boolean> checkUsername(@PathVariable String username) {
		boolean isTaken = userRepository.findByUsername(username) != null;
		Map<String, Boolean> response = new HashMap<>();
		response.put("isTaken", isTaken);
		return response;
	}

	@GetMapping("/check-email/{email}")
	public Map<String, Boolean> checkEmail(@PathVariable String email) {
		boolean isTaken = employeeRepository.findByEmail(email) != null;
		Map<String, Boolean> response = new HashMap<>();
		response.put("isTaken", isTaken);
		return response;
	}
}
