package com.JPrutoResto.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GetPackageUrls {


    private String name;
    private Long id;
    private String url;


    public GetPackageUrls() {
    }
}
