package com.jobmii.JobMii.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jobmii.JobMii.models.Position;
import com.jobmii.JobMii.repositories.PositionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PositionService {
	@Autowired
	private PositionRepository positionRepository;

	public List<Position> getAll() {
		return positionRepository.findAll();
	}

	public Position getById(Integer id) {
		return positionRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Position not found!!"));
	}

	public Position create(Position position) {
		return positionRepository.save(position);
	}

	public Position update(Integer id, Position position) {
		getById(id); // method getById
		position.setId(id);
		return positionRepository.save(position);
	}

	public Position delete(Integer id) {
		Position position = getById(id);
		positionRepository.delete(position);
		return position;
	}
}
