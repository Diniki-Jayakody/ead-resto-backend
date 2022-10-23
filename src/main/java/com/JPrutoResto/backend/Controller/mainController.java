package com.JPrutoResto.backend.Controller;

import com.JPrutoResto.backend.Entity.Packages;
import com.JPrutoResto.backend.Service.commonMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/jPruto")
public class mainController {

    @Autowired
    private commonMethodService commonMethodService;

    @PostMapping("/addPackage")
    private String addPackage(@RequestBody Packages packages){
        return commonMethodService.addPackage(packages);

    }

    @GetMapping("/getPackages")
    private List<Packages> getPackages(){
        return commonMethodService.getPackages();
    }

    @GetMapping("/test")
    private String getPackagess() {
        return "Hello";
    }
}
