package com.epam.jwd.view;


import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.storage.Repository;

public class Main {
    public static void main(String[] args) {

        showcase();

    }


    //TODO showcase of functionality, can be removed
    private static void showcase(){
        System.out.println("ad");
        System.out.println(Repository.findCompanyById(2).getAirplanes());
        Repository.findCompanyById(2).addAirplane(new PassengerPlane.Builder()
                .withFuelConsumption(10)
                .withManufacturer("Boeing")
                .withModel("777")
                .withRange(1000)
                .withSeats(400)
                .withId(1)
                .build());
        Repository.findCompanyById(2).removeAirplanes(1);
        System.out.println(Repository.findCompanyById(2).getAirplanes());
    }
}
