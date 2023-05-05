package com.jobmii.JobMii.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jobmii.JobMii.models.Vacancy;
import com.jobmii.JobMii.models.key.Position_Vacancy_Key;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Position_Vacancy_Key> {

}
