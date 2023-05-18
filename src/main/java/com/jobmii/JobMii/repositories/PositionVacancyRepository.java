package com.jobmii.JobMii.repositories;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobmii.JobMii.models.PositionVacancy;
import com.jobmii.JobMii.models.key.PositionVacancyKey;

@Repository
public interface PositionVacancyRepository extends JpaRepository<PositionVacancy, PositionVacancyKey> {
	// @Query(value = "SELECT * FROM tb_position_vacancy", nativeQuery = true)
	

	@Query(value = "SELECT * FROM tb_position_vacancy WHERE vacancy_id = ?1", nativeQuery = true)
	List<PositionVacancy> getAllPositionVacancy(Integer id);
}
