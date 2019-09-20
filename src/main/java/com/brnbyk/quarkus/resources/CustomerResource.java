package com.brnbyk.quarkus.resources;

import com.brnbyk.quarkus.data.dto.CustomerDTO;
import com.brnbyk.quarkus.services.CustomerService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Username = baranbuyuk
 * Date = 18.09.2019 14:38
 **/

@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerService customerService;


    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GET
    @Path(value = "{customerId}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getByID(@PathParam("customerId") @Valid @NotNull @Min(value = 1) Long customerId) {
        return customerService.getById(customerId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response create(@Valid CustomerDTO customerDTO) {
        return customerService.create(customerDTO);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response update(@Valid CustomerDTO customerDTO) {
        return customerService.update(customerDTO);
    }


    @DELETE
    @Path(value = "{customerId}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response delete(@PathParam("customerId") @Valid @NotNull @Min(value = 1) Long customerId) {
        return customerService.delete(customerId);
    }


}
