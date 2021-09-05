package com.epam.jwd.repository.model.airplane;

import com.epam.jwd.controller.impl.SortAirplaneByRange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class CargoPlane extends Airplane{

    private static final Logger logger = LogManager.getLogger(CargoPlane.class);

    private static final String MESSAGE =  "We're in build method";

    private static final long serialVersionUID = 6529685098267757692L;

    private int payload;

    private void setPayload(int payload) {
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    public static class Builder {

        private int payload;
        private int fuelConsumption;
        private int range;
        private int id;
        private String manufacturer;
        private String model;


        public Builder withPayload(int payload){
            this.payload = payload;
            return this;
        }

        public Builder withFuelConsumption(int fuelConsumption){
            this.fuelConsumption = fuelConsumption;
            return this;
        }

        public Builder withRange(int range){
            this.range = range;
            return this;
        }

        public Builder withManufacturer(String manufacturer){
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder withModel(String model){
            this.model = model;
            return this;
        }

        public Builder withId(int id){
            this.id = id;
            return this;
        }

        public CargoPlane build(){
            logger.info(MESSAGE);
            CargoPlane cargoPlane = new CargoPlane();
            cargoPlane.setPayload(payload);
            cargoPlane.setFuelConsumption(fuelConsumption);
            cargoPlane.setRange(range);
            cargoPlane.setManufacturer(manufacturer);
            cargoPlane.setModel(model);
            cargoPlane.setId(id);

            return cargoPlane;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean flag;

        if (this == o) {
            return true;
        }

        if (o instanceof CargoPlane) {
            CargoPlane plane = (CargoPlane) o;
            flag = plane.getFuelConsumption() == fuelConsumption
                    && plane.getManufacturer().equals(manufacturer)
                    && plane.getModel().equals(model)
                    && plane.getRange() == range
                    && plane.getPayload() == payload
                    && plane.getId() == id;
        } else {
            flag = false;
        }

        return flag;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(payload) + Objects.hashCode(fuelConsumption) + Objects.hashCode(range) + Objects.hashCode(manufacturer) + Objects.hashCode(model) + Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CargoPlane{" +
                "fuelConsumption=" + fuelConsumption +
                ", range=" + range +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", id='" + id + '\'' +
                ", payload=" + payload +
                '}';
    }
}
