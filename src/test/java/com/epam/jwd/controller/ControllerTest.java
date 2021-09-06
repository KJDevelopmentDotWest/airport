package com.epam.jwd.controller;

import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.exception.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exception.WrongIdException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ControllerTest {
    @Test
    void createCompany_withNameAndwithoutName_InstanceOfCompany() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(Controller.createCompany("") instanceof Company),
                () -> Assertions.assertTrue(Controller.createCompany("TestName") instanceof Company));
    }

    @Test
    void addAirplaneToCompany_WrongId_ExceptionThrown() {
        Assertions.assertThrows(WrongIdException.class, () -> Controller.addAirplanesToCompany(new Company("test"), -1));
    }

    @Test
    void getDefaultAirplanes_ReturnReadOnlyList_ExceptionThrown() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> Controller.getDefaultAirplanes().add(new CargoPlane.Builder().build()));
    }

    @Test
    void findAirplaneByFuelConsumption_WrongIdOrNull_ExceptionThrown() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> Controller.findAirplaneByFuelConsumption(new Company(), -1, 0)),
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> Controller.findAirplaneByFuelConsumption(new Company(), 2, -1)),
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> Controller.findAirplaneByFuelConsumption(new Company(), 8, 6)));
    }

    @Test
    void allMethodsWithCompanyParam_NullCompanyParam_ExceptionThrown() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(NullPointerException.class, () -> Controller.findAirplaneByFuelConsumption(null, 2, 6)),
                () -> Assertions.assertThrows(NullPointerException.class, () -> Controller.addAirplanesToCompany(null, 1)),
                () -> Assertions.assertThrows(NullPointerException.class, () -> Controller.calculateTotalCapacity(null)),
                () -> Assertions.assertThrows(NullPointerException.class, () -> Controller.calculatePayload(null)),
                () -> Assertions.assertThrows(NullPointerException.class, () -> Controller.getCompanyAirplanes(null)),
                () -> Assertions.assertThrows(NullPointerException.class, () -> Controller.deleteAirplaneFromCompany(null, 1)),
                () -> Assertions.assertThrows(NullPointerException.class, () -> Controller.sortAirplaneByRange(null)));
    }
}
