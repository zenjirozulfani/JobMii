package com.jobmii.JobMii.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobmii.JobMii.models.Position;
import com.jobmii.JobMii.models.PositionVacancy;
import com.jobmii.JobMii.models.Vacancy;
import com.jobmii.JobMii.models.dto.requests.PositionVacancyRequest;
import com.jobmii.JobMii.models.key.PositionVacancyKey;
import com.jobmii.JobMii.repositories.PositionRepository;
import com.jobmii.JobMii.repositories.VacancyRepository;
import com.jobmii.JobMii.services.PositionVacancyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PositionVacancyController {

	private PositionVacancyService positionVacancyService;
	private PositionRepository positionRepository;
	private VacancyRepository vacancyRepository;

	@PostMapping("/position-vacancy/create")
	public PositionVacancy create(@RequestBody PositionVacancy position) {
		return positionVacancyService.create(position);
	}

	// @PostMapping("/position-vacancies")
	// public ResponseEntity<PositionVacancy> createPositionVacancy(@RequestBody
	// PositionVacancyRequest request) {
	// PositionVacancyKey key = new PositionVacancyKey(request.getPositionId(),
	// request.getVacancyId());
	// Position position = positionRepository.findById(request.getPositionId());

	// Vacancy vacancy = vacancyRepository.findById(request.getVacancyId())
	// .orElseThrow(() -> new NotFoundException("Vacancy not found"));
	// PositionVacancy positionVacancy = positionVacancyService.create(key,
	// request.getQuota(), position, vacancy);
	// return ResponseEntity.status(HttpStatus.CREATED).body(positionVacancy);
	// }
}
