package br.com.easyfinapi.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import br.com.easyfinapi.services.exceptions.DataIntegretyException;
import br.com.easyfinapi.services.exceptions.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.easyfinapi.services.exceptions.ObjectNotFoundException;
import br.com.easyfinapi.services.exceptions.UserNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler  {

	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<StandartError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", e.getMessage(), request.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}


	@ExceptionHandler({ObjectNotFoundException.class})
	public ResponseEntity<StandartError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest req){
		
		StandartError err = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "nao encontrado", e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler( {UserNotFoundException.class})
	public ResponseEntity<StandartError> UserNotFound(UserNotFoundException e, HttpServletRequest req){
		
		StandartError err = new StandartError(
				System.currentTimeMillis() ,
				HttpStatus.NO_CONTENT.value(),
				"usuario nao encontrado",
				e.getMessage(),
				req.getRequestURI());

		return new ResponseEntity<StandartError>(err, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler( { DataIntegretyException.class})
	public ResponseEntity<StandartError> DataIntegretyError(DataIntegretyException e, HttpServletRequest req){

		StandartError err = new StandartError(
				System.currentTimeMillis(),
				HttpStatus.NOT_ACCEPTABLE.value(),
				"erro integridade do obj",
				e.getMessage(),
				req.getRequestURI());

		return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);

	}

	@ExceptionHandler( { ForbiddenException.class})
	public ResponseEntity<StandartError> ForbiddenError(ForbiddenException e, HttpServletRequest req){

		StandartError err = new StandartError(
				System.currentTimeMillis(),
				HttpStatus.NOT_ACCEPTABLE.value(),
				"sem autorizacao",
				e.getMessage(),
				req.getRequestURI());

		return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);

	}
}
