package com.epam.jwd.service.validator;

public class CompanyValidator {
    public static boolean validateMinMaxFuelConsumption(int minFuelConsumption, int maxFuelConsumption) {
        return (minFuelConsumption < maxFuelConsumption) && minFuelConsumption > 0 && maxFuelConsumption > 0;
    }
    public static boolean validateId(int id){
        return id >= 0;
    }

}
