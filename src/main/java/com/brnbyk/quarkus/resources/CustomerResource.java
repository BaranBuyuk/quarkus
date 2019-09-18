package com.brnbyk.quarkus.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 14:38
 **/

@Path("/customer")
public class CustomerResource {


    private Set<Customer> customers = new HashSet<>();

    public CustomerResource() {
        customers.addAll(new ArrayList<>(Arrays.asList(new Customer(1L, "Baran"), new Customer(2L, "Hüseyin"))));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getAllCustomer() {
        return Response.ok().entity(customers.stream().sorted((o1, o2) -> o2.equals(o1) ? 0 : -1).collect(Collectors.toList())).build();
    }

    @GET
    @Path("{customerId}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response getCustomer(@PathParam("customerId") Long customerId) {
        Optional<Customer> optionalCustomer = customers.stream().filter(customer -> customer.getId().equals(customerId)).findFirst();
        if (optionalCustomer.isPresent()) {
            return Response.ok().entity(optionalCustomer.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response addCustomer(Customer customer) {
        customers.add(customer);
        return Response.created(URI.create(customer.getId().toString())).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response updateCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customers.stream().filter(c -> customer.getId().equals(c.getId())).findFirst();
        if (optionalCustomer.isPresent()) {
            Customer c = optionalCustomer.get();
            customers.remove(c);
            customers.add(c);
        }
        return Response.accepted().build();
    }

}
