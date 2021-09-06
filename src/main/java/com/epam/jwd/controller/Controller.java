package com.epam.jwd.controller;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;

import com.epam.jwd.service.creator.CompanyCreator;
import com.epam.jwd.service.editor.CompanyEditor;
import com.epam.jwd.service.editor.RepositoryEditor;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.NoneAirplaneFound;
import com.epam.jwd.service.exeption.WrongIdException;
import com.epam.jwd.service.reader.RepositoryReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);

    private static final String NONE_AIRPLANE_WITH_SUCH_MANUFACTURE = "There is no any airplane with such manufacture";

    private static final String NONE_AIRPLANE_WITH_SUCH_CONSUMPTION ="There is no any airplane with such consumption";

    private static final String FIND_BY_MANUFACTURE_MESSAGE = "We're in findByManufacture method";

    private static final String FIND_BY_CONSUMPTION_MESSAGE = "We're in findByConsumption method";

    private static final String CREATE_COMPANY_METHOD_MESSAGE = "We're in createCompany message";

    private static final String ADD_AIRPLANES_TO_COMPANY_METHOD_MESSAGE = "We're at addAirplaneToCompany method";

    private static final String CALCULATE_TOTAL_CAPACITY_METHOD_MESSAGE = "We're at calculateTotalCapacity method";

    private static final String SAVE_TO_MEMORY_METHOD_MESSAGE = "We're at saveToMemory method";

    private static final String CALCULATE_PAYLOAD_METHOD_MESSAGE = "We're at calculatePayload method";

    private static final String SORT_BY_RANGE_METHOD_MESSAGE = "We're at sortByRange method";

    private static final String DELETE_AIRPLANE_FROM_COMPANY_METHOD_MESSAGE ="We're at deleteAirplaneFromCompany method";

    private static final String SORT_AIRPLANE_BY_RANGE_METHOD_MESSAGE = "We're at sortAirplaneByRange method";


    public static List<Airplane> getDefaultAirplanes(){
        return RepositoryReader.getDefaultAirplanes();
    }

    public static List<Company> getCompanies(){
        return RepositoryReader.getCompanies();
    }

    public static List<Airplane> getCompanyAirplanes (Company company){
        return new CompanyEditor(company).getCompanyAirplanes();
    }

    public static Company createCompany(String companyName){
        logger.debug(CREATE_COMPANY_METHOD_MESSAGE);
        CompanyCreator companyCreator = new CompanyCreator(companyName);
        return companyCreator.getCompany();
    }

    public static void addAirplanesToCompany(Company company, int id) throws WrongIdException{
        logger.debug(ADD_AIRPLANES_TO_COMPANY_METHOD_MESSAGE);
        CompanyEditor companyEditor = new CompanyEditor(company);
        companyEditor.addAirplaneToCompany(id);
    }

    public static int calculateTotalCapacity(Company company){
        logger.debug(CALCULATE_TOTAL_CAPACITY_METHOD_MESSAGE);
        return new CompanyEditor(company).countTotalCapacity();
    }

    public static void saveToMemory(){
        logger.debug(SAVE_TO_MEMORY_METHOD_MESSAGE);
        RepositoryEditor.saveRepositoryToFile();
    }

    public static int calculatePayload (Company company){
        logger.debug(CALCULATE_PAYLOAD_METHOD_MESSAGE);
        return new CompanyEditor(company).countTotalPayload();
    }

    public static List<Airplane> sortByRange(Company company){
        logger.debug(SORT_BY_RANGE_METHOD_MESSAGE);
        return new CompanyEditor(company).sortAirplaneByRange();
    }

    public static List<Airplane> findByFuelConsumptionRange(Company company) throws MinMaxFuelConsumptionExeption {
        logger.debug(FIND_BY_CONSUMPTION_MESSAGE);
        return new CompanyEditor(company).findAirplaneByFuelConsumption(10,20);
    }


    public static void deleteAirplaneFromCompany (Company company, int id){
        logger.debug(DELETE_AIRPLANE_FROM_COMPANY_METHOD_MESSAGE);
        new CompanyEditor(company).deleteAirplaneFromCompany(id);

    }

    public static List<Airplane> findAirplaneByFuelConsumption(Company company, int minFuelConsumption, int maxFuelConsumption) throws MinMaxFuelConsumptionExeption {
        logger.debug(FIND_BY_CONSUMPTION_MESSAGE);
        return new CompanyEditor(company).findAirplaneByFuelConsumption(minFuelConsumption, maxFuelConsumption);
    }

    public static List<Airplane> sortAirplaneByRange(Company company){
        logger.debug(SORT_AIRPLANE_BY_RANGE_METHOD_MESSAGE);
        return new CompanyEditor(company).sortAirplaneByRange();
    }
}
