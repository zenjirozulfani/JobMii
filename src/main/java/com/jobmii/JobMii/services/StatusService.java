package com.jobmii.JobMii.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jobmii.JobMii.models.Status;
import com.jobmii.JobMii.repositories.StatusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusService {
	private StatusRepository statusRepository;

	public Status getById(Integer id) {
		return statusRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status not found!!"));
	}

}
