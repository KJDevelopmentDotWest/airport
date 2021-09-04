package com.epam.jwd.controller.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.service.CompanyCreator;

public class CountTotalCapacity implements Command {
    @Override
    public String execute() {
        CompanyCreator companyCreator = new CompanyCreator("MyCompany");
        int count = companyCreator.countTotalCapacity();
        String str = " " + count;
        return str;
    }
}
