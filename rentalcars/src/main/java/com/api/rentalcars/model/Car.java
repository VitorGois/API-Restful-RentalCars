package com.api.rentalcars.model;

public class Car {
    
    private String licensePlate;
    private int code;
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

    public int getValueperday() {
        return valuePerDay;
    }

    public void setValueperday(int valueperday) {
        this.valuePerDay =  valueperday;
    }

}
