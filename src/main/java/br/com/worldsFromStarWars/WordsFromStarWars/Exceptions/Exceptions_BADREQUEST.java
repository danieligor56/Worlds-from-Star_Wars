package br.com.worldsFromStarWars.WordsFromStarWars.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class Exceptions_BADREQUEST extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public Exceptions_BADREQUEST() {super();}

	public Exceptions_BADREQUEST(String message) {
		super(message);
	}

	public Exceptions_BADREQUEST(Throwable cause) {
		super(cause);
	}
	
	public Exceptions_BADREQUEST(String message, Throwable cause) {
		super(message,cause);
	}
}
