package com.brnbyk.quarkus.example.test.jvm.validate;

import com.brnbyk.quarkus.data.dto.AddressDTO;
import com.brnbyk.quarkus.data.dto.CustomerDTO;
import io.quarkus.test.junit.DisabledOnSubstrate;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 16:40
 **/
@QuarkusTest
public class CustomerValidateTest {

    @Inject
    Validator validator;

    @Test
    public void shouldSuccessWhenAllFieldsOfCustomerDTOAreCorrect() {
        CustomerDTO customerDTO = getCustomerDTO();

        Set<ConstraintViolation<CustomerDTO>> validatedCustomerDTO = validator.validate(customerDTO);
        Assertions.assertTrue(validatedCustomerDTO.isEmpty());

    }

    @Test
    public void shouldErrorWhenCustomerNameIsNullOrEmpty() {
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setName(null);

        Set<ConstraintViolation<CustomerDTO>> validatedCustomerDTO = validator.validate(customerDTO);
        Assertions.assertFalse(validatedCustomerDTO.isEmpty());

    }

    @Test
    public void shouldErrorWhenCustomerSurnameIsNullOrEmpty() {
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setSurname(null);

        Set<ConstraintViolation<CustomerDTO>> validatedCustomerDTO = validator.validate(customerDTO);
        Assertions.assertFalse(validatedCustomerDTO.isEmpty());

    }

    @Test
    public void shouldErrorWhenCustomerEmailIsNullOrEmpty() {
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setEmail(null);

        Set<ConstraintViolation<CustomerDTO>> validatedCustomerDTO = validator.validate(customerDTO);
        Assertions.assertFalse(validatedCustomerDTO.isEmpty());
    }

    @Test
    public void shouldErrorWhenCustomerEmailDoesntMatchToEmailPattern() {
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setEmail("baranbuyu-**gmail.com");

        Set<ConstraintViolation<CustomerDTO>> validatedCustomerDTO = validator.validate(customerDTO);
        Assertions.assertFalse(validatedCustomerDTO.isEmpty());
    }

    @Test
    public void shouldErrorWhenCustomerAddressIsNull() {
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setAddress(null);

        Set<ConstraintViolation<CustomerDTO>> validatedCustomerDTO = validator.validate(customerDTO);
        Assertions.assertFalse(validatedCustomerDTO.isEmpty());

    }

    private CustomerDTO getCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Name");
        customerDTO.setSurname("Surname");
        customerDTO.setEmail("email@email.com");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("City");
        addressDTO.setCountry("Country");
        addressDTO.setStreet("Street");
        addressDTO.setZipCode(34000L);
        customerDTO.setAddress(addressDTO);
        return customerDTO;
    }


}
