package com.api.rentalcars.repository;

import java.util.ArrayList;
import java.util.Optional;
import com.api.rentalcars.model.Car;

import org.springframework.stereotype.Component;

@Component
public class CarRepository {

    private ArrayList <Car> cars = new ArrayList<>();
    
    private int count=1;

    public ArrayList<Car> getAllCars() {
		return cars;
	}

	public Optional<Car> getCarbyCode(int code) {
		for (Car aux : cars){
            if (aux.getCode()==code){
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Car save(Car newCar){
        newCar.setCode(count++);
        newCar.setDateEndlocation(null);
        newCar.setDateStartlocation(null);

        cars.add(newCar);

        return newCar;
    }

	public void remove(Car car) {
        cars.remove(car);
	}

	public Car update(Car car) {
        Car aux = getCarbyCode(car.getCode()).get();

        if (aux!=null){
            aux.setValuePerDay(car.getValuePerDay());
        }

        return aux;
	} 
    
}
