package com.epam.jwd.view;

import com.epam.jwd.repository.storage.Repository;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        System.out.println(repository.findAllCompanies().get(0).getName());
    }
}
