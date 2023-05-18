package com.jobmii.JobMii.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jobmii.JobMii.models.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {
	@Query(value = "SELECT COUNT(vacancy_id) AS total_users FROM tb_vacancy", nativeQuery = true)
	int countVacancy();

	@Query(value = "SELECT COUNT(vacancy_id) AS total_vacancy FROM tb_vacancy WHERE mitra_id=?1", nativeQuery = true)
	int countMyVacancy(Integer id);

	@Query(value = "SELECT * FROM tb_vacancy WHERE mitra_id=?1", nativeQuery = true)
	List<Vacancy> getMyVacancy(Integer id);

	
}
