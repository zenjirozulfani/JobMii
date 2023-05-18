package com.jobmii.JobMii.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_apply_employee")
public class Apply_Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apply_employee_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User hr;

	@ManyToOne
	@JoinColumn(name = "vacancy_id")
	private Vacancy vacancy;

	@Column(nullable = false)
	private String apply_date;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	private String date_test;

	private String location_test;

}
