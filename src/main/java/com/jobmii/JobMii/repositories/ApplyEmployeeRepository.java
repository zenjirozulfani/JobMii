package com.jobmii.JobMii.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobmii.JobMii.models.Apply_Employee;
import com.jobmii.JobMii.models.Vacancy;

@Repository
public interface ApplyEmployeeRepository extends JpaRepository<Apply_Employee, Integer> {
	@Query(value = "SELECT * FROM tb_apply_employee WHERE employee_id = ?1", nativeQuery = true)
	List<Apply_Employee> findByIdEmployee(Integer id);

	@Query(value = "SELECT * FROM tb_apply_employee WHERE vacancy_id = ?1 AND status_id != 3", nativeQuery = true)
	List<Apply_Employee> findJobApplicant(Integer id);

	@Query(value = "SELECT * FROM tb_apply_employee WHERE vacancy_id = ?1 AND status_id = 1", nativeQuery = true)
	List<Apply_Employee> findJobApply(Integer id);

	@Query(value = "SELECT * FROM tb_apply_employee WHERE vacancy_id = ?1 AND status_id = 3", nativeQuery = true)
	List<Apply_Employee> getAccept(Integer id);

	@Query(value = "SELECT ae.*, e.name, e.email, e.phone, p.name_position AS position " +
			"FROM tb_apply_employee ae " +
			"JOIN tb_employee e ON ae.employee_id = e.employee_id " +
			"JOIN tb_position p ON e.position_id = p.position_id " +
			"WHERE ae.vacancy_id = ?1 AND ae.status_id = 3", nativeQuery = true)
	List<Object[]> findEmployeeAccepted(Integer vacancyId);
}
