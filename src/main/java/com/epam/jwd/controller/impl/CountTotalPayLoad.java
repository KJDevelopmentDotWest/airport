package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.repository.storage.Repository;
import com.epam.jwd.service.CompanyCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountTotalPayLoad  implements Command {
    private static final Logger logger = LogManager.getLogger(CountTotalPayLoad.class);

    @Override
    public String execute() {
        Repository.getDefaultAirplanes();
        CompanyCreator companyCreator = new CompanyCreator("MyCompany");
        int count = companyCreator.countTotalPayload();
        String str = " " + count;
        return str;
    }
}
