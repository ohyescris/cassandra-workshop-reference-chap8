package com.devsuperior.worshopcassandra.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.worshopcassandra.models.dto.ProductDTO;
import com.devsuperior.worshopcassandra.models.entities.Product;
import com.devsuperior.worshopcassandra.repositories.ProductRepository;
import com.devsuperior.worshopcassandra.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public ProductDTO findById(UUID id) {
		Product entity = getById(id);
		return new ProductDTO(entity);
	}

	private Product getById(UUID id) {
		Optional<Product> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
	}

}
