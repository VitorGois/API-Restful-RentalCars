# RentalCars API
Project to develop a RestFul Web API that allows you to manage vehicle reservations.

## About
The project was developed during the OOP discipline in the 4th semester of graduation. The RestFul API provides the user with the possibility to rent a car.
- The application allows:
  - Manage Vehicles
  - Manage Clients and list a Client's reservations
  - Book a vehicle for a customer. The reservation will have:
    - Has a number
    - Customer must exist.
    - Vehicle must exist.
    - Start Date (Must be greater than the system date). It cannot start on Sunday.
    - End Date (Must be greater than the Start date). There is no delivery on Sunday.
    - The total of the reservation must be calculated.
    - A vehicle can be booked several times, but only at different times / dates.

## Requirements
- Postman
  > Used to make requests to the API.

### The Project
- Models:
  - Car: has the attributes common to it, such as license plate and model, and also the daily amount to be paid for the rent. Every car can have a momentary customer associated with it.
    
    ```java
      private int code;
      private String licensePlate;
      private String model;
      private String producer;
      private float valuePerDay;
      private Client client;
    ```
  - Client: has all the data common to a person, such as name and cpf. Every customer can have several cars associated with him, that is, he can rent more than one car.
    ```java
      private int code;
      private String name;
      private String cpf;
      private String dateOfBirth;
      private String email;
      private String address;
      private ArrayList<Car> cars = new ArrayList<>();
    ```
  - Rental: has a start and end date. The total amount to be paid for that particular lease is already associated, in addition to owning the client and the car of that lease.
    ```java
      private int num;
      private LocalDate dateStartlocation;
      private LocalDate dateEndlocation;
      private float totalValue;
      private Client client;
      private Car car;
    ```
 - How can I **post** a **Client**?
    ```
      https://localhost:8080/clients
    ```
    - How does it work?
    ```java
      @RequestMapping("/clients")
    ```
    > With the help of Postman, the values ​​of the Client to be registered are sent by RequestBody and saved by the save method.
    ```java
        public ResponseEntity<Void> postClient(@Valid @RequestBody ClientDTO newClient, HttpServletRequest request, UriComponentsBuilder builder) {
        Client client = clientService.save(clientService.fromDTO(newClient));

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + client.getCode()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }
    ```
  - How can I **post** a **Car**?
    ```
      https://localhost:8080/cars
    ```
    - How does it work?
    ```java
      @RequestMapping("/cars)
    ```
    > With the help of Postman, the values ​​of the Car be registered are sent by RequestBody and saved by the save method.
    ```java
        public ResponseEntity<Void> postCar(@Valid @RequestBody CarDTO newCar, HttpServletRequest request, UriComponentsBuilder builder) {
        Car car = carService.save(carService.fromDTO(newCar));

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + car.getCode()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }
    ```
- How can I **rent** a **Car**?
    ```
      https://localhost:8080/clients/{idClient}/cars/{idCar}
    ```
    - How does it work?
    ```java
      @RequestMapping("/clients)
    ```
    > With the assistance of Postman and the start and end dates of the lease passed through RequestBody, a validation is made to see if one of the dates falls on Sunday (following our restriction) or if the desired car is already being rented by another customer in that informed period.
    ```java
        @PostMapping("/{codeClient}/cars/{codeCar}")
        public ResponseEntity<Void> postCarClient(@PathVariable int codeClient, @PathVariable int codeCar, @RequestBody RentalDTO newRental, HttpServletRequest request, UriComponentsBuilder builder) {
        Client client = clientService.getClientByCode(codeClient);
        Car car = carService.getCarByCode(codeCar);

        if(rentalService.verifyData(newRental.getDateStartlocation()) && rentalService.verifyData(newRental.getDateEndlocation())){
            if(rentalService.isAvailable(newRental, car)) {                
                Rental rental = rentalService.save(rentalService.fromDTO(newRental));
                rental.setClient(client);
                rental.setCar(car);
                rental.setTotalValue(rentalService.calculateTotalValue(rental));
        
                car.setClient(client);
        
                UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + rental.getNum()).build();
        
                return ResponseEntity.created(uriComponents.toUri()).build();
            }

        }

        return ResponseEntity.badRequest().build();
        
    }
    ```
