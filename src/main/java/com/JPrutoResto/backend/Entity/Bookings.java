package com.JPrutoResto.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
    private int persons;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customers", foreignKey = @ForeignKey(name = "booking_customer_fk1"))
    @JsonBackReference(value = "customer-bookings")
    @ToString.Exclude
    private Customers customers;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "packages", foreignKey = @ForeignKey(name = "booking_package_fk1"))
    @JsonBackReference(value = "package-bookings")
    @ToString.Exclude
    private Packages packages;



    public Bookings() {
    }

}
