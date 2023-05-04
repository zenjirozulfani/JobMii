package com.jobmii.JobMii.controllers;

import java.util.List;
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
import com.jobmii.JobMii.services.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Integer id) {
		return userService.getById(id);
	}

	@PutMapping("/{id}")
	public User update(@PathVariable Integer id, @RequestBody User user) {
		return userService.update(id, user);
	}
}
