package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.editor.CompanyEditor;

public class CountTotalPayLoad  implements Command {
    @Override
    public String execute() {
        Company company = new Company();
        CompanyEditor companyEditor = new CompanyEditor(company);
        int countTotalPayload = companyEditor.countTotalPayload();
        String str = " " + countTotalPayload;
        return str;
    }
}
