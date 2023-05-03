package com.jobmii.JobMii.repositories;

import com.jobmii.JobMii.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsernameOrEmployee_Email(String username, String email);
}
