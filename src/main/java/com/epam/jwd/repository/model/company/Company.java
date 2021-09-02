package com.epam.jwd.repository.model.company;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private String name;
    private final List<Airplane> airplanes = new ArrayList<>();

    public Company(String name, List<Airplane> defaultAirplanes){
        this.name = name;
        airplanes.addAll(defaultAirplanes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airplane> getAirplanes() {
        List<Airplane> result = new ArrayList<>();
        Collections.copy(result, airplanes);
        return result;
    }

    public List<Airplane> getPassengerAirplanes(){
        List<Airplane> result = new ArrayList<>();
        airplanes.forEach(airplane -> {
            if (airplane instanceof PassengerPlane){
                result.add(airplane);
            }
        });
        return result;
    }

    public List<Airplane> getCargoAirplanes(){
        List<Airplane> result = new ArrayList<>();
        airplanes.forEach(airplane -> {
            if (airplane instanceof CargoPlane){
                result.add(airplane);
            }
        });
        return result;
    }
}

