package com.jobmii.JobMii.models.dto.requests;

import lombok.Data;

@Data
public class EmployeeRequest {

	private String name;
	private String email;
	private String phone;
	private String username;
	private String password;
	private String cv;
	private String description;

}
