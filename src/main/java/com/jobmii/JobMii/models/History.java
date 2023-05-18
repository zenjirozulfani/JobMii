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
@Table(name = "tb_history")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private int id;

	private String update_date;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "apply_employee_id")
	private Apply_Employee apply_employee;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	// @JoinColumn(name = "history_id", nullable = true)
	// private Apply_Employee apply_employee;
}
