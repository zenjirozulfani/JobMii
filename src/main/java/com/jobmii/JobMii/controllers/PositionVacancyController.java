package com.jobmii.JobMii.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jobmii.JobMii.models.PositionVacancy;
import com.jobmii.JobMii.models.dto.requests.PositionVacancyRequest;
import com.jobmii.JobMii.services.PositionVacancyService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/position-vacancy")
public class PositionVacancyController {

	private PositionVacancyService positionVacancyService;
	
	@GetMapping
	public List<PositionVacancy> getAll() {
		return positionVacancyService.getAll();
	}


	@PostMapping
	public ResponseEntity<PositionVacancy> createPositionVacancy(@RequestBody PositionVacancyRequest request) {
		PositionVacancy positionVacancy = positionVacancyService.createPositionVacancy(request);
		return ResponseEntity.ok(positionVacancy);
	}

}