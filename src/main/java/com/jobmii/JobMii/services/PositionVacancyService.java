package com.jobmii.JobMii.services;

import com.jobmii.JobMii.models.dto.requests.PositionVacancyRequest;
import com.jobmii.JobMii.repositories.VacancyRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jobmii.JobMii.models.Position;
import com.jobmii.JobMii.models.PositionVacancy;
import com.jobmii.JobMii.models.Vacancy;
import com.jobmii.JobMii.models.key.PositionVacancyKey;
import com.jobmii.JobMii.repositories.PositionRepository;
import com.jobmii.JobMii.repositories.PositionVacancyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PositionVacancyService {

	private PositionRepository positionRepository;

	private VacancyRepository vacancyRepository;

	private PositionVacancyRepository positionVacancyRepository;

	public PositionVacancy createPositionVacancy(PositionVacancyRequest request) {
		Position position = positionRepository.findById(request.getPositionId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Position not found with id " + request.getPositionId()));

		Vacancy vacancy = vacancyRepository.findById(request.getVacancyId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Vacancy not found with id " + request.getVacancyId()));

		PositionVacancyKey key = new PositionVacancyKey(position.getId(), vacancy.getId());
		PositionVacancy positionVacancy = new PositionVacancy(key, vacancy, position, request.getQuota());

		return positionVacancyRepository.save(positionVacancy);
	}

	public List<PositionVacancy> getAll() {

		return positionVacancyRepository.findAll();
	}

	public List<PositionVacancy> getAllPositionData(Integer id) {

		return positionVacancyRepository.getAllPositionVacancy(id);
	}
}