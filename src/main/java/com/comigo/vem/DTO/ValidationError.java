package com.comigo.vem.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError(Instant timesTamp, Integer status, String error, String path) {
		super(timesTamp, status, error, path);
	}

	public List<FieldMessage> getErros() {
		return erros;
	}
	
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}
}
