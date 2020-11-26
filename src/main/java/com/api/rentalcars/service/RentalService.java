package com.api.rentalcars.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.rentalcars.dto.RentalDTO;
import com.api.rentalcars.model.Car;
import com.api.rentalcars.model.Client;
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

		return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rental not registered: " + num));
	}

	public Rental save(Rental newRental) {
		return rentalRepository.save(newRental);
	}

	public Rental fromDTO(RentalDTO rental) {
		Rental aux = new Rental();

		aux.setDateStartlocation(rental.getDateStartlocation());
		aux.setDateEndlocation(rental.getDateEndlocation());

		// aux.setTotalDays(rental.getDateEndlocation() -
		// rental.getDateStartlocation());

		aux.setTotalValue(0f);

		return aux;
	}

	public List<Rental> getRentalByClient(Client client) {
		ArrayList<Rental> rentals = new ArrayList<>();

		for (Rental aux : rentalRepository.getAllRentals()) {
			if (aux.getClient().equals(client)) {
				rentals.add(aux);
			}
		}

		return rentals;
	}

	public List<Rental> getRentalByCar(Car car) {
		ArrayList<Rental> rentals = new ArrayList<>();

		for (Rental aux : rentalRepository.getAllRentals()) {
			if (aux.getCar().equals(car)) {
				rentals.add(aux);
			}
		}

		return rentals;
	}

	public Boolean verifyData(LocalDate date) {
		DayOfWeek d = date.getDayOfWeek();

		if(d == DayOfWeek.SUNDAY) {
			return false;
		} else {
			return true;
		}
	}

	public Boolean isAvailable(RentalDTO rentalDTO, Car car) {
		for(Rental aux : getAllRentals()) {
			if(aux.getCar().equals(car)) {
				if(aux.getDateEndlocation().isBefore(rentalDTO.getDateStartlocation())) {
					return true;
				} else if(rentalDTO.getDateStartlocation().isBefore(aux.getDateStartlocation()) && rentalDTO.getDateEndlocation().isBefore(aux.getDateStartlocation())) {
					return true;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public int calculateIntervalPeriod(LocalDate start, LocalDate end) {
		Period intervalPeriod = Period.between(start, end);

		return intervalPeriod.getDays();
	}

	public float calculateTotalValue(Rental rental) {
		int days = calculateIntervalPeriod(rental.getDateStartlocation(), rental.getDateEndlocation());
		
		float total = (rental.getCar()).getValuePerDay() * days;

		return total;
	}

}
