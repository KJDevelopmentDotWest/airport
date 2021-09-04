package com.epam.jwd.repository.model.airplane;

import java.util.Objects;

public class PassengerPlane extends Airplane {

    private int seats;
    private static final long serialVersionUID = 6529685098267757691L;

    private PassengerPlane(){}

    private void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSeats(){
        return seats;
    }

    public static class Builder {

        private int seats;
        private int fuelConsumption;
        private int range;
        private int id;
        private String manufacturer;
        private String model;


        public Builder withSeats(int seats){
            this.seats = seats;
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

        public PassengerPlane build(){

            PassengerPlane passengerPlane = new PassengerPlane();
            passengerPlane.setSeats(seats);
            passengerPlane.setFuelConsumption(fuelConsumption);
            passengerPlane.setRange(range);
            passengerPlane.setManufacturer(manufacturer);
            passengerPlane.setModel(model);
            passengerPlane.setId(id);

            return passengerPlane;
        }

    }

    @Override
    public boolean equals(Object o) {
        boolean flag;

        if (this == o) {
            return true;
        }

        if (o instanceof PassengerPlane) {
            PassengerPlane plane = (PassengerPlane) o;
            flag = plane.getFuelConsumption() == fuelConsumption
                    && plane.getManufacturer().equals(manufacturer)
                    && plane.getModel().equals(model)
                    && plane.getRange() == range
                    && plane.getSeats() == seats
                    && plane.getId() == id;
        } else {
            flag = false;
        }

        return flag;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(seats) + Objects.hashCode(fuelConsumption) + Objects.hashCode(range) + Objects.hashCode(manufacturer) + Objects.hashCode(model) + Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return "PassengerPlane{" +
                "fuelConsumption=" + fuelConsumption +
                ", range=" + range +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", id='" + id + '\'' +
                ", seats=" + seats +
                '}';
    }
}
