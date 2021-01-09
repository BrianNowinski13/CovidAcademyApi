package pl.sdaacademy.covidacademyapi.states_stats.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sdaacademy.covidacademyapi.states_stats.service.NoStateFoundException;


@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = NoStateFoundException.class)
    public ResponseEntity<Object> handleNostateFound(NoStateFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
