package com.epam.jwd.service.editor;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CompanyEditorTest {
    private static List<Airplane> defaultAirplanes;
    private static Company company;
    private static CompanyEditor companyEditor;

    @BeforeAll
    static void beforeAll() {
        defaultAirplanes = Arrays.asList(
                new PassengerPlane.Builder()
                        .withFuelConsumption(2400)
                        .withManufacturer("Boeing")
                        .withModel("737-500")
                        .withRange(4444)
                        .withSeats(110)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(10200)
                        .withManufacturer("Boeing")
                        .withModel("747-8")
                        .withRange(14815)
                        .withSeats(581)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(20)
                        .withManufacturer("Boeing")
                        .withModel("767")
                        .withRange(1900)
                        .withPayload(4000)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(3600)
                        .withManufacturer("Airbus")
                        .withModel("A300-A600F")
                        .withRange(3800)
                        .withPayload(19000)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(2500)
                        .withManufacturer("Airbus")
                        .withModel("A320")
                        .withRange(4000)
                        .withSeats(140)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(1500)
                        .withManufacturer("Embraer")
                        .withModel("175")
                        .withRange(3334)
                        .withSeats(76)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(1980)
                        .withManufacturer("An")
                        .withModel("12")
                        .withRange(5530)
                        .withPayload(20000)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(9000)
                        .withManufacturer("Il")
                        .withModel("76Т")
                        .withRange(3600)
                        .withPayload(50000)
                        .build()
        );
    }

    @BeforeEach
    void setUp() {
        company = new Company();
        company.setName("TestCompany");
        company.getAirplanes().addAll(defaultAirplanes);
        companyEditor = new CompanyEditor(company);
    }

    @Test
    @DisplayName("Test findAirplaneByFuelConsumption exception ")
    void findAirplaneByFuelConsumption_InvalidArgument_ExceptionThrown() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> companyEditor.findAirplaneByFuelConsumption(-1, 5)),
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> companyEditor.findAirplaneByFuelConsumption(5, -1)),
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> companyEditor.findAirplaneByFuelConsumption(0, 1)),
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> companyEditor.findAirplaneByFuelConsumption(1, 0)),
                () -> Assertions.assertThrows(MinMaxFuelConsumptionExeption.class, () -> companyEditor.findAirplaneByFuelConsumption(-1, -1)));
    }

    @Test
    @DisplayName("Test findAirplaneByFuelConsumption filter for list")
    void findAirplaneByFuelConsumption_ArrayEquals() throws MinMaxFuelConsumptionExeption {
        int min = 4500;
        int max = 5500;
        Assertions.assertArrayEquals(
                defaultAirplanes.stream()
                        .filter(airplane -> airplane.getFuelConsumption() >= min && airplane.getFuelConsumption() <= max)
                        .toArray(),
                companyEditor.findAirplaneByFuelConsumption(min, max).stream()
                        .toArray());
    }

    @Test
    @DisplayName("Test addAirplaneToCompany exception")
    void addAirplaneToCompany_InvalidArgument_ExceptionThrown() {
        Assertions.assertThrows(WrongIdException.class, () -> companyEditor.addAirplaneToCompany(-1));
    }


}