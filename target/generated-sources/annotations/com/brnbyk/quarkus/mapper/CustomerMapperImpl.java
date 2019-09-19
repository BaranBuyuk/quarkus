package com.brnbyk.quarkus.mapper;

import com.brnbyk.quarkus.data.dto.AddressDTO;
import com.brnbyk.quarkus.data.dto.CustomerDTO;
import com.brnbyk.quarkus.persist.Address;
import com.brnbyk.quarkus.persist.Customer;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-19T17:00:32+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@ApplicationScoped
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDTOtoCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setID( customerDTO.getId() );
        customer.setName( customerDTO.getName() );
        customer.setSurname( customerDTO.getSurname() );
        customer.setEmail( customerDTO.getEmail() );
        customer.setAddress( addressDTOToAddress( customerDTO.getAddress() ) );

        return customer;
    }

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getID() );
        customerDTO.setName( customer.getName() );
        customerDTO.setSurname( customer.getSurname() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setAddress( addressToAddressDTO( customer.getAddress() ) );

        return customerDTO;
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setCountry( addressDTO.getCountry() );
        address.setCity( addressDTO.getCity() );
        address.setStreet( addressDTO.getStreet() );
        address.setZipCode( addressDTO.getZipCode() );

        return address;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCountry( address.getCountry() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setZipCode( address.getZipCode() );

        return addressDTO;
    }
}
