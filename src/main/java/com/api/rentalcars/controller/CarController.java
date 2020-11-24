package com.api.rentalcars.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import com.api.rentalcars.dto.CarDTO;
import com.api.rentalcars.model.Car;
import com.api.rentalcars.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Car> getCarbyCode(@PathVariable int code) {
        Car cc = carService.getCarByCode(code);
        
        return ResponseEntity.ok(cc);
    }

    @PostMapping()
    public ResponseEntity<Void> postCar(@Valid @RequestBody CarDTO newCar, HttpServletRequest request, UriComponentsBuilder builder) {
        Car car = carService.save(carService.fromDTO(newCar));

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + car.getCode()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }
  
    @PutMapping("/{code}")
    public ResponseEntity<Car> update(@PathVariable int code, @RequestBody CarDTO changesCar) {
        Car car = carService.fromDTO(changesCar);

        car.setCode(code);
        car = carService.update(car);

        return ResponseEntity.ok(car);
    }        

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCar(@PathVariable int code) {
        Car car = carService.getCarByCode(code);
        
        if(car.getClient() == null) {
            carService.removeCar(car);

            return ResponseEntity.badRequest().build();            
        }

        return ResponseEntity.status(405).build();
    }

}
