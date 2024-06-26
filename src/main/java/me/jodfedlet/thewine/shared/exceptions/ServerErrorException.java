package me.jodfedlet.thewine.shared.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException{

    public ServerErrorException() {
        super("Server error.");
    }

    public ServerErrorException(String message) {
        super(message);
    }
}
