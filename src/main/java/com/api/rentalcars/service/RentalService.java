package com.api.rentalcars.service;

import java.util.List;
import java.util.Optional;

import com.api.rentalcars.dto.RentalDTO;
import com.api.rentalcars.model.Rental;
import com.api.rentalcars.repository.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class RentalService {
    
    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
		return rentalRepository.getAllRentals();
	}

	public Rental getRentalByNum(int num) {
		Optional<Rental> op = rentalRepository.getRentalByNum(num);

		return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not registered: " + num));
	}

	public Rental save(Rental newRental) {
		return rentalRepository.save(newRental);
	}

	public Rental fromDTO(RentalDTO rental) {
		Rental aux = new Rental();
		
        aux.setDateStartlocation(rental.getDateStartlocation());
        aux.setDateEndlocation(rental.getDateEndlocation());

        //aux.setTotalDays(rental.getDateEndlocation() - rental.getDateStartlocation());
    
        aux.setTotalValue(0f);

		return aux;
	}

}
