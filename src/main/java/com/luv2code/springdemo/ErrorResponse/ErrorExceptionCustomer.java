package com.luv2code.springdemo.ErrorResponse;

public class ErrorExceptionCustomer extends RuntimeException {
    public ErrorExceptionCustomer(String message) {
        super(message);
    }
}
