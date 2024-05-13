package br.com.fiap.contact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserCannotFindException extends RuntimeException{
    public UserCannotFindException(String message) {
        super(message);
    }
}
