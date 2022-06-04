package com.example.api_springboot.exception;

public class DuplicateRecordException extends  RuntimeException{
    public DuplicateRecordException (String message) {
        super(message);
    }
}
