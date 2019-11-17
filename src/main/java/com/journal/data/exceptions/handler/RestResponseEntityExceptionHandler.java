package com.journal.data.exceptions.handler;

import com.journal.data.exceptions.UserNotFoundException;
import com.journal.data.exceptions.dto.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String ERROR_NOT_FOUND_BY_ID = "Resource with such id not found!";
    private static final String ERROR_VALIDATE_DATA = "Received incorrect data.";

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                     WebRequest request) {
        log.error(exception.getMessage());

        ResponseBody responseBody = ResponseBody.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ERROR_NOT_FOUND_BY_ID)
                .error(exception.getMessage())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .build();

        return handleExceptionInternal(exception, responseBody, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        log.error(ex.getMessage());

        ResponseBody responseBody = ResponseBody.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .message(ex.getMessage())
                .error(ex.getMethod())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .build();

        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED, request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        log.error(ex.getMessage());

        ResponseBody responseBody = ResponseBody.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(ERROR_VALIDATE_DATA)
                .error(ex.getBindingResult().getAllErrors().toString())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .build();

        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), status, request);
    }

}