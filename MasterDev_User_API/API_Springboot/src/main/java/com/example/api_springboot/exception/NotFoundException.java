package com.example.api_springboot.exception;

public class NotFoundException  extends  RuntimeException{

    public NotFoundException (String message){
        super(message);

    }
}
