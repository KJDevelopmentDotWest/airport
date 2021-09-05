package com.epam.jwd.service.editor;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.repository.storage.Repository;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;
import com.epam.jwd.service.validator.CompanyValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyEditor {
    private static final Logger logger = LogManager.getLogger(CompanyEditor.class);

    private static final String MIN_MAX_FUELCONSUMPTION_ERROR_MESSAGE = "Min Max is not valid";

    private static final String ID_ERROR_MESSAGE = "Id should be greater than 0";

    private static final String START_COUNT_TOTAL_PAYLOAD_METHOD = "We-ve started countTotalPayloadMethod";

    private static final String START_ADD_AIRPLANE_TO_COMPANY_METHOD_MESSAGE = "We've started addAirplaneToCompany method";

    private static final String END_ADD_AIRPLANE_TO_COMPANY_METHOD_MESSAGE = "We've finished addAirplaneToCompany method";

    private static final String START_DELETE_AIRPLANE_FROM_COMPANY_METHOD_MESSAGE = "We've started deleteAirplaneFromCompany method";

    private static final String END_DELETE_AIRPLANE_FROM_COMPANY_METHOD_MESSAGE = "We've finished deleteAirplaneFromCompany method";

    private static final String START_COUNT_TOTAL_CAPACITY_METHOD = "We've started countTotalCapacity method";

    private static final String START_AIRPLANE_BYFUEL_CONSUPTION_METHOD = "We've started airplaneByFuelMethod";

    private static final String END_AIRPLANE_BYFUEL_CONSUPTION_METHOD ="We've finished airplaneByFuelMethod" ;

    private static final String SORT_AIRPLANE_BY_RANGE_MESSAGE = "We're in sortAirplaneByRangeMessage";

    Company company;

    public CompanyEditor(Company company) {
        this.company = company;
    }

    public void addAirplaneToCompany(int id) throws WrongIdException {
        logger.debug(START_ADD_AIRPLANE_TO_COMPANY_METHOD_MESSAGE);
        if (CompanyValidator.validateId(id)) {
            company.getAirplanes().add(Repository.getDefaultAirplanes().stream()
                    .filter(airplane -> airplane.getId() == id)
                    .findFirst()
                    .get());
        } else {
            logger.info(ID_ERROR_MESSAGE);
            throw new WrongIdException(ID_ERROR_MESSAGE);
        }
        logger.debug(END_ADD_AIRPLANE_TO_COMPANY_METHOD_MESSAGE);
    }

    public void deleteAirplaneFromCompany(int id) {
        logger.debug(START_DELETE_AIRPLANE_FROM_COMPANY_METHOD_MESSAGE);
        company.getAirplanes().remove(company.getAirplanes().stream()
                .filter(airplane -> airplane.getId() == id)
                .findFirst()
                .get());
        logger.debug(END_DELETE_AIRPLANE_FROM_COMPANY_METHOD_MESSAGE);
    }

    public List<Airplane> getCompanyAirplanes() {
        return Collections.unmodifiableList(company.getAirplanes());
    }

    public int countTotalCapacity() {
        logger.debug(START_COUNT_TOTAL_CAPACITY_METHOD);
        return company.getAirplanes().stream()
                .filter(airplane -> airplane instanceof PassengerPlane)
                .mapToInt(value -> ((PassengerPlane) value).getSeats())
                .sum();
    }

    public int countTotalPayload() {
        logger.debug(START_COUNT_TOTAL_PAYLOAD_METHOD);
        return company.getAirplanes().stream()
                .filter(airplane -> airplane instanceof CargoPlane)
                .mapToInt(value -> ((CargoPlane) value).getPayload())
                .sum();
    }

    public List<Airplane> findAirplaneByFuelConsumption(int minFuelConsumption, int maxFuelConsumption) throws MinMaxFuelConsumptionExeption {
        logger.debug(START_AIRPLANE_BYFUEL_CONSUPTION_METHOD);
        if (CompanyValidator.validateMinMaxFuelConsumption(minFuelConsumption, maxFuelConsumption)) {
            logger.debug(END_AIRPLANE_BYFUEL_CONSUPTION_METHOD);
            return company.getAirplanes().stream()
                    .filter(airplane -> airplane.getFuelConsumption() >= minFuelConsumption
                            && airplane.getFuelConsumption() <= maxFuelConsumption)
                    .collect(Collectors.toList());
        } else {
            logger.info(MIN_MAX_FUELCONSUMPTION_ERROR_MESSAGE);
            throw new MinMaxFuelConsumptionExeption(MIN_MAX_FUELCONSUMPTION_ERROR_MESSAGE);
        }
    }

    public List<Airplane> sortAirplaneByRange() {
        logger.debug(SORT_AIRPLANE_BY_RANGE_MESSAGE);
        return company.getAirplanes().stream()
                .sorted(Comparator.comparingInt(Airplane::getRange))
                .collect(Collectors.toList());
    }
}
