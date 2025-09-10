package com.devsuperior.worshopcassandra.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.worshopcassandra.models.dto.ProductDTO;
import com.devsuperior.worshopcassandra.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
		ProductDTO object = service.findById(id);
		return ResponseEntity.ok().body(object);
	}

}
