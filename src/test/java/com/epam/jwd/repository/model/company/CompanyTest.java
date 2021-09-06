package com.epam.jwd.repository.model.company;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CompanyTest {

    private static List<Airplane> airplanesExpected;
    private static List<Airplane> airplanesPassengerExpected;
    private static List<Airplane> airplanesCargoExpected;
    private static Airplane reservePlane = new PassengerPlane.Builder()
            .withFuelConsumption(10)
            .withManufacturer("Boeing")
            .withModel("777")
            .withRange(1000)
            .withSeats(400)
            .build();

    @BeforeAll
    static void setUp() {
        airplanesExpected = Arrays.asList(
                new PassengerPlane.Builder()
                        .withFuelConsumption(10)
                        .withManufacturer("Boeing")
                        .withModel("777")
                        .withRange(1000)
                        .withSeats(400)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(12)
                        .withManufacturer("Boeing")
                        .withModel("787")
                        .withRange(1200)
                        .withSeats(500)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(20)
                        .withManufacturer("Boeing")
                        .withModel("767")
                        .withRange(1900)
                        .withPayload(4000)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(40)
                        .withManufacturer("Airbus")
                        .withModel("A300")
                        .withRange(4000)
                        .withPayload(8000)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(10)
                        .withManufacturer("Boeing")
                        .withModel("777")
                        .withRange(1000)
                        .withSeats(400)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(12)
                        .withManufacturer("Boeing")
                        .withModel("787")
                        .withRange(1200)
                        .withSeats(500)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(20)
                        .withManufacturer("Boeing")
                        .withModel("767")
                        .withRange(1900)
                        .withPayload(4000)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(40)
                        .withManufacturer("Airbus")
                        .withModel("A300")
                        .withRange(4000)
                        .withPayload(8000)
                        .build()
        );

        airplanesPassengerExpected = Arrays.asList(
                new PassengerPlane.Builder()
                        .withFuelConsumption(10)
                        .withManufacturer("Boeing")
                        .withModel("777")
                        .withRange(1000)
                        .withSeats(400)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(12)
                        .withManufacturer("Boeing")
                        .withModel("787")
                        .withRange(1200)
                        .withSeats(500)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(10)
                        .withManufacturer("Boeing")
                        .withModel("777")
                        .withRange(1000)
                        .withSeats(400)
                        .build(),
                new PassengerPlane.Builder()
                        .withFuelConsumption(12)
                        .withManufacturer("Boeing")
                        .withModel("787")
                        .withRange(1200)
                        .withSeats(500)
                        .build()
        );

        airplanesCargoExpected = Arrays.asList(
                new CargoPlane.Builder()
                        .withFuelConsumption(20)
                        .withManufacturer("Boeing")
                        .withModel("767")
                        .withRange(1900)
                        .withPayload(4000)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(40)
                        .withManufacturer("Airbus")
                        .withModel("A300")
                        .withRange(4000)
                        .withPayload(8000)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(20)
                        .withManufacturer("Boeing")
                        .withModel("767")
                        .withRange(1900)
                        .withPayload(4000)
                        .build(),
                new CargoPlane.Builder()
                        .withFuelConsumption(40)
                        .withManufacturer("Airbus")
                        .withModel("A300")
                        .withRange(4000)
                        .withPayload(8000)
                        .build()
                );
    }


    @Test
    void getAirplanes() {
        Company company = new Company("Company", airplanesExpected);
        List<Airplane> companyAirplanes = company.getAirplanes();
        Assertions.assertEquals(airplanesExpected, companyAirplanes);
    }

    @Test
    void getAirplanes_NO_NULL() {
        Company company = new Company("Company", airplanesPassengerExpected);
        List<Airplane> airplanes = company.getAirplanes();
        Assertions.assertNotNull(airplanes);
    }


    @Test
    void getPassengerAirplanes() {
        Company company = new Company("Company", airplanesPassengerExpected);
        List<Airplane> airplanesPassengers = company.getPassengerAirplanes();
        Assertions.assertEquals(airplanesPassengerExpected, airplanesPassengers);
    }

    @Test
    void getPassengerAirplanesNegative() {
        List<Airplane> airplanesPassengerExpected = new ArrayList<>();
        Company company = new Company("Company", airplanesPassengerExpected);
        airplanesPassengerExpected.add((new PassengerPlane.Builder()
                .withFuelConsumption(12)
                .withManufacturer("Boeing")
                .withModel("787")
                .withRange(1200)
                .withSeats(500)
                .build()));
        List<Airplane> airplanesPassengers = company.getPassengerAirplanes();
        Assertions.assertNotEquals(airplanesPassengerExpected, airplanesPassengers);
    }

    @Test
    void getPassengerAirplanes_NO_NULL() {
        Company company = new Company("Company", airplanesPassengerExpected);
        List<Airplane> airplanesPassengers = company.getPassengerAirplanes();
        Assertions.assertNotNull(airplanesPassengers);
    }


    @Test
    void getCargoAirplanes() {
        Company company = new Company("Company", airplanesCargoExpected);
        List<Airplane> airplanesCargo = company.getCargoAirplanes();
        Assertions.assertEquals(airplanesCargoExpected, airplanesCargo);
    }

    @Test
    void getCargoAirplanesNegative() {
        List<Airplane> airplanesCargoExpected = new ArrayList<>();
        Company company = new Company("Company", airplanesCargoExpected);
        airplanesCargoExpected.add((new CargoPlane.Builder()
                .withFuelConsumption(12)
                .withManufacturer("Boeing")
                .withModel("787")
                .withRange(1200)
                .build()));
        List<Airplane> airplanesCargo = company.getCargoAirplanes();
        Assertions.assertNotEquals(airplanesCargoExpected, airplanesCargo);
    }

    @Test
    void getCargoAirplanes_NO_NULL() {
        Company company = new Company("Company", airplanesCargoExpected);
        List<Airplane> airplanesCargo = company.getCargoAirplanes();
        Assertions.assertNotNull(airplanesCargo);
    }
}