package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.controller.command.CommandProvider;
import com.epam.jwd.controller.command.Controller;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;

public class ControllerImpl implements Controller {

    private CommandProvider provider = new CommandProvider();

    @Override
    public String doAction(String operation) throws MinMaxFuelConsumptionExeption, WrongIdException {
        /** Request form  = "number of operation" */

        Command current = provider.getCommand(operation);

        return current.execute();
    }
}
