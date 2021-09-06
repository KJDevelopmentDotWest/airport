package com.epam.jwd.service.reader;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.repository.storage.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class RepositoryReader {
    private static final Logger logger = LogManager.getLogger(RepositoryReader .class);

    private static final String GET_DEFAULT_AIRPLANES_MESSAGE ="We're in getDefaultAirplanes() method" ;

    private static final String GET_COMPANIES_MESSAGE ="We're in getCompanies() method" ;

    public static List<Company> getCompanies() {
        logger.debug(GET_COMPANIES_MESSAGE);
        return Collections.unmodifiableList(Repository.findAllCompanies());
    }

    public static List<Airplane> getDefaultAirplanes() {
        logger.debug(GET_DEFAULT_AIRPLANES_MESSAGE);
        return Collections.unmodifiableList(Repository.getDefaultAirplanes());
    }
}
