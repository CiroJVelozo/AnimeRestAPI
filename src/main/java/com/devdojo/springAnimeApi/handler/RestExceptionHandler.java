package com.devdojo.springAnimeApi.handler;

import com.devdojo.springAnimeApi.exception.BadRequestExceptionDetails;
import com.devdojo.springAnimeApi.exception.BadrequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadrequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadrequestException(BadrequestException badrequestException){
        return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                .title("Bad request exception")
                .status(HttpStatus.BAD_REQUEST.value())
                .details(badrequestException.getMessage())
                .developerMessage(badrequestException.getClass().getName())
                .timeStamp(LocalDateTime.now()).build(),
                HttpStatus.BAD_REQUEST);
    }
}
