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

    public static Company createCompany(String companyName){
        CompanyCreator companyCreator = new CompanyCreator(companyName);
        return companyCreator.getCompany();
    }

    public static void addAirplanesToCompany(Company company, int id) throws WrongIdException{
        CompanyEditor companyEditor = new CompanyEditor(company);
        companyEditor.addAirplaneToCompany(id);
    }

    public static List<Airplane> getDefaultAirplanes(){
        return RepositoryReader.getDefaultAirplanes();
    }

    public static List<Company> getCompanies(){
        return RepositoryReader.getCompanies();
    }

    public static int calculateTotalCapacity(Company company){
        return new CompanyEditor(company).countTotalCapacity();
    }

    public static void saveToMemory(){

        RepositoryEditor.saveRepositoryToFile();
    }

    public static int calculatePayload (Company company){

        return new CompanyEditor(company).countTotalPayload();
    }

    public static List<Airplane> sortByRange(Company company){
        return new CompanyEditor(company).sortAirplaneByRange();
    }

    public static List<Airplane> findByFuelConsumptionRange(Company company) throws MinMaxFuelConsumptionExeption {
        return new CompanyEditor(company).findAirplaneByFuelConsumption(10,20);
    }

    public static List<Airplane> getCompanyAirplanes (Company company){
        return new CompanyEditor(company).getCompanyAirplanes();

    }
    public static void deleteAirplaneFromCompany (Company company, int id){
         new CompanyEditor(company).deleteAirplaneFromCompany(id);

    }

    public static List<Airplane> findAirplaneByFuelConsumption(Company company, int minFuelConsumption, int maxFuelConsumption) throws MinMaxFuelConsumptionExeption {
        return new CompanyEditor(company).findAirplaneByFuelConsumption(minFuelConsumption, maxFuelConsumption);
    }

    public static List<Airplane> sortAirplaneByRange(Company company){
        return new CompanyEditor(company).sortAirplaneByRange();
    }
}
