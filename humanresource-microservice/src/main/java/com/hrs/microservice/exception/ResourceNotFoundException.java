package com.hrs.microservice.exception;

import br.com.hrs.core.exception.HrsRuntimeException;

public class ResourceNotFoundException extends HrsRuntimeException {

	private static final long serialVersionUID = 501393729698010643L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
