package com.jobmii.JobMii.services;

import com.jobmii.JobMii.models.Employee;
import com.jobmii.JobMii.repositories.EmployeeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.getAllEmployee();
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

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee update(Integer id, Employee employee) {
		getById(id); // method getById
		employee.setId(id);
		return employeeRepository.save(employee);
	}

	public void delete(Integer id) {
		Employee employee = getById(id);
		employeeRepository.delete(employee);

	}
}