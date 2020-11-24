package com.api.rentalcars.model;

public class Car {
    
    private int code;
    private String licensePlate;
    private String model;
    private String producer;
    private float valuePerDay;
    
    private Client client;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
