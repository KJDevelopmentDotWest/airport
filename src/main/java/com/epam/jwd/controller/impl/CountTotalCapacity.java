package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.editor.CompanyEditor;


public class CountTotalCapacity implements Command {
    @Override
    public String execute() {
        Company company = new Company();
        CompanyEditor companyEditor = new CompanyEditor(company);
        int countTotalCapacity = companyEditor.countTotalCapacity();
        String str = " " + countTotalCapacity;
        return str;
    }
}
