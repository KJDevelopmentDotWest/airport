package com.epam.jwd.service.creator;

import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.editor.RepositoryEditor;

public class CompanyCreator {
    private Company company = new Company();

    public CompanyCreator(String nameCompany) {
        company.setName(nameCompany);
        RepositoryEditor.addCompanyToRepository(company);
    }

    public Company getCompany() {
        return company;
    }
}
