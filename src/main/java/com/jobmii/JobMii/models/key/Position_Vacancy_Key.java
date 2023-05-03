package com.jobmii.JobMii.models.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Position_Vacancy_Key implements Serializable {
	
	@Column(name = "position_id")
	int positionId;

	@Column(name = "vacancy_id")
	int vacancyId;
}
