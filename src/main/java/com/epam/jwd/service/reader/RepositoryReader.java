package com.epam.jwd.service.reader;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.repository.storage.Repository;

import java.util.Collections;
import java.util.List;

public class RepositoryReader {
    public static List<Company> getCompanies() {
        return Collections.unmodifiableList(Repository.findAllCompanies());
    }

    public static List<Airplane> getAirplanes() {
        return Collections.unmodifiableList(Repository.getDefaultAirplanes());
    }
}
