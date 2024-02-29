package me.jodfedlet.thewine.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Resource not found.");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
