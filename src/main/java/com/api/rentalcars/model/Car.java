package com.api.rentalcars.model;

public class Car {
    
    private String licensePlate;
    private int code;
    private String dateStartlocation;
    private String dateEndlocation;
    private String model;
    private String producer;
    private int valuePerDay;
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

    public String getDataStartlocation() {
        return dateStartlocation;
    }

    public void setDataStartlocation(String dataStartlocation) {
        this.dateStartlocation = dataStartlocation;
    }

    public String getDataEndlocation() {
        return dateEndlocation;
    }

    public void setDataEndlocation(String dataEndlocation) {
        this.dateEndlocation = dataEndlocation;
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

    public int getValuePerDay() {
        return valuePerDay;
    }

    public void setValuePerDay(int valuePerDay) {
        this.valuePerDay = valuePerDay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
