package com.example.christmastoys.toy.exception;

public class InvalidCountryException extends RuntimeException{
    public InvalidCountryException(String s) {
        super(s);
    }
}
