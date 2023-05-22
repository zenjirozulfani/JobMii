package com.jobmii.JobMii.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jobmii.JobMii.models.Employee;
import com.jobmii.JobMii.models.dto.requests.EmployeeRequest;
import com.jobmii.JobMii.repositories.EmployeeRepository;
import com.jobmii.JobMii.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	private final String UPLOAD_DIR = "D:/MCC/Segmen4/Jobmii-ClientApp/src/main/resources/templates/pdf";
	private ModelMapper modelMapper;
	private EmployeeRepository employeeRepository;
	private UserRepository userRepository;

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public int getEmployee() {
		return employeeRepository.countEmployee();
	}

	public int getEmployeeJob() {
		return employeeRepository.countEmployeeJob();
	}

	public int getEmployeeNoJob() {
		return employeeRepository.countEmployeeNoJob();
	}

	public List<Employee> getForApplyEmployee() {
		return employeeRepository.tampilApplyEmployee();
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.getAllEmployee();
	}

	public List<Employee> getAllEmployeeCV() {
		return employeeRepository.getAllEmployeeCV();
	}

	public List<Employee> getAllHr() {
		return employeeRepository.getAllHr();
	}

	public List<Employee> getAllClient() {
		return employeeRepository.getAllClient();
	}

	public Employee getById(Integer id) {
		return employeeRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Employee not found!!"));
	}

	public Employee getByUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return employeeRepository.findByUser_Username(username);
	}

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee update(Integer id, Employee employee) {
		getById(id); // method getById
		employee.setId(id);
		return employeeRepository.save(employee);
	}

	public Employee updateMapping(Integer id, Employee employee) {
		getById(id); // method getById
		employee.setId(id);
		employee.setStatus(false);
		return employeeRepository.save(employee);
	}

	public Employee rejectMapping(Integer id, Employee employee) {
		getById(id); // method getById
		employee.setId(id);
		employee.setStatus(false);
		return employeeRepository.save(employee);
	}

	public Employee acceptMapping(Integer id, Employee employee) {
		getById(id); // method getById
		employee.setId(id);
		employee.setStatus(true);
		return employeeRepository.save(employee);
	}

	public void updateEmployee(Integer id, EmployeeRequest employeeRequest) {
		Employee emp = getById(id); // method getById
		emp.setName(employeeRequest.getName());
		emp.setPhone(employeeRequest.getPhone());
		emp.setCv(employeeRequest.getCv());
		Employee existingUser = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));

		modelMapper.map(employeeRequest, existingUser);

		employeeRepository.save(existingUser);
	}

	public void delete(Integer id) {
		Employee employee = getById(id);
		employeeRepository.delete(employee);

	}
}