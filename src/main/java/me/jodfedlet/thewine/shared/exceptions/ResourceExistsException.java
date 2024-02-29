package me.jodfedlet.thewine.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceExistsException extends RuntimeException{

    public ResourceExistsException() {
        super("Resource already exists.");
    }
    public ResourceExistsException(String message) {
        super(message);
    }
}
