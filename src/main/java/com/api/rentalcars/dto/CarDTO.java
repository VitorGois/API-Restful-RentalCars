package com.api.rentalcars.dto;

public class CarDTO {
        
    private String licensePlate;
    private String dateStartlocation;
    private String dateEndlocation;
    private String model;
    private String producer;
    private int valuePerDay;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDateStartlocation() {
        return dateStartlocation;
    }

    public void setDateStartlocation(String dateStartlocation) {
        this.dateStartlocation = dateStartlocation;
    }

    public String getDateEndlocation() {
        return dateEndlocation;
    }

    public void setDateEndlocation(String dateEndlocation) {
        this.dateEndlocation = dateEndlocation;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getValuePerDay() {
        return valuePerDay;
    }

    public void setValuePerDay(int valuePerDay) {
        this.valuePerDay = valuePerDay;
    }
    
}
