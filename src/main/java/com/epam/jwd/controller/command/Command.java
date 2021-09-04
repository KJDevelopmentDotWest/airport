package com.epam.jwd.controller.command;

import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;

public interface Command {
    String execute() throws MinMaxFuelConsumptionExeption, WrongIdException;
}
