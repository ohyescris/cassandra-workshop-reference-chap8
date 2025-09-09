package com.devsuperior.worshopcassandra.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.worshopcassandra.models.dto.DepartmentDTO;
import com.devsuperior.worshopcassandra.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> findAll() {
		List<DepartmentDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartmentDTO> findById(@PathVariable UUID id) {
		DepartmentDTO object = service.findById(id);
		return ResponseEntity.ok().body(object);
	}
}
