package com.jobmii.JobMii.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jobmii.JobMii.models.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
