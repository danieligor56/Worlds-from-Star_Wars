package br.com.worldsFromStarWars.WordsFromStarWars.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Exceptions_NOTFOUND extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public Exceptions_NOTFOUND() {super();}

	public Exceptions_NOTFOUND(String message) {
		super(message);
	}

	public Exceptions_NOTFOUND(Throwable cause) {
		super(cause);
	}
	
	public Exceptions_NOTFOUND(String message, Throwable cause) {
		super(message,cause);
	}
}
