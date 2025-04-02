package dev.redshadow.stickynotes.exceptionhandlerers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalexceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidExceptions(MethodArgumentNotValidException exception){
        Map<String,Object> errors=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()
        ));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
