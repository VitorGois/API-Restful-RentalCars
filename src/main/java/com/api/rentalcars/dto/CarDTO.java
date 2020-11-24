package com.api.rentalcars.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CarDTO {

    @NotBlank(message ="The license Plate is required" )
    @Length (min = 7, max =7, message = "Your Plate must be 7 characters only format ABC1111")
    private String licensePlate;
  
    private LocalDate dateStartlocation;
    private LocalDate dateEndlocation;
  
    @NotBlank(message ="The Car's model is required" )
    private String model;
  
    @NotBlank(message ="The Car's producer is required" )
    private String producer;

    //@NotBlank(message ="The Car's value per day is required" )
    private float valuePerDay;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getDateStartlocation() {
        return dateStartlocation;
    }

    public void setDateStartlocation(LocalDate dateStartlocation) {
        this.dateStartlocation = dateStartlocation;
    }

    public LocalDate getDateEndlocation() {
        return dateEndlocation;
    }

    public void setDateEndlocation(LocalDate dateEndlocation) {
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
