package com.stussy.stussyclone20220929min.exception;


public class CustomInternalServerErrorException extends RuntimeException {

    public CustomInternalServerErrorException(String message) {
        super(message);
    }

}
