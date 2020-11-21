package com.api.rentalcars.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.api.rentalcars.model.Car;
import com.api.rentalcars.model.Client;
import com.api.rentalcars.repository.ClientRepository;
import com.api.rentalcars.service.CarService;
import com.api.rentalcars.service.ClientService;

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
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;
  
    @Autowired
    private CarService carService;

    @GetMapping()
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientByID(@PathVariable int id) {
        Client aux = clientService.getClientByID(id);

        return ResponseEntity.ok(aux);
    }

    @PostMapping
    public ResponseEntity<Void> postClient(@RequestBody Client newClient, HttpServletRequest request, UriComponentsBuilder builder) {
        Client aux = clientService.save(newClient);

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + aux.getCode()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> putClient(@PathVariable int id, @RequestBody Client changesClient) {
        Client aux = clientService.fromDTO(changesClient);
        
        aux.setCode(id);
        aux = clientService.update(aux);

        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        Client aux = clientService.getClientByID(id);

        if(aux.getCars().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(405).build();
    }

    @PostMapping("/{id}/cars")
    public ResponseEntity<Void> postCarClient(@PathVariable int id, @RequestBody Car car, HttpServletRequest request, UriComponentsBuilder builder) {
        car = carService.save(id, car);

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + car.getCode()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}/cars/{cod}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id, @PathVariable int cod) {
        Client aux = clientService.getClientByID(id);

        carService.removeClient(cod, aux);

        return ResponseEntity.noContent().build();
    }

}
