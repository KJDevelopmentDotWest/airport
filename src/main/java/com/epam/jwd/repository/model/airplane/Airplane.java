package com.epam.jwd.repository.model.airplane;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public abstract class Airplane implements Serializable {

    private static final Logger logger = LogManager.getLogger(Airplane.class);

    protected int fuelConsumption;

    protected int range;

    protected String manufacturer;

    protected String model;

    int id;

    public int getId() {
        return id;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getRange() {
        return range;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    protected void setId(int id) {
        this.id = id;
    }

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
