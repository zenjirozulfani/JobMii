package com.jobmii.JobMii.repositories;

import com.jobmii.JobMii.models.Role;
import com.jobmii.JobMii.models.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
