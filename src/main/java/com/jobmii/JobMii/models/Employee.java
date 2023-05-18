package com.jobmii.JobMii.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int id;

	private String name;

	private String email;

	private String phone;

	private String cv;

	private Boolean status;

	private String Description;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@PrimaryKeyJoinColumn
	private User user;

	@ManyToOne
	@JoinColumn(name = "position_id", nullable = true)
	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Position position;

	// @ManyToMany(mappedBy = "employees")
	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	// List<Vacancy> vacancies;

	// @ManyToMany(mappedBy = "employee")
	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	// List<Apply_Employee> apply_employee;
}
