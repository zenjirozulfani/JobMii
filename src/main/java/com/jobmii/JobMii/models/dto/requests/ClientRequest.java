package com.jobmii.JobMii.models.dto.requests;

import lombok.Data;

@Data
public class ClientRequest {

	private String name;
	private String email;
	private String phone;
	private String description;
	private String username;
	private String password;
}
