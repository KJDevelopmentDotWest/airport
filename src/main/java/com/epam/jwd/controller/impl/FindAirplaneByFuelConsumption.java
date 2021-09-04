package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.editor.CompanyEditor;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FindAirplaneByFuelConsumption implements Command {
    private static final Logger logger = LogManager.getLogger(FindAirplaneByFuelConsumption.class);

    @Override
    public String execute() throws MinMaxFuelConsumptionExeption {
        Company company = new Company();
        CompanyEditor companyEditor = new CompanyEditor(company);
        List<Airplane> findAirplaneByFuelConsumption = companyEditor.findAirplaneByFuelConsumption(50,680);
        return findAirplaneByFuelConsumption.toString();
    }
}
