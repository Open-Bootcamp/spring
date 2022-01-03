package com.example.barbershop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private Integer duration;

    // asociaciones: OneToOne, OneToMany, ManyToOne, ManyToMany

    // cliente
    @ManyToOne
    private Customer customer;

    // servicio

    // constructores

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime date, Integer duration) {
        this.id = id;
        this.date = date;
        this.duration = duration;
    }
    // métodos (getter, setter, demás)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", duration=" + duration +
                '}';
    }
}
