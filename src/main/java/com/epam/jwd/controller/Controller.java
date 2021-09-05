package com.epam.jwd.controller;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;

import com.epam.jwd.service.creator.CompanyCreator;
import com.epam.jwd.service.editor.CompanyEditor;
import com.epam.jwd.service.editor.RepositoryEditor;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;
import com.epam.jwd.service.reader.RepositoryReader;


import java.util.List;

public class Controller {

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

    public static List<Airplane> sortByFuelConsumptionRange(Company company) throws MinMaxFuelConsumptionExeption {
        return new CompanyEditor(company).findAirplaneByFuelConsumption(10,20);
    }

    public static List<Airplane> getCompany (Company company){
        return new CompanyEditor(company).getCompanyAirplanes();

    }
    //calculate payload
    //sort by range
    //find by fuel consumption range
    //find by manufacturer
}
