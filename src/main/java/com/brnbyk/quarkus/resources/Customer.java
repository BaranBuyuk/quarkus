package com.brnbyk.quarkus.resources;

import java.io.Serializable;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 15:00
 **/
public class Customer implements Serializable {

    private static final long serialVersionUID = 4225000926656598056L;
    private Long id;
    private String name;

    public Customer() {
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
