package com.devsuperior.worshopcassandra.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
