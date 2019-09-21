package com.brnbyk.quarkus.example.test.jvm.resources;

import com.brnbyk.quarkus.data.base.BaseResponse;
import com.brnbyk.quarkus.data.dto.CustomerDTO;
import com.brnbyk.quarkus.persist.Address;
import com.brnbyk.quarkus.persist.Customer;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 17:04
 **/
@QuarkusTest
public class CustomerResourceTest {

    private static Jsonb jsonb;

    @BeforeAll
    public static void prepare() {
        jsonb = JsonbBuilder.create();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void getAllCustomersResourceTest() {

        //check status
        when().get("/customer").then().statusCode(200);
        //get data for validation
        BaseResponse response = jsonb.fromJson(when().get("/customer")
                .thenReturn()
                .asInputStream(), BaseResponse.class);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());

        List<CustomerDTO> listOfData = (List<CustomerDTO>) response.getData();
        Assertions.assertFalse(listOfData.isEmpty());

    }

    @Test
    public void createCustomerResourceTest() {

        BaseResponse baseResponse = jsonb.fromJson(given().contentType(ContentType.JSON)
                .body(jsonb.toJson(getMockCustomer()))
                .when()
                .post("/customer")
                .then().statusCode(202)
                .extract()
                .response()
                .asInputStream(), BaseResponse.class);

        Assertions.assertNotNull(baseResponse.getData());
    }

    @Test
    public void getCustomerByIdResourceTest() {
        BaseResponse baseResponse = jsonb.fromJson(given()
                .param("customerId", 1)
                .get("/customer")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .asInputStream(), BaseResponse.class);
        Assertions.assertNotNull(baseResponse.getData());
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
