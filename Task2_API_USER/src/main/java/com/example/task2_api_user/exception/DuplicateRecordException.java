package com.example.task2_api_user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DuplicateRecordException extends  RuntimeException{
    public DuplicateRecordException (String message) {
        super(message);
    }
}
