package com.devsuperior.worshopcassandra.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.devsuperior.worshopcassandra.models.entities.Product;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

	@AllowFiltering
	List<Product> findByDepartment(String department);
}
