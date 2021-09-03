package com.epam.jwd.service.exeption;

public class MinMaxFuelConsumptionExeption extends Exception{
    public MinMaxFuelConsumptionExeption() {
    }

    public MinMaxFuelConsumptionExeption(String message) {
        super(message);
    }

    public MinMaxFuelConsumptionExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
