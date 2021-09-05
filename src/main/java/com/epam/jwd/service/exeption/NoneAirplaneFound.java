package com.epam.jwd.service.exeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class NoneAirplaneFound extends Exception{
    private static final Logger logger = LogManager.getLogger(MinMaxFuelConsumptionExeption.class);

    public NoneAirplaneFound() {
    }

    public NoneAirplaneFound(String message) {
        super(message);
    }

}