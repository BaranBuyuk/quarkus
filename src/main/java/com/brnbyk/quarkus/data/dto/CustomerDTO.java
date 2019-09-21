package com.brnbyk.quarkus.data.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.brnbyk.quarkus.util.AppUtil.EMAIL_PATTERN;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 11:52
 **/
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = -5461130337363970604L;

    private Long id;

    @NotEmpty(message = "validation.customer.name.nullOrEmpty")
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    @Email(regexp = EMAIL_PATTERN)
    private String email;

    @Valid
    @NotNull
    private AddressDTO address;


    @JsonbProperty(nillable = true)
    private LocalDateTime createdAt;

    @JsonbProperty(nillable = true)
    private LocalDateTime updatedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
