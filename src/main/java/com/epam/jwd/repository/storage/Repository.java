package com.epam.jwd.repository.storage;

import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {

    private final List<Company> companies = new ArrayList<>();

    public Repository(){
        companies.add(new Company(
                "CompanyOne",
                Arrays.asList(
                        new PassengerPlane.Builder()
                                .withFuelConsumption(10)
                                .withManufacturer("Boeing")
                                .withModel("777")
                                .withRange(1000)
                                .withSeats(400)
                                .build(),
                        new PassengerPlane.Builder()
                                .withFuelConsumption(12)
                                .withManufacturer("Boeing")
                                .withModel("787")
                                .withRange(1200)
                                .withSeats(500)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(20)
                                .withManufacturer("Boeing")
                                .withModel("767")
                                .withRange(1900)
                                .withPayload(4000)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(40)
                                .withManufacturer("Airbus")
                                .withModel("A300")
                                .withRange(4000)
                                .withPayload(8000)
                                .build()
                )
        ));
        companies.add(new Company(
                "CompanyTwo",
                Arrays.asList(
                        new PassengerPlane.Builder()
                                .withFuelConsumption(10)
                                .withManufacturer("Boeing")
                                .withModel("777")
                                .withRange(1000)
                                .withSeats(400)
                                .build(),
                        new PassengerPlane.Builder()
                                .withFuelConsumption(12)
                                .withManufacturer("Boeing")
                                .withModel("787")
                                .withRange(1200)
                                .withSeats(500)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(20)
                                .withManufacturer("Boeing")
                                .withModel("767")
                                .withRange(1900)
                                .withPayload(4000)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(40)
                                .withManufacturer("Airbus")
                                .withModel("A300")
                                .withRange(4000)
                                .withPayload(8000)
                                .build()
                )
        ));
    }

    public void saveCompany(Company company){
        companies.add(company);
    }

    public Company findCompanyByName(String name){
        return companies.stream()
                .filter(company -> name.equals(company.getName()))
                .findFirst()
                .orElse(null);
    }

    public List<Company> findAllCompanies(){
        return companies;
    }

}
