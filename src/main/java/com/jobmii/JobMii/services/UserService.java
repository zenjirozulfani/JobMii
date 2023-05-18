package com.jobmii.JobMii.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jobmii.JobMii.models.User;
import com.jobmii.JobMii.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public int countEmployee() {
		return userRepository.countUsersByRoleId();
	}

	public int countEmployeeJob() {
		return userRepository.countEmployeeJob();
	}

	public int countClient() {
		return userRepository.countClientByRoleId();
	}

	public User getById(Integer id) {
		return userRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Data User not found!!!"));
	}

	public User update(Integer id, User user) {
		User userRole = getById(id);
		user.setId(id);
		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setPassword(user.getPassword());
		user.setRoles(userRole.getRoles());
		return userRepository.save(user);
	}
}
