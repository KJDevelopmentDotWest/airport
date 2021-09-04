package com.epam.jwd.repository.model.airplane;

import java.io.Serializable;

public abstract class Airplane implements Serializable {
    protected int fuelConsumption;
    protected int range;
    protected String manufacturer;
    protected String model;
    int id;
    private static final long serialVersionUID = 6529685098267757699L;

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
