package com.epam.jwd.repository.model.airplane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BuilderTest {

    @Test
    void testCargoBuider(){
        CargoPlane cargoPlane = new CargoPlane.Builder()
                .withFuelConsumption(20)
                .withManufacturer("Boeing")
                .withModel("767")
                .withRange(1900)
                .withPayload(4000)
                .build();
        Assertions.assertEquals(cargoPlane.getPayload(), 4000);
        Assertions.assertEquals(cargoPlane.getFuelConsumption(), 20);
        Assertions.assertEquals(cargoPlane.getModel(), "767");
        Assertions.assertEquals(cargoPlane.getRange(), 1900);
        Assertions.assertEquals(cargoPlane.getManufacturer(), "Boeing");
    }

    @Test
    void testPassengerBuilder(){
        PassengerPlane passengerPlane = new PassengerPlane.Builder()
                                .withFuelConsumption(12)
                                .withManufacturer("Boeing")
                                .withModel("787")
                                .withRange(1200)
                                .withSeats(500)
                                .withId(2)
                                .build();
        Assertions.assertEquals(passengerPlane.getId(), 2);
        Assertions.assertEquals(passengerPlane.getModel(), "787");
        Assertions.assertEquals(passengerPlane.getManufacturer(), "Boeing");
        Assertions.assertEquals(passengerPlane.getRange(), 1200);
        Assertions.assertEquals(passengerPlane.getFuelConsumption(), 12);
        Assertions.assertEquals(passengerPlane.getSeats(), 500);
    }
}
