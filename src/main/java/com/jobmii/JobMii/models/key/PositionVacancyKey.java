package com.jobmii.JobMii.models.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.jobmii.JobMii.models.Position;
import com.jobmii.JobMii.models.Vacancy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PositionVacancyKey implements Serializable {

	@Column(name = "position_id")
	Integer positionId;

	@Column(name = "vacancy_id")
	Integer vacancyId;
}
