package com.jobmii.JobMii.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jobmii.JobMii.models.History;
import com.jobmii.JobMii.repositories.HistoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HistoryService {
	@Autowired
	private HistoryRepository historyRepository;

	public List<History> getAll() {
		return historyRepository.findAll();
	}

	public List<History> getAllByApplyEmployee(Integer id) {
		return historyRepository.findByIdApplyEmployee(id);
	}

	public History getByid(Integer id) {
		return historyRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "History not found!!"));
	}

	public History create(History history) {

		// List<Position> positions = new ArrayList<>();
		// positions.add(positionService.getById(vacancy.getPositions()));
		return historyRepository.save(history);
	}

	public History update(Integer id, History history) {
		getByid(id);
		history.setId(id);
		return historyRepository.save(history);
	}

	public History delete(Integer id) {
		History history = getByid(id);
		historyRepository.delete(history);
		return history;
	}
}
