package com.jobmii.JobMii.repositories;

import com.jobmii.JobMii.models.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// query
	@Query(value = "SELECT e.employee_id as employee_id, e.description as description, e.cv as cv, e.email as email, e.name as name, e.phone as phone, e.status as status, e.position_id as position_id "
			+
			"FROM tb_employee e " +
			"JOIN tb_user u ON e.employee_id  = u.user_id " +
			"JOIN tb_user_role ur ON u.user_id = ur.user_id " +
			"WHERE ur.role_id = 1", nativeQuery = true)
	public List<Employee> getAllEmployee();

	@Query(value = "SELECT e.employee_id as employee_id, e.description as description, e.cv as cv, e.email as email, e.name as name, e.phone as phone, e.status as status, e.position_id as position_id "
			+
			"FROM tb_employee e " +
			"JOIN tb_user u ON e.employee_id  = u.user_id " +
			"JOIN tb_user_role ur ON u.user_id = ur.user_id " +
			"WHERE ur.role_id = 3", nativeQuery = true)
	public List<Employee> getAllClient();
}
