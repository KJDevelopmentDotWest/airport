package com.epam.jwd.view;


import com.epam.jwd.controller.impl.CountTotalCapacity;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.storage.Repository;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.reader.RepositoryReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String MAIN_METHOD_MESSAGE = "We're in main method";

    public static void main(String[] args) {
        logger.debug(MAIN_METHOD_MESSAGE);
        //Repository.saveAllToMemory();
        System.out.println(Repository.findAllCompanies().get(0));
        CountTotalCapacity countTotalCapacity = new CountTotalCapacity();
        System.out.println(countTotalCapacity.execute());
        List<Airplane> repositoryReader = RepositoryReader.getAirplanes();
        System.out.println(repositoryReader + "Hello");
    }

}
