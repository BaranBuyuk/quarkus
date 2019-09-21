package com.brnbyk.quarkus.example.test.jvm.validate;

import com.brnbyk.quarkus.data.dto.AddressDTO;
import com.brnbyk.quarkus.data.dto.CustomerDTO;
import com.brnbyk.quarkus.mapper.CustomerMapper;
import com.brnbyk.quarkus.persist.Address;
import com.brnbyk.quarkus.persist.Customer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 11:57
 **/

@QuarkusTest
public class CustomerMapperTest {

    @Inject
    CustomerMapper customerMapper;

    @Test
    public void testCustomerDTOtoCustomer() {

        CustomerDTO actualCustomerDTO = new CustomerDTO();
        actualCustomerDTO.setId(1L);
        actualCustomerDTO.setName("Baran");
        actualCustomerDTO.setSurname("Büyük");
        actualCustomerDTO.setEmail("baranbuyuk@gmail.com");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCountry("Turkey");
        addressDTO.setCity("İstanbul");
        addressDTO.setStreet("Altunizade");
        addressDTO.setZipCode(34067L);
        actualCustomerDTO.setAddress(addressDTO);


        Customer expectedCustomer = customerMapper.customerDTOtoCustomer(actualCustomerDTO);

        Assertions.assertNotNull(expectedCustomer);
        Assertions.assertEquals(actualCustomerDTO.getName(), expectedCustomer.getName());
        Assertions.assertEquals(actualCustomerDTO.getSurname(), expectedCustomer.getSurname());
        Assertions.assertEquals(actualCustomerDTO.getEmail(), expectedCustomer.getEmail());
        Assertions.assertNotNull(expectedCustomer.getAddress());
        Assertions.assertEquals(actualCustomerDTO.getAddress().getCity(), expectedCustomer.getAddress().getCity());
        Assertions.assertEquals(actualCustomerDTO.getAddress().getCountry(), expectedCustomer.getAddress().getCountry());
        Assertions.assertEquals(actualCustomerDTO.getAddress().getZipCode(), expectedCustomer.getAddress().getZipCode());
        Assertions.assertEquals(actualCustomerDTO.getAddress().getStreet(), expectedCustomer.getAddress().getStreet());
    }

    @Test
    public void testCustomerToCustomerDTO() {
        Customer actualCustomer = new Customer();
        actualCustomer.setID(1L);
        actualCustomer.setName("Baran");
        actualCustomer.setSurname("Büyük");
        actualCustomer.setEmail("baranbuyuk@gmail.com");
        Address address = new Address();
        address.setCountry("Turkey");
        address.setCity("İstanbul");
        address.setStreet("Altunizade");
        address.setZipCode(34067L);
        actualCustomer.setAddress(address);


        CustomerDTO expectedCustomerDTO = customerMapper.customerToCustomerDTO(actualCustomer);

        Assertions.assertNotNull(expectedCustomerDTO);
        Assertions.assertEquals(actualCustomer.getName(), expectedCustomerDTO.getName());
        Assertions.assertEquals(actualCustomer.getSurname(), expectedCustomerDTO.getSurname());
        Assertions.assertEquals(actualCustomer.getEmail(), expectedCustomerDTO.getEmail());
        Assertions.assertEquals(actualCustomer.getAddress().getCity(), expectedCustomerDTO.getAddress().getCity());
        Assertions.assertEquals(actualCustomer.getAddress().getCountry(), expectedCustomerDTO.getAddress().getCountry());
        Assertions.assertEquals(actualCustomer.getAddress().getZipCode(), expectedCustomerDTO.getAddress().getZipCode());
        Assertions.assertEquals(actualCustomer.getAddress().getStreet(), expectedCustomerDTO.getAddress().getStreet());

    }
}
