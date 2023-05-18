package com.jobmii.JobMii.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobmii.JobMii.models.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
	@Query(value = "SELECT * FROM tb_history WHERE apply_employee_id = ?1", nativeQuery = true)
	List<History> findByIdApplyEmployee(Integer id);
}
