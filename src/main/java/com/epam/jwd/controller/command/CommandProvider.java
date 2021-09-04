package com.epam.jwd.controller.command;

import com.epam.jwd.controller.impl.CountTotalCapacity;
import com.epam.jwd.controller.impl.CountTotalPayLoad;
import com.epam.jwd.controller.impl.FindAirplaneByFuelConsumption;
import com.epam.jwd.controller.impl.SortAirplaneByRange;
import com.epam.jwd.service.CompanyCreator;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("1", new CountTotalCapacity());
        commands.put("2", new CountTotalPayLoad());
        commands.put("3",new SortAirplaneByRange());
        commands.put("4", new FindAirplaneByFuelConsumption());
        /**
         * commands.put();
         * here goes methods for execution
         */

    }

    public Command getCommand(String operation) {
        return commands.get(operation);
    }
}
