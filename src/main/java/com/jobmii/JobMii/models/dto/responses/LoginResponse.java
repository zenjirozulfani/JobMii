package com.jobmii.JobMii.models.dto.responses;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
	private String username;
	private String email;
	private List<String> authorities;
}
