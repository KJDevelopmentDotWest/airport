package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.service.CompanyCreator;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;

import java.util.List;

public class FindAirplaneByFuelConsumption implements Command {
    @Override
    public String execute() throws MinMaxFuelConsumptionExeption {
        CompanyCreator companyCreator = new CompanyCreator("MyCompany");
        List<Airplane> airplane = companyCreator.findAirplaneByFuelConsumption(50,680);
        return airplane.toString();
    }
}
