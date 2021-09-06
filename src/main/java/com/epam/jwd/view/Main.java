package com.epam.jwd.view;

import com.epam.jwd.service.exception.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exception.WrongIdException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String MAIN_METHOD_MESSAGE = "We're in main method";

    public static void main(String[] args) throws WrongIdException, MinMaxFuelConsumptionExeption {
        logger.debug(MAIN_METHOD_MESSAGE);
        View view = new View();
        view.start(Level.INFO);
    }
}
