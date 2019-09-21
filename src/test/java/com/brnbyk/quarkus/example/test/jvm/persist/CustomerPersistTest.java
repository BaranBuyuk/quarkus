package com.brnbyk.quarkus.example.test.jvm.persist;

import com.brnbyk.quarkus.example.test.jvm.InitializePostgreSQLTestContainer;
import com.brnbyk.quarkus.persist.Address;
import com.brnbyk.quarkus.persist.Customer;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 15:47
 **/
@QuarkusTestResource(InitializePostgreSQLTestContainer.class)
@QuarkusTest
public class CustomerPersistTest {

    @Inject
    EntityManager entityManager;


    @Test
    @Transactional
    @Order(1)
    public void saveCustomerTest() {
        Customer customer = getMockCustomer();
        entityManager.persist(customer);
        Assertions.assertNotNull(customer.getID());
    }

    @Test
    @Order(2)
    @Transactional
    public void findCustomerByIdTest() {
        Customer savedCustomer = getMockCustomer();
        savedCustomer.setEmail("baran@gmail.com");
        entityManager.persist(savedCustomer);

        Customer customer = entityManager.createNamedQuery("Customer.FindByID", Customer.class)
                .setParameter("customerId", 1L)
                .getSingleResult();

        Assertions.assertNotNull(customer);
        Assertions.assertEquals(customer.getID(), 1L);
    }

    @Test
    @Transactional
    @Order(4)
    public void updateCustomerTest() {
        Customer customerOnDb = entityManager.createNamedQuery("Customer.FindByID", Customer.class)
                .setParameter("customerId", 1L)
                .getSingleResult();

        customerOnDb.setName("Updated-Baran");
        entityManager.merge(customerOnDb);

        Customer expectedCustomer = entityManager.createNamedQuery("Customer.FindByID", Customer.class)
                .setParameter("customerId", 1L)
                .getSingleResult();

        Assertions.assertNotNull(expectedCustomer);
        Assertions.assertEquals(expectedCustomer.getName(), "Updated-Baran");
    }


    private Customer getMockCustomer() {
        Customer customer = new Customer();
        customer.setName("Baran");
        customer.setSurname("Büyük");
        customer.setEmail("baranbuyuk-test@gmail.com");
        Address address = new Address();
        address.setZipCode(34567L);
        address.setStreet("Ferah");
        address.setCity("İstanbul");
        address.setCountry("Turkey");
        customer.setAddress(address);
        return customer;
    }
}
