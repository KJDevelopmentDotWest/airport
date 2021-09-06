package com.epam.jwd.service.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongIdException extends Exception {
    private static final Logger logger = LogManager.getLogger(WrongIdException.class);

    public WrongIdException() {
    }

    public WrongIdException(String message) {
        super(message);
    }

    public WrongIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
