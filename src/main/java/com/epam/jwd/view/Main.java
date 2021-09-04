package com.epam.jwd.view;

import com.epam.jwd.repository.storage.Repository;

public class Main {
    public static void main(String[] args) {
        //Repository.saveAllToMemory();
        System.out.println(Repository.findAllCompanies().get(0));
    }
}



