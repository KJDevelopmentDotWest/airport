package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.storage.Repository;
import com.epam.jwd.service.CompanyCreator;

public class CountTotalPayLoad  implements Command {
    @Override
    public String execute() {
        Repository.getDefaultAirplanes();
        CompanyCreator companyCreator = new CompanyCreator("MyCompany");
        int count = companyCreator.countTotalPayload();
        String str = " " + count;
        return str;
    }
}
