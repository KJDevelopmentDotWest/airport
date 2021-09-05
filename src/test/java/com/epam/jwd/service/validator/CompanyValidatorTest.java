package com.epam.jwd.service.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyValidatorTest {

    @Test
    void validateMinMaxFuelConsumption() {
        int min = 2;
        int max = 5;
        Assertions.assertEquals(true, CompanyValidator.validateMinMaxFuelConsumption(2,5));
    }

    @Test
    void validateId() {
        int id = 5;
        Assertions.assertEquals(true,
                CompanyValidator.validateId(5));
    }
}