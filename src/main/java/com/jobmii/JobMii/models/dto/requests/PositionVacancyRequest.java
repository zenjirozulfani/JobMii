package com.jobmii.JobMii.models.dto.requests;

import java.time.LocalDate;

import com.jobmii.JobMii.models.Position;
import com.jobmii.JobMii.models.key.PositionVacancyKey;

import lombok.Data;

@Data
public class PositionVacancyRequest {

	private Integer positionId;
	private Integer vacancyId;
	private int quota;
}
