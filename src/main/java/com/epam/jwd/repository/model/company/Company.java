package com.epam.jwd.repository.model.company;

import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.storage.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Company implements Serializable {

    private String name;
    private final List<Airplane> airplanes = new ArrayList<>();
    private final int id;
    private static final long serialVersionUID = 6529685098267757690L;

    public Company(String name, List<Airplane> defaultAirplanes){
        this.name = name;
        this.id = generateId();
        airplanes.addAll(defaultAirplanes);
    }

    public Company(String name){
        this.name = name;
        this.id = generateId();
    }

    public Company(){
        this.id = generateId();
    }

    public void setName(String name){
        this.name = name;
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
    public  List<Airplane> getPassengerAirplanes(){
        return airplanes.stream().filter(airplane -> airplane instanceof PassengerPlane).collect(Collectors.toList());
    }

    public List<Airplane> getCargoAirplanes(){
        return airplanes.stream().filter(airplane -> airplane instanceof CargoPlane).collect(Collectors.toList());
    }

    private int generateId(){
        return Repository.findAllCompanies().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (!name.equals(company.name)) return false;
        return airplanes.equals(company.airplanes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id) + Objects.hashCode(airplanes) + Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", airplanes=" + airplanes +
                ", id=" + id +
                '}';
    }
}

