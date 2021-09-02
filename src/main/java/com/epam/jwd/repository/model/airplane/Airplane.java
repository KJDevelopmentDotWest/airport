package com.epam.jwd.repository.model.airplane;

public abstract class Airplane {
    protected int fuelConsumption;
    protected int range;
    protected String manufacturer;
    protected String model;

    protected void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setRange(int range) {
        this.range = range;
    }

    protected void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    protected void setModel(String model) {
        this.model = model;
    }

}
