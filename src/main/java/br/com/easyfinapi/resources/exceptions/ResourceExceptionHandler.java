package br.com.easyfinapi.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.easyfinapi.services.exceptions.ObjectNotFoundException;
import br.com.easyfinapi.services.exceptions.UserNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler({ObjectNotFoundException.class})
	public ResponseEntity<StandartError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest req){
		
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler( {UserNotFoundException.class})
	public ResponseEntity<StandartError> UserNotFound(UserNotFoundException e, HttpServletRequest req){
		
		StandartError err = new StandartError(HttpStatus.NO_CONTENT.value(), e.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<StandartError>(err, HttpStatus.NO_CONTENT);
	}
}
