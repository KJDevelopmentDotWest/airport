package com.epam.jwd.service.reader;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.repository.storage.Repository;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class RepositoryReader {
    private static final Logger logger = LogManager.getLogger(RepositoryReader .class);

    public static List<Company> getCompanies() {
        return Collections.unmodifiableList(Repository.findAllCompanies());
    }

    public static List<Airplane> getDefaultAirplanes() {
        return Collections.unmodifiableList(Repository.getDefaultAirplanes());
    }
}
