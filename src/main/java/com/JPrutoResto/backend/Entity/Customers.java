package com.JPrutoResto.backend.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer contact1;
    private Integer contact2;
    private String nic;
    private String email;


    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("customer-bookings")
    @ToString.Exclude
    private List<Bookings> Bookings;
    public Customers() {
    }
}
