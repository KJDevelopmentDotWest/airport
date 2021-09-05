package com.epam.jwd.service.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompanyValidator {
    private static final Logger logger = LogManager.getLogger(CompanyValidator.class);

    private static final String VALIDATE_MIN_MAX_FUEL_CONSUMPTION_MESSAGE = "We're in validateMinMaxFuelConsumption method";

    private static final String VALIDATE_ID_MESSAGE = "We're in validateId method";

    public static boolean validateMinMaxFuelConsumption(int minFuelConsumption, int maxFuelConsumption) {
        logger.debug(VALIDATE_MIN_MAX_FUEL_CONSUMPTION_MESSAGE);
        return (minFuelConsumption < maxFuelConsumption) && minFuelConsumption > 0;
    }
    public static boolean validateId(int id){
        logger.debug(VALIDATE_ID_MESSAGE);
        return id >= 0;
    }
}
