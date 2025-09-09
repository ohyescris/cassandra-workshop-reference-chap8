package com.devsuperior.worshopcassandra.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.worshopcassandra.models.dto.DepartmentDTO;
import com.devsuperior.worshopcassandra.models.entities.Department;
import com.devsuperior.worshopcassandra.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	public List<DepartmentDTO> findAll() {
		List<Department> list = repository.findAll();
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}

	public DepartmentDTO findById() {
		// TODO Auto-generated method stub
		return null;
	}
}
