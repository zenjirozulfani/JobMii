package com.jobmii.JobMii.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
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

	private PositionVacancyRepository positionVacancyRepository;

	private PositionRepository positionRepository;

	// public PositionVacancy create(PositionVacancyKey key, int quota) {
	// PositionVacancy positionVacancy = new PositionVacancy();
	// positionVacancy.setId(key);
	// positionVacancy.setQuota(quota);
	// // set other properties of positionVacancy
	// return positionVacancyRepository.save(positionVacancy);
	// }

	// public PositionVacancy create(PositionVacancyKey key, int quota, Position
	// position, Vacancy vacancy) {
	// PositionVacancy positionVacancy = new PositionVacancy();
	// positionVacancy.setId(key);
	// positionVacancy.setPosition(position);
	// positionVacancy.setVacancy(vacancy);
	// positionVacancy.setQuota(quota);
	// return positionVacancyRepository.save(positionVacancy);
	// }

	public PositionVacancy create(PositionVacancy vacancy) {
		return positionVacancyRepository.save(vacancy);
	}
}
