package com.api.rentalcars.service;

import com.api.rentalcars.dto.CarDTO;
import com.api.rentalcars.model.Car;
import com.api.rentalcars.model.Client;
import com.api.rentalcars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarService {
    @Autowired
	private CarRepository cRepository;
	@Autowired
	private ClientService cService;

    public Car fromDTO(CarDTO dto){
        Car car = new Car();
        car.setValueperday(dto.getValuePerDay());
        return car;
    }

    public Car getCarbyCode(int code) {
        Optional<Car> op = cRepository.getCarbyCode(code);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not registred. " + code));
    }

    public List<Car> getAllCars() {
        return cRepository.getAllCars();
    }

    public Car save(Car car, int codeClient) {
        Client client = cService.getClientbyCode(codeClient);
        car.setClient(client);
        client.addcar(car);
        return cRepository.save(car);
    }

    public void removebyCode(int code, Client client) {
        Car car = getCarbyCode(code);
        client.removeCar(car);
        cRepository.remove(client);
    }

    public Car update(Car cDTO) {
        getCarbyCode(cDTO.getCode());
        return cRepository.update(cDTO);
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



}
