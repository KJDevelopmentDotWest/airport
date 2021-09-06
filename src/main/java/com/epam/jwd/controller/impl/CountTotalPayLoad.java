package com.epam.jwd.controller.impl;

import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.editor.CompanyEditor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountTotalPayLoad {
    private static final Logger logger = LogManager.getLogger(CountTotalPayLoad.class);


    public String execute() {
        Company company = new Company();
        CompanyEditor companyEditor = new CompanyEditor(company);
        int countTotalPayload = companyEditor.countTotalPayload();
        String str = " " + countTotalPayload;
        return str;
    }
}
