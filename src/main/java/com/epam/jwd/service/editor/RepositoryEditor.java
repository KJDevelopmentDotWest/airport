package com.epam.jwd.service.editor;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.repository.storage.Repository;

public class RepositoryEditor {
    public static void addAirplaneToRepository(Airplane airplane) {
        Repository.getDefaultAirplanes().add(airplane);
    }

    public static void deleteAirplaneFromRepository(Airplane airplane) {
        Repository.getDefaultAirplanes().remove(airplane);
    }

    public static void addCompanyToRepository(Company company) {
        Repository.findAllCompanies().add(company);
    }

    public static void deleteCompanyFromRepository(Company company) {
        Repository.findAllCompanies().remove(company);
    }

    public static void saveRepositoryToFile() {
        Repository.saveAllToMemory();
    }
}
