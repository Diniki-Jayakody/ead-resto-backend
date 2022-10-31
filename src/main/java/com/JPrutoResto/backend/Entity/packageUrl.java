package com.JPrutoResto.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
@Setter
public class packageUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status = "Lunch";
    private String url;
    private int makeTime;

    @OneToMany(mappedBy = "packageUrl", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("package-packageUrl")
    @ToString.Exclude
    private List<Packages> packages;

    public packageUrl() {
    }

}
