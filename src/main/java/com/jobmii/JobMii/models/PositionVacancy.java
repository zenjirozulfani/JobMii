package com.jobmii.JobMii.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobmii.JobMii.models.key.PositionVacancyKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_position_vacancy")
public class PositionVacancy {

	@EmbeddedId
	PositionVacancyKey positionVacancyKey;

	@ManyToOne
	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@MapsId("vacancyId")
	@JoinColumn(name = "vacancy_id", insertable = false, updatable = false)
	private Vacancy vacancy;

	@ManyToOne
	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@MapsId("positionId")
	@JoinColumn(name = "position_id", insertable = false, updatable = false)
	private Position position;

	int quota;
}
