package com.wavemaker.runtime.data.exception;


//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String string) {
		super(string);
	}

}
