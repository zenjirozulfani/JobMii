package com.jobmii.JobMii.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	private Set<PositionVacancy> positionVacancies;

	// @ManyToMany(mappedBy = "vacancies", fetch = FetchType.LAZY)
	// // @JsonIgnore
	// private List<Position> positions;

	@ManyToOne
	@JoinColumn(name = "mitra_id", nullable = false)
	private Employee mitra;

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	// @JoinTable(name = "tb_apply_employee", joinColumns = @JoinColumn(name =
	// "vacancy_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	// private List<Employee> employees;
}
