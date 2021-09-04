package com.epam.jwd.controller.command;

import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;

public interface Controller {
    String doAction(String request) throws MinMaxFuelConsumptionExeption, WrongIdException;
}
