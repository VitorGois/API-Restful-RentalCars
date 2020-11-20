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
    public Car save(Car car){
        car.setCode(count++);
        cars.add(car);
        return car;
    }
    

	public void remove(Car cc) {
        cars.remove(cc);
	}

	public Car update(Car car) {
        Car aux = getCarbyCode(car.getCode()).get();
        if (aux!=null){
       aux.setValueperday(car.getValueperday());
        }
        return aux;
	} 
}
