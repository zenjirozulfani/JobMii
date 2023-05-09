package com.jobmii.JobMii.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
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
	PositionVacancyKey id;

	@ManyToOne
	@MapsId("vacancyId")
	@JoinColumn(name = "vacancy_id")
	private Vacancy vacancy;

	@ManyToOne
	@MapsId("positionId")
	@JoinColumn(name = "position_id")
	private Position position;

	int quota;
}
