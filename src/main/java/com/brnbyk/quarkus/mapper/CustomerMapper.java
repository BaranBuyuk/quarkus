package com.brnbyk.quarkus.mapper;

import com.brnbyk.quarkus.data.dto.CustomerDTO;
import com.brnbyk.quarkus.persist.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 11:48
 **/
@Mapper(config = MappingConfig.class)
public interface CustomerMapper {

    @Mapping(source = "id", target = "ID")
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);

    @InheritInverseConfiguration
    CustomerDTO customerToCustomerDTO(Customer customer);

}
