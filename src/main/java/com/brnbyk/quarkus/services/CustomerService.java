package com.brnbyk.quarkus.services;

import com.brnbyk.quarkus.data.base.BaseResponse;
import com.brnbyk.quarkus.data.dto.CustomerDTO;
import com.brnbyk.quarkus.mapper.CustomerMapper;
import com.brnbyk.quarkus.persist.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 11:05
 **/

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerMapper customerMapper;

    @Inject
    EntityManager entityManager;

    public Response getAllCustomers() {
        BaseResponse<List<CustomerDTO>> baseResponse = new BaseResponse<>();
        List<Customer> customerList = entityManager.createNamedQuery("Customer.FindAll", Customer.class).getResultList();
        if (!customerList.isEmpty()) {
            baseResponse.setData(customerList.stream().map(customer -> customerMapper.customerToCustomerDTO(customer)).collect(Collectors.toList()));
            return Response.ok(baseResponse).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Transactional(rollbackOn = Exception.class)
    public Response create(CustomerDTO customerDTO) {
        BaseResponse<CustomerDTO> baseResponse = new BaseResponse<>();
        Customer customer = customerMapper.customerDTOtoCustomer(customerDTO);
        entityManager.persist(customer);
        baseResponse.setData(customerMapper.customerToCustomerDTO(customer));
        return Response.accepted(baseResponse).build();
    }

    public Response getById(Long id) {
        BaseResponse<CustomerDTO> baseResponse = new BaseResponse<>();
        Customer customer = entityManager.find(Customer.class, id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        baseResponse.setData(customerMapper.customerToCustomerDTO(customer));
        return Response.ok(baseResponse).build();
    }

    @Transactional(rollbackOn = Exception.class)
    public Response update(CustomerDTO customerDTO) {
        BaseResponse<CustomerDTO> baseResponse = new BaseResponse<>();
        Customer customer = customerMapper.customerDTOtoCustomer(customerDTO);
        entityManager.merge(customer);
        baseResponse.setData(customerMapper.customerToCustomerDTO(customer));
        return Response.ok(baseResponse).build();
    }

    @Transactional(rollbackOn = Exception.class)
    public Response delete(Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entityManager.remove(customer);
        return Response.ok().build();
    }
}
