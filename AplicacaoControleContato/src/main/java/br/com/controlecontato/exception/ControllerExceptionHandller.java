package br.com.controlecontato.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.controlecontato.dto.ErrorDTO;

@RestControllerAdvice
public class ControllerExceptionHandller {

	@ExceptionHandler(Exception.class)
	public ResponseEntity handllerException(Exception exception) {
		ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), 400);

		return ResponseEntity.badRequest().body(errorDTO);
	}

}
