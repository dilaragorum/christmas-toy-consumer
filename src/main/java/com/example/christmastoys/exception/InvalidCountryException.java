package com.example.christmastoys.exception;

public class InvalidCountryException extends RuntimeException{
    public InvalidCountryException(String s) {
        super(s);
    }
}
