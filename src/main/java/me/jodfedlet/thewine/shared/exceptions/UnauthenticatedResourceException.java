package me.jodfedlet.thewine.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthenticatedResourceException extends RuntimeException {

    public UnauthenticatedResourceException() {
        super("Unauthorized.");
    }

    public UnauthenticatedResourceException(String message) {
        super(message);
    }
}
