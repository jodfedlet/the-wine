package me.jodfedlet.thewine.shared.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(NotFoundException.class)
     public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
         System.out.println("/".repeat(100));
         return ResponseEntity
                 .status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body(e.getMessage());
     }
}
