package com.api.rentalcars.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.api.rentalcars.dto.ClientDTO;
import com.api.rentalcars.dto.RentalDTO;
import com.api.rentalcars.model.Car;
import com.api.rentalcars.model.Client;
import com.api.rentalcars.model.Rental;
import com.api.rentalcars.service.CarService;
import com.api.rentalcars.service.ClientService;
import com.api.rentalcars.service.RentalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
  
    @Autowired
    private CarService carService;

    @Autowired
    private RentalService rentalService;

    @GetMapping()
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Client> getClientByCode(@PathVariable int code) {
        Client client = clientService.getClientByCode(code);

        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Void> postClient(@Valid @RequestBody ClientDTO newClient, HttpServletRequest request, UriComponentsBuilder builder) {
        Client client = clientService.save(clientService.fromDTO(newClient));

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + client.getCode()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{code}")
    public ResponseEntity<Client> putClient(@PathVariable int code, @RequestBody ClientDTO changesClient) {
        Client client = clientService.fromDTO(changesClient);
        
        client.setCode(code);
        client = clientService.update(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{code}") 
    public ResponseEntity<Void> deleteClient(@PathVariable int code) {
        Client client = clientService.getClientByCode(code);

        if(client.getCars().isEmpty()) {
            clientService.removeClient(client);
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(405).build();
    }

    @PostMapping("/{codeClient}/cars/{codeCar}")
    public ResponseEntity<Void> postCarClient(@PathVariable int codeClient, @PathVariable int codeCar, @RequestBody RentalDTO newRental, HttpServletRequest request, UriComponentsBuilder builder) {
        Client client = clientService.getClientByCode(codeClient);
        Car car = carService.getCarByCode(codeCar);

        if(rentalService.verifyData(newRental.getDateStartlocation()) && rentalService.verifyData(newRental.getDateEndlocation())){
            Rental rental = rentalService.save(rentalService.fromDTO(newRental));
            rental.setClient(client);
            rental.setCar(car);
            rental.setTotalValue(rentalService.calculateTotalValue(rental));
    
            car.setClient(client);
    
            UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + rental.getNum()).build();
    
            return ResponseEntity.created(uriComponents.toUri()).build();
        }

        return ResponseEntity.badRequest().build();
        
    }

    @GetMapping("/{codeClient}/rentals")
    public List<Rental> getRentalByClient(@PathVariable int codeClient) {
        return rentalService.getRentalByClient(clientService.getClientByCode(codeClient));        
    }

    // @DeleteMapping("/{codeClient}/cars/{codeCar}")
    // public ResponseEntity<Void> deleteCar(@PathVariable int codeClient, @PathVariable int codeCar) {
    //     Client client = clientService.getClientByCode(codeClient);

    //     carService.removeClient(codeCar, client);

    //     return ResponseEntity.noContent().build();
    // }

}
