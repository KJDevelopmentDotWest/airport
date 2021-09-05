package com.epam.jwd.repository.exception;

import com.epam.jwd.repository.storage.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepositoryException extends RuntimeException{
    private static final Logger logger = LogManager.getLogger(RepositoryException.class);
    public RepositoryException(){

    }

    public RepositoryException(String message){
        super(message);
    }
}
