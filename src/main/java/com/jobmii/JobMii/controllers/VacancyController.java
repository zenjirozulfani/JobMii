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

import com.jobmii.JobMii.models.Vacancy;
import com.jobmii.JobMii.services.VacancyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
	@Autowired
	private VacancyService vacancyService;

	@GetMapping
	public List<Vacancy> getAll() {
		return vacancyService.getAll();
	}
}
