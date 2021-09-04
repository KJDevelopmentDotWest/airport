package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.controller.command.CommandProvider;
import com.epam.jwd.service.CompanyCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountTotalCapacity implements Command {
    private static final Logger logger = LogManager.getLogger(CountTotalCapacity.class);

    @Override
    public String execute() {
        CompanyCreator companyCreator = new CompanyCreator("MyCompany");
        int count = companyCreator.countTotalCapacity();
        String str = " " + count;
        return str;
    }
}
