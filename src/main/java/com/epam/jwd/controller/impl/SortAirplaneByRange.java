package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.service.CompanyCreator;

import java.util.List;

public class SortAirplaneByRange implements Command {
    @Override
    public String execute() {
        CompanyCreator companyCreator = new CompanyCreator("MyCompany");
        List<Airplane> airplane = companyCreator.sortAirplaneByRange();
        return airplane.toString();
    }
}
