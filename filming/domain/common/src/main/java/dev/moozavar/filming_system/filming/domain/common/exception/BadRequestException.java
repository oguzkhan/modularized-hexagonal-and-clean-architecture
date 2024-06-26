package dev.moozavar.filming_system.filming.domain.common.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
