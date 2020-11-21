package com.api.rentalcars.dto;

import java.time.LocalDateTime;

public class CarDTO {
        
    private String licensePlate;
    private LocalDateTime dateStartlocation;
    private LocalDateTime dateEndlocation;
    private String model;
    private String producer;
    private float valuePerDay;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getDateStartlocation() {
        return dateStartlocation;
    }

    public void setDateStartlocation(LocalDateTime dateStartlocation) {
        this.dateStartlocation = dateStartlocation;
    }

    public LocalDateTime getDateEndlocation() {
        return dateEndlocation;
    }

    public void setDateEndlocation(LocalDateTime dateEndlocation) {
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

    public float getValuePerDay() {
        return valuePerDay;
    }

    public void setValuePerDay(float valuePerDay) {
        this.valuePerDay = valuePerDay;
    }
    
}
