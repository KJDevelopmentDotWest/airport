package com.epam.jwd.controller;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.creator.CompanyCreator;
import com.epam.jwd.service.editor.CompanyEditor;
import com.epam.jwd.service.editor.RepositoryEditor;
import com.epam.jwd.service.exception.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exception.WrongIdException;
import com.epam.jwd.service.reader.RepositoryReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Controller {
    private static final String CREATE_COMPANY_DEBUG_MESSAGE = "Create company";
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private static final String ADD_AIRPLANE_TO_COMPANY = "Add airplane to company";
    private static final String GET_DEFAULT_AIRPLANES_DEBUG_MESSAGE = "Get RO default airplanes list";
    private static final String GET_COMPANIES_DEBUG_MESSAGE = "Get RO companies from repository";
    private static final String GET_COMPANY_BY_DEBUG_MESSAGE = "Get company by id";
    private static final String CALCULATE_TOTAL_CAPACITY_DEBUG_MESSAGE = "Calculate total capacity of Passenger airplanes";
    private static final String CALCULATE_PAYLOAD_DEBUG_MESSAGE = "Calculate payload of Cargo airplanes";
    private static final String GET_COMPANY_AIRPLANES_LIST_DEBUG_MESSAGE = "Get company`s airplanes";
    private static final String FIND_AIRPLANE_BY_FUELCONSUMPTION_DEBUG_MESSAGE = "Find airplane by Fuel Consumption range";
    private static final String SORT_AIRPLANES_BY_RANGE_DEBUG_MESSAGE = "Sort airplane by range";

    public static Company createCompany(String companyName) {
        logger.debug(CREATE_COMPANY_DEBUG_MESSAGE);
        CompanyCreator companyCreator = new CompanyCreator(companyName);
        return companyCreator.getCompany();
    }

    public static void addAirplanesToCompany(Company company, int id) throws WrongIdException {
        logger.debug(ADD_AIRPLANE_TO_COMPANY);
        CompanyEditor companyEditor = new CompanyEditor(company);
        companyEditor.addAirplaneToCompany(id);
    }

    public static List<Airplane> getDefaultAirplanes() {
        logger.debug(GET_DEFAULT_AIRPLANES_DEBUG_MESSAGE);
        return RepositoryReader.getDefaultAirplanes();
    }

    public static List<Company> getCompanies() {
        logger.debug(GET_COMPANIES_DEBUG_MESSAGE);
        return RepositoryReader.getCompanies();
    }

    public static Company getCompany(int id) throws WrongIdException {
        logger.debug(GET_COMPANY_BY_DEBUG_MESSAGE);
        return RepositoryReader.getCompany(id);
    }

    public static int calculateTotalCapacity(Company company) {
        logger.debug(CALCULATE_TOTAL_CAPACITY_DEBUG_MESSAGE);
        return new CompanyEditor(company).countTotalCapacity();
    }

    public static void saveToMemory() {
        RepositoryEditor.saveRepositoryToFile();
    }

    public static int calculatePayload(Company company) {
        logger.debug(CALCULATE_PAYLOAD_DEBUG_MESSAGE);
        return new CompanyEditor(company).countTotalPayload();
    }

    public static List<Airplane> getCompanyAirplanes(Company company) {
        logger.debug(GET_COMPANY_AIRPLANES_LIST_DEBUG_MESSAGE);
        return new CompanyEditor(company).getCompanyAirplanes();
    }

    public static void deleteAirplaneFromCompany(Company company, int id) {
        logger.debug(GET_COMPANY_AIRPLANES_LIST_DEBUG_MESSAGE);
        new CompanyEditor(company).deleteAirplaneFromCompany(id);
    }

    public static List<Airplane> findAirplaneByFuelConsumption(Company company, int minFuelConsumption, int maxFuelConsumption) throws MinMaxFuelConsumptionExeption {
        logger.debug(FIND_AIRPLANE_BY_FUELCONSUMPTION_DEBUG_MESSAGE);
        return new CompanyEditor(company).findAirplaneByFuelConsumption(minFuelConsumption, maxFuelConsumption);
    }

    public static List<Airplane> sortAirplaneByRange(Company company) {
        logger.debug(SORT_AIRPLANES_BY_RANGE_DEBUG_MESSAGE);
        return new CompanyEditor(company).sortAirplaneByRange();
    }

    public static void deleteCompany(Company company){
        RepositoryEditor.deleteCompanyFromRepository(company);
    }
}
