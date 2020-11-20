package com.api.rentalcars.controller;

import java.util.List;

import com.api.rentalcars.dto.CarDTO;
import com.api.rentalcars.model.Car;
import com.api.rentalcars.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService service;
    @GetMapping
    public List<Car> showallcars(){
        return service.getAllCars();
    }
    @GetMapping("/{code}")
    public ResponseEntity<Car> getCarbyCode (@PathVariable int code){
        Car cc = service.getCarbyCode(code);
            return ResponseEntity.ok(cc);
    }
    
  
    @PutMapping("/{code}")
    public ResponseEntity<Car> update(@PathVariable int code, @RequestBody CarDTO carDTO) {
            Car car = service.getCarbyCode(code);
            Car cDTO = service.fromDTO(carDTO);
            cDTO.setCode(code);
            cDTO.setDataStartlocation(car.getDataStartlocation());
            cDTO.setDataEndlocation(car.getDataEndlocation());
            cDTO.setModel(car.getModel());
            cDTO.setProducer(car.getProducer());
            cDTO = service.update(cDTO);
            return ResponseEntity.ok(cDTO);
    }        
}
