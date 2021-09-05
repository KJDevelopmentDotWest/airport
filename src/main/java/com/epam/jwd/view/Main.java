package com.epam.jwd.view;

import com.epam.jwd.controller.Controller;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.editor.CompanyEditor;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;
import com.epam.jwd.service.reader.RepositoryReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String MAIN_METHOD_MESSAGE = "We're in main method";

    public static void main(String[] args) throws WrongIdException, MinMaxFuelConsumptionExeption {
        logger.debug(MAIN_METHOD_MESSAGE);
        CompanyEditor companyEditor = new CompanyEditor(Controller.createCompany("company3"));
        companyEditor.addAirplaneToCompany(RepositoryReader.getDefaultAirplanes().get(0).getId());
        System.out.println(Controller.getCompanies().get(2).getAirplanes());
        System.out.println(Controller.calculateTotalCapacity(RepositoryReader.getCompanies().get(1)));
        System.out.println(Controller.calculatePayload(RepositoryReader.getCompanies().get(0)));
        System.out.println(Controller.sortByRange(RepositoryReader.getCompanies().get(0)));
        System.out.println(Controller.sortByFuelConsumptionRange(RepositoryReader.getCompanies().get(0)));
        System.out.println(Controller.getCompany(RepositoryReader.getCompanies().get(2)));
        Controller.deleteAirplaneFromCompany(RepositoryReader.getCompanies().get(1),2);
        System.out.println(RepositoryReader.getCompanies().get(1).getAirplanes());

    }

}
