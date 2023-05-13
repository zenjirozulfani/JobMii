package com.jobmii.JobMii.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.jobmii.JobMii.models.Employee;
import com.jobmii.JobMii.models.Role;
import com.jobmii.JobMii.models.User;
import com.jobmii.JobMii.models.dto.requests.ClientRequest;
import com.jobmii.JobMii.models.dto.requests.EmployeeRequest;
import com.jobmii.JobMii.models.dto.requests.LoginRequest;
import com.jobmii.JobMii.models.dto.responses.LoginResponse;
import com.jobmii.JobMii.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private AppUserDetailService appUserDetailService;
	private ModelMapper modelMapper;
	private PasswordEncoder passwordEncoder;
	private RoleService roleService;

	public LoginResponse login(LoginRequest loginRequest) {
		// login request
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
				loginRequest.getUsername(),
				loginRequest.getPassword());

		// set principle
		Authentication auth = authenticationManager.authenticate(authReq);
		SecurityContextHolder.getContext().setAuthentication(auth);

		User user = userRepository
				.findByUsernameOrEmployee_Email(
						loginRequest.getUsername(),
						loginRequest.getUsername())
				.get();

		UserDetails userDetails = appUserDetailService.loadUserByUsername(
				loginRequest.getUsername());

		List<String> authorities = userDetails
				.getAuthorities()
				.stream()
				.map(authority -> authority.getAuthority())
				.collect(Collectors.toList());

		return new LoginResponse(
				user.getUsername(),
				user.getEmployee().getEmail(),
				authorities);
	}

	public void createClient(ClientRequest clientRequest) {
		Employee employee = modelMapper.map(clientRequest, Employee.class);
		User user = modelMapper.map(clientRequest, User.class);

		// set password
		user.setPassword(passwordEncoder.encode(clientRequest.getPassword()));

		// set Role
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.getById(3));
		user.setRoles(roles);

		employee.setUser(user);
		user.setEmployee(employee);
		userRepository.save(user);
	}

	public void createEmployee(EmployeeRequest employeeRequest) {
		Employee employee = modelMapper.map(employeeRequest, Employee.class);
		User user = modelMapper.map(employeeRequest, User.class);

		// set password
		user.setPassword(passwordEncoder.encode(employeeRequest.getPassword()));

		// set Role
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.getById(1));
		user.setRoles(roles);

		employee.setStatus(false);
		employee.setUser(user);
		user.setEmployee(employee);
		userRepository.save(user);
	}
}
