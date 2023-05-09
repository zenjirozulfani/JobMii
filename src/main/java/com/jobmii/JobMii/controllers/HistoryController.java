package com.jobmii.JobMii.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobmii.JobMii.models.History;
import com.jobmii.JobMii.models.Vacancy;
import com.jobmii.JobMii.services.HistoryService;
import com.jobmii.JobMii.services.VacancyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private HistoryService historyService;

	@GetMapping
	public List<History> getAll() {
		return historyService.getAll();
	}

	@PostMapping("/create")
	public History create(@RequestBody History history) {
		return historyService.create(history);
	}

	@GetMapping("/{id}")
	public History getById(@PathVariable int id) {
		return historyService.getByid(id);
	}

	@PutMapping("/update/{id}")
	public History update(@PathVariable Integer id, @RequestBody History history) {
		return historyService.update(id, history);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		historyService.delete(id);
	}

}
