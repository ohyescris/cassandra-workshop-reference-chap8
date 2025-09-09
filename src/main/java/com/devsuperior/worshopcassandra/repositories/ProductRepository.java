package com.devsuperior.worshopcassandra.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.devsuperior.worshopcassandra.models.entities.Product;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

}
