package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.service.CompanyCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SortAirplaneByRange implements Command {
    private static final Logger logger = LogManager.getLogger(SortAirplaneByRange.class);

    @Override
    public String execute() {
        CompanyCreator companyCreator = new CompanyCreator("MyCompany");
        List<Airplane> airplane = companyCreator.sortAirplaneByRange();
        return airplane.toString();
    }
}
