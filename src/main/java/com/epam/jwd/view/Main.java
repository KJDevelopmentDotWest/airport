package com.epam.jwd.view;


import com.epam.jwd.controller.impl.CountTotalCapacity;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.storage.Repository;
import com.epam.jwd.service.reader.RepositoryReader;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Repository.saveAllToMemory();
        System.out.println(Repository.findAllCompanies().get(0));
        CountTotalCapacity countTotalCapacity = new CountTotalCapacity();
        System.out.println(countTotalCapacity.execute());
        List<Airplane> repositoryReader = RepositoryReader.getAirplanes();
        System.out.println(repositoryReader + "Hello");
    }

}
