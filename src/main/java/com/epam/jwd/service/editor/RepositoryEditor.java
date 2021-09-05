package com.epam.jwd.service.editor;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.repository.storage.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepositoryEditor {
    private static final Logger logger = LogManager.getLogger(RepositoryEditor.class);

    private static final String ADD_AIRPLANE_TO_REPOSITORY_MESSAGE = "We're in addAirplaneToRepository method";

    private static final String DELETE_AIRPLANE_FROM_REPOSITORY_MESSAGE = "We're in deleteAirplaneFromRepository method";

    private static final String ADD_COMPANY_TO_REPOSITORY_MESSAGE = "We're in addCompanyToRepository method";

    private static final String DELETE_COMPANY_FROM_REPOSITORY_MESSAGE = "We're in deleteCompanyFromRepository method";

    private static final String SAVE_REPOSITORY_TO_FIELD_MESSAGE = "We're in saveRepositoryToField method";

    public static void addCompanyToRepository(Company company) {
        logger.debug(ADD_COMPANY_TO_REPOSITORY_MESSAGE);
        Repository.findAllCompanies().add(company);
    }

    public static void deleteCompanyFromRepository(Company company) {
        logger.debug(DELETE_COMPANY_FROM_REPOSITORY_MESSAGE);
        Repository.findAllCompanies().remove(company);
    }

    public static void saveRepositoryToFile() {
        logger.debug(SAVE_REPOSITORY_TO_FIELD_MESSAGE);
        Repository.saveAllToMemory();
    }
}
