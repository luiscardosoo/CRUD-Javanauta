package com.LHC.aprendendo_spring.infrastructure.exceptions;

public class ConflictException extends RuntimeException{

    public ConflictException(String message){
        super(message);
    }

    public ConflictException(String message,Throwable trowable){
        super(message);
    }
}
