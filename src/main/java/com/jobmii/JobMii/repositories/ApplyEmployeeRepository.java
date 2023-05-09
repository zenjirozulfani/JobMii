package com.jobmii.JobMii.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobmii.JobMii.models.Apply_Employee;
import com.jobmii.JobMii.models.Vacancy;

@Repository
public interface ApplyEmployeeRepository extends JpaRepository<Apply_Employee, Integer> {

}
