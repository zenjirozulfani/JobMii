package com.jobmii.JobMii.repositories;

import com.jobmii.JobMii.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);

	Optional<User> findByUsernameOrEmployee_Email(String username, String email);

	@Query(value = "SELECT COUNT(user_id) AS total_users FROM tb_user_role WHERE role_id = 1", nativeQuery = true)
	int countUsersByRoleId();

	@Query(value = "SELECT COUNT(employee_id) AS total_users FROM tb_employee WHERE role_id = 1 AND status = 1", nativeQuery = true)
	int countEmployeeJob();

	@Query(value = "SELECT COUNT(user_id) AS total_users FROM tb_user_role WHERE role_id = 3", nativeQuery = true)
	int countClientByRoleId();
}
