package com.jobmii.JobMii.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobmii.JobMii.models.PositionVacancy;
import com.jobmii.JobMii.models.key.PositionVacancyKey;

@Repository
public interface PositionVacancyRepository extends JpaRepository<PositionVacancy, PositionVacancyKey> {
}
