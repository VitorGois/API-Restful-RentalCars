package com.api.rentalcars.controller;

import java.util.List;

import com.api.rentalcars.model.Rental;
import com.api.rentalcars.service.RentalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    
    @Autowired
    private RentalService rentalService;

    @GetMapping()
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{num}")
    public ResponseEntity<Rental> getRentalByNum(@PathVariable int num) {
        Rental rental = rentalService.getRentalByNum(num);

        return ResponseEntity.ok(rental);
    }

}
