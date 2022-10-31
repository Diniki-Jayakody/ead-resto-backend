package com.JPrutoResto.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class addPackageBody {

    private packageUrl packageUrl;
    private Packages packages;


    public addPackageBody() {
    }
}
