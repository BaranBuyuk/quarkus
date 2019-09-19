package com.brnbyk.quarkus.persist;

import com.brnbyk.quarkus.persist.base.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static com.brnbyk.quarkus.util.AppUtil.EMAIL_PATTERN;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 11:35
 **/
@Entity
@Table(name = "customers")
@AttributeOverride(name = "ID", column = @Column(name = "customer_id"))
@NamedQueries(
        {
                @NamedQuery(name = "Customer.FindAll", query = "SELECT c FROM Customer c"),
                @NamedQuery(name = "Customer.FindByID", query = "SELECT c FROM Customer c where c.ID =:customerId"),
                @NamedQuery(name = "Customer.FindByEmail", query = "SELECT c FROM Customer c where c.email = :email")
        })

public class Customer extends BaseEntity {

    @NotEmpty
    @Length(min = 1, max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Length(min = 1, max = 50)
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotEmpty
    @Length(min = 1, max = 100)
    @Pattern(regexp = EMAIL_PATTERN)
    @Column(name = "email", nullable = false)
    private String email;

    @Embedded
    private Address address;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (getName() != null ? !getName().equals(customer.getName()) : customer.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(customer.getSurname()) : customer.getSurname() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(customer.getEmail()) : customer.getEmail() != null) return false;
        return getAddress() != null ? getAddress().equals(customer.getAddress()) : customer.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
