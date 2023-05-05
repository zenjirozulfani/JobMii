package com.jobmii.JobMii.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobmii.JobMii.models.Vacancy;
import com.jobmii.JobMii.repositories.VacancyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacancyService {
	private VacancyRepository vacancyRepository;

	public List<Vacancy> getAll() {
		return vacancyRepository.findAll();
	}
}
