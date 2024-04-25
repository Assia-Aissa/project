package com.pfe.project.Exception.handler;


import com.pfe.project.Exception.EntityAlreadyExistsException;
import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.shared.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class AppException {
     @ExceptionHandler(value = {EntityNotFoundException.class})
     public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex){
       ErrorMessage  errorMessage = ErrorMessage.builder()
                 .message(ex.getMessage())
                 .timestamp(new Date())
                 .code(404)
                 .build();
         return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
     }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentValid(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

          @ExceptionHandler(value = {EntityAlreadyExistsException.class})
          public ResponseEntity<Object> entityNotFoundException(EntityAlreadyExistsException ex){
               ErrorMessage errorMessage = ErrorMessage.builder()
                      .message(ex.getMessage())
                      .timestamp(new Date())
                      .code(409)
                      .build();
              return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
          }

}
