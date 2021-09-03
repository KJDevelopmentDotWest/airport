package com.epam.jwd.repository.model.company;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.storage.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Company{

    private final String name;
    private final List<Airplane> airplanes = new ArrayList<>();
    private final int id;

    public Company(String name, List<Airplane> defaultAirplanes){
        this.name = name;
        this.id = generateId();
        airplanes.addAll(defaultAirplanes);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public List<Airplane> getPassengerAirplanes(){
        return airplanes.stream().filter(airplane -> airplane instanceof PassengerPlane).collect(Collectors.toList());
    }

    public List<Airplane> getCargoAirplanes(){
        return airplanes.stream().filter(airplane -> airplane instanceof CargoPlane).collect(Collectors.toList());
    }

    private int generateId(){
        return Repository.findAllCompanies().size();
    }
}

