package pro.sky.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.sky.exception.EmployeeAlreadyAddedException;

import pro.sky.exception.EmployeeNotFoundException;


@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<String> handleEmployeeAlreadyAddedException(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.TEXT_PLAIN)
                .body("Сотрудник уже добавлен");

    }
}
