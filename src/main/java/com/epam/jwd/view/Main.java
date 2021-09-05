package com.epam.jwd.view;

import com.epam.jwd.service.exeption.WrongIdException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String MAIN_METHOD_MESSAGE = "We're in main method";

    public static void main(String[] args) throws WrongIdException {
//        logger.debug(MAIN_METHOD_MESSAGE);
//        CompanyEditor companyEditor = new CompanyEditor(Controller.createCompany("company3"));
//        companyEditor.addAirplaneToCompany(RepositoryReader.getDefaultAirplanes().get(0).getId());
//        System.out.println(Controller.getCompanies().get(2).getAirplanes());
//        //System.out.println(Controller.getCompanies().get(0).getAirplanes());
//        View view = new View();
//        view.start;
    }

}
