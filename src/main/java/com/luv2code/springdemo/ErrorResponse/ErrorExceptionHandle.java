package com.luv2code.springdemo.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorExceptionHandle {
    @ExceptionHandler
public ResponseEntity<ErrorResponseCustomer> handleException(Exception exc){
        ErrorResponseCustomer errorResponseCustomer=new ErrorResponseCustomer();
        errorResponseCustomer.setStatus(HttpStatus.BAD_GATEWAY.value());
        errorResponseCustomer.setMessage(exc.getMessage());
        errorResponseCustomer.setTimeStamp(System.currentTimeMillis());
return new ResponseEntity<>(errorResponseCustomer,HttpStatus.BAD_GATEWAY);

    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponseCustomer> handleException(ErrorExceptionCustomer exc){
        ErrorResponseCustomer error=new ErrorResponseCustomer();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
