package com.epam.jwd.repository.model.airplane;

import java.util.Objects;

public class CargoPlane extends Airplane{

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

        if (o instanceof CargoPlane plane) {
            flag = plane.getFuelConsumption() == fuelConsumption
                    && plane.getManufacturer().equals(manufacturer)
                    && plane.getModel().equals(model)
                    && plane.getRange() == range
                    && plane.getPayload() == payload;
        } else {
            flag = false;
        }

        return flag;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(payload) + Objects.hashCode(fuelConsumption) + Objects.hashCode(range) + Objects.hashCode(manufacturer) + Objects.hashCode(model);
    }

    @Override
    public String toString() {
        return "CargoPlane{" +
                "fuelConsumption=" + fuelConsumption +
                ", range=" + range +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", payload=" + payload +
                '}';
    }
}
