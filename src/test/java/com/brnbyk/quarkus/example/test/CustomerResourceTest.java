package com.brnbyk.quarkus.example.test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 17:04
 **/
@QuarkusTest
public class CustomerResourceTest {


    @Test
    public void testGetAllCustomer() {
        given().when().get("/customer")
                .then().statusCode(200)
                .body(is("[{\"id\":2,\"name\":\"Hüseyin\"},{\"id\":1,\"name\":\"Baran\"}]"));
    }

    @Test
    public void testGetCustomerById() {
        given().pathParam("customerId", 1L)
                .get("/customer/{customerId}")
                .then().statusCode(200)
                .body(is("{\"id\":1,\"name\":\"Baran\"}"));
    }

    @Test
    public void testAddCustomer() {
        given().body("{ \n" +
                "\t\"id\":1,\n" +
                "\t\"name\":\"Baran 2\"\n" +
                "}").contentType(ContentType.JSON)
                .when()
                .post("/customer")
                .then().statusCode(201);
    }


}
