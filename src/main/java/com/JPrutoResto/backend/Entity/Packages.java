package com.JPrutoResto.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String description;
    private String url;
    private boolean availability = true;

    @OneToMany(mappedBy = "packages", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("package-bookings")
    @ToString.Exclude
    private List<Bookings> Bookings;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "packageUrl", foreignKey = @ForeignKey(name = "packageUrl_package_fk1"))
    @JsonBackReference(value = "package-packageUrl")
    @ToString.Exclude
    private packageUrl packageUrl;

    public Packages() {
    }
}
