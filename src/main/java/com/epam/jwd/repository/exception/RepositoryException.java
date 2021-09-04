package com.epam.jwd.repository.exception;

import com.epam.jwd.repository.storage.Repository;

public class RepositoryException extends RuntimeException{
    public RepositoryException(){

    }

    public RepositoryException(String message){
        super(message);
    }
}
