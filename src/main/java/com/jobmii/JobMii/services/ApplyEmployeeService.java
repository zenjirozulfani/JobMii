package com.jobmii.JobMii.services;

import com.jobmii.JobMii.models.Apply_Employee;
import com.jobmii.JobMii.models.History;
import com.jobmii.JobMii.repositories.ApplyEmployeeRepository;
import com.jobmii.JobMii.repositories.HistoryRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ApplyEmployeeService {

	private ApplyEmployeeRepository applyEmployeeRepository;
	private HistoryRepository historyRepository;

	public List<Apply_Employee> getAll() {
		return applyEmployeeRepository.findAll();
	}

	public Apply_Employee getById(Integer id) {
		return applyEmployeeRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Employee not found!!"));
	}

	public void create(Apply_Employee applyEmployee) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		applyEmployee.setApply_date(formatter.format(date));
		applyEmployeeRepository.save(applyEmployee);

		History history = new History();
		history.setApply_employee(applyEmployee);
		history.setStatus(applyEmployee.getStatus());
		history.setUpdate_date(formatter.format(date));

		historyRepository.save(history);

	}

	public void update(Integer id, Apply_Employee applyEmployee) {
		getById(id); // method getById
		applyEmployee.setId(id);
		applyEmployee.setApply_date(applyEmployee.getApply_date());
		applyEmployeeRepository.save(applyEmployee);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		History history = new History();
		history.setApply_employee(applyEmployee);
		history.setStatus(applyEmployee.getStatus());
		history.setUpdate_date(formatter.format(date));

		historyRepository.save(history);
	}

	public void delete(Integer id) {
		Apply_Employee applyEmployee = getById(id);
		applyEmployeeRepository.delete(applyEmployee);

	}
}