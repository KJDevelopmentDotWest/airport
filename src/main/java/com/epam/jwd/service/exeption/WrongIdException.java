package com.epam.jwd.service.exeption;

public class WrongIdException extends Exception {
    public WrongIdException() {
    }

    public WrongIdException(String message) {
        super(message);

    }

    public WrongIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
