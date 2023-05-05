package com.jobmii.JobMii.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobmii.JobMii.models.Position;
import com.jobmii.JobMii.services.PositionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/position")
public class PositionController {
	@Autowired
	private PositionService positionService;

	@GetMapping
	public List<Position> getAll() {
		return positionService.getAll();
	}

	@PostMapping("/create")
	public Position create(@RequestBody Position position) {
		return positionService.create(position);
	}

	@GetMapping("/{id}")
	public Position getById(@PathVariable int id) {
		return positionService.getById(id);
	}

	@PutMapping("/update/{id}")
	public Position update(@PathVariable Integer id, @RequestBody Position position) {
		return positionService.update(id, position);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		positionService.delete(id);
	}
}
