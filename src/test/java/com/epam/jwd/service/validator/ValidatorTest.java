package com.epam.jwd.service.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateMinMaxFuelConsumption() {
        int min = 2;
        int max = 5;
        Assertions.assertEquals(true, Validator.validateMinMaxFuelConsumption(2,5));
    }

    @Test
    void validateId() {
        int id = 5;
        Assertions.assertEquals(true,
                Validator.validateId(5));
    }
}