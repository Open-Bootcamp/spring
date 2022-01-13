package com.example.barbershop.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "directions")
public class Direction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String postalCode;

    private String country;

    public Direction(){}

    public Direction(Long id, String street, String postalCode, String country) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
