package com.epam.jwd.repository.model.airplane;

public class PassengerPlane extends Airplane {

    private int seats;

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

        public PassengerPlane build(){

            PassengerPlane passengerPlane = new PassengerPlane();
            passengerPlane.setSeats(seats);
            passengerPlane.setFuelConsumption(fuelConsumption);
            passengerPlane.setRange(range);
            passengerPlane.setManufacturer(manufacturer);
            passengerPlane.setModel(model);

            return passengerPlane;
        }

    }

}
