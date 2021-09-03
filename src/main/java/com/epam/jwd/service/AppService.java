package com.epam.jwd.service;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.repository.storage.Repository;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;
import com.epam.jwd.service.validator.ServiceValidator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppService {
    private final String ID_ERROR_MESSAGE = "Id should be greater than 0";
    private final String MIN_MAX_FUELCONSUMPTION_ERROR_MESSAGE = "Min Max is not valid";
    private Company company;

    public void makeCompany(String nameCompany) {
        company = new Company(nameCompany);
    }

    public void addAirplaneToCompany(int id) throws WrongIdException {
        if (ServiceValidator.validateId(id)) {
            company.getAirplanes().add(Repository.getDefaultAirplanes().get(id));
        } else {
            //logger
            throw new WrongIdException(ID_ERROR_MESSAGE);
        }
    }

    public void deleteAirplaneFromCompany(int id) {
        company.getAirplanes().remove(company.getAirplanes().get(id));
    }

    public void saveToRepository() {
        Repository.findAllCompanies().add(company);
    }

    public int countTotalCapacity() {
        return company.getAirplanes().stream()
                .filter(airplane -> airplane instanceof PassengerPlane)
                .mapToInt(value -> ((PassengerPlane) value).getSeats())
                .sum();
    }

    public int countTotalPayload() {
        return company.getAirplanes().stream()
                .filter(airplane -> airplane instanceof CargoPlane)
                .mapToInt(value -> ((CargoPlane) value).getPayload())
                .sum();
    }

    public List<Airplane> findAirplaneByFuelConsumption(int minFuelConsumption, int maxFuelConsumption) throws MinMaxFuelConsumptionExeption {
        if (ServiceValidator.validateMinMaxFuelConsumption(minFuelConsumption, maxFuelConsumption)) {
            return company.getAirplanes().stream()
                    .filter(airplane -> airplane.getFuelConsumption() >= minFuelConsumption
                            && airplane.getFuelConsumption() <= maxFuelConsumption)
                    .collect(Collectors.toList());
        } else {
            //logger
            throw new MinMaxFuelConsumptionExeption(MIN_MAX_FUELCONSUMPTION_ERROR_MESSAGE);
        }
    }

    public List<Airplane> sortAirplaneByRange() {
        return company.getAirplanes().stream()
                .sorted(Comparator.comparingInt(Airplane::getRange))
                .collect(Collectors.toList());
    }
}
