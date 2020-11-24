package com.api.rentalcars.service;

import com.api.rentalcars.dto.CarDTO;
import com.api.rentalcars.model.Car;
import com.api.rentalcars.model.Client;
import com.api.rentalcars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
   
<<<<<<< HEAD
    @Autowired
	private CarRepository carRepository;

    public Car fromDTO(CarDTO car){
        Car aux = new Car();

        aux.setLicensePlate(car.getLicensePlate());
        aux.setDateStartlocation(car.getDateStartlocation());
        aux.setDateEndlocation(car.getDateEndlocation());
        aux.setModel(car.getModel());
        aux.setProducer(car.getProducer());
        aux.setValuePerDay(car.getValuePerDay());

        return aux;
=======
  @Autowired
	private CarRepository cRepository;
  
	@Autowired
	private ClientService cService;

  public Car fromDTO(CarDTO dto){
        Car car = new Car();
        car.setValuePerDay(dto.getValuePerDay());
        return car;
>>>>>>> cdc71c1fa8fc4b38d06d2bfbfc7e1436c06b2bcd
    }

    public Car getCarByCode(int code) {
        Optional<Car> op = carRepository.getCarbyCode(code);
        
        return op.orElseThrow(  () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not registred, code: " + code));
    }

    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public Car save(Car newCar) {
        return carRepository.save(newCar);
    }

    public void removebyCode(int code, Client client) {
        Car car = getCarByCode(code);
        client.removeCar(car);
        carRepository.remove(car);
    }

    public Car update(Car cDTO) {
        getCarByCode(cDTO.getCode());

        return carRepository.update(cDTO);
    }

    public List<CarDTO> tolistDTO(ArrayList<Car> cars) {
        ArrayList<CarDTO> listDTO = new ArrayList<>();
        for (Car car : cars) {
            listDTO.add(toDTO(car));
        }
        return listDTO;
    }

    private CarDTO toDTO(Car car) {
        CarDTO cDTO = new CarDTO();
        // cDTO.setNome(curso.getNome());
        // cDTO.setEspecialidade(curso.getEspecialidade());
        // cDTO.setPeriodo(curso.getPeriodo());
        // cDTO.setQtd_dias(curso.getQtd_dias());
        cDTO.setValuePerDay(cDTO.getValuePerDay());

		return cDTO;
	}

	public void removeCar(Car car) {
        carRepository.remove(getCarByCode(car.getCode()));
    }
    
}
