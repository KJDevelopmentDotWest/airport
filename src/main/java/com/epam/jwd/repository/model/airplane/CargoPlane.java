package com.epam.jwd.repository.model.airplane;

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

        public CargoPlane build(){

            CargoPlane cargoPlane = new CargoPlane();
            cargoPlane.setPayload(payload);
            cargoPlane.setFuelConsumption(fuelConsumption);
            cargoPlane.setRange(range);
            cargoPlane.setManufacturer(manufacturer);
            cargoPlane.setModel(model);

            return cargoPlane;
        }

    }
}
