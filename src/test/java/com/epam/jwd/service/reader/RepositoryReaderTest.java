package com.epam.jwd.service.reader;

import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RepositoryReaderTest {
    @Test
    @DisplayName("Try to make change in RO list getCompanies")
    void getCompanies_ExceptionThrown() {
        Assertions.assertAll(() -> Assertions.assertThrows(UnsupportedOperationException.class, () -> RepositoryReader.getCompanies().add(new Company("test"))),
                () -> Assertions.assertThrows(UnsupportedOperationException.class, () -> RepositoryReader.getCompanies().add(null)));
    }

    @Test
    @DisplayName("Try to make change in RO list getDefaultAirplanes")
    void getDefaultAirplanes_ExceptionThrown() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(UnsupportedOperationException.class, () -> RepositoryReader.getDefaultAirplanes().add(new PassengerPlane.Builder().build())),
                () -> Assertions.assertThrows(UnsupportedOperationException.class, () -> RepositoryReader.getDefaultAirplanes().add(new CargoPlane.Builder().build())),
                () -> Assertions.assertThrows(UnsupportedOperationException.class, () -> RepositoryReader.getDefaultAirplanes().add(null)));
    }
}