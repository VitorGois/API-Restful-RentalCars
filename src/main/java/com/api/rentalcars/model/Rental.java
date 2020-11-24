package com.api.rentalcars.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Rental {
    
    private int num;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateStartlocation;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateEndlocation;
    private float totalValue;

    private Client client;
    private Car car;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }


}
