package com.epam.jwd.service.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinMaxFuelConsumptionExeption extends Exception{
    private static final Logger logger = LogManager.getLogger(MinMaxFuelConsumptionExeption.class);

    public MinMaxFuelConsumptionExeption() {
    }

    public MinMaxFuelConsumptionExeption(String message) {
        super(message);
    }

    public MinMaxFuelConsumptionExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
