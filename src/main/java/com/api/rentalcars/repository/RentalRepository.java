package com.api.rentalcars.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.rentalcars.model.Rental;

import org.springframework.stereotype.Component;

@Component
public class RentalRepository {

    private ArrayList<Rental> rentals = new ArrayList<>();
    
    private static int nextNum = 1;

    public List<Rental> getAllRentals() {
		return rentals;
	}

    public Optional<Rental> getRentalByNum(int num) {
		for(Rental aux : rentals) {
			if(aux.getNum() == num) {
				return Optional.of(aux);
			}
		}

		return Optional.empty();
    }
    
    public Rental save(Rental newRental) {
		newRental.setNum(nextNum++);
		
		rentals.add(newRental);

		return newRental;
	}

}
