package com.epam.jwd.repository.model.company;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company{

    private String name;
    private final List<Airplane> airplanes = new ArrayList<>();
    private int id;

    public Company(String name, int id, List<Airplane> defaultAirplanes){
        this.name = name;
        this.id = id;
        airplanes.addAll(defaultAirplanes);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
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

    public Airplane getById(int id){
        return airplanes.stream()
                .filter(airplane -> id == airplane.getId())
                .findFirst()
                .orElse(null);
    }

    public void addAirplane(Airplane source){
        airplanes.add(source);
    }

    public void removeAirplanes(Airplane source){
        boolean flag = true;
        while (flag){
            flag = airplanes.remove(source);
        }
    }

    public void removeAirplanes(int airplaneId){
        airplanes.removeAll(airplanes
                .stream()
                .filter(airplane -> airplaneId == airplane.getId())
                .toList());
    }
}

