package com.api.rentalcars.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class ClientDTO {
    
    @NotBlank(message = "Name is required")
    @Length(min = 3, max = 50, message = "Name must contain between 3 and 50 characters")
    private String name;

    @NotBlank(message = "CPF is required")
    @CPF(message = "CPF is invalid")
    private String cpf;

    @NotBlank(message = "Date of Birth is required")
    private String dateOfBirth;

    @NotBlank(message = "E-mail is required")
    @Email
    private String email;

    @NotBlank(message = "Adress is required")
    @Length(min = 10, max = 50, message = "Name must contain between 10 and 50 characters")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
