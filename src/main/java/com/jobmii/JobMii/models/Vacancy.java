package com.jobmii.JobMii.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vacancy")
public class Vacancy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vacancy_id")
	private int id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String Address;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end_date;

	private boolean isActive;

	@OneToMany(mappedBy = "vacancy")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<PositionVacancy> positionVacancies;

	@ManyToOne
	@JoinColumn(name = "mitra_id", nullable = false)
	private Employee mitra;

}
