package com.api.rentalcars.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class RentalDTO {
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateStartlocation;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateEndlocation;

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

}
