package com.JPrutoResto.backend.Controller;

import com.JPrutoResto.backend.Entity.Bookings;
import com.JPrutoResto.backend.Entity.Customers;
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


    @PostMapping("/addCustomers")
    private String addCustomers(@RequestBody Customers customers){
        return commonMethodService.addCustomer(customers);
    }
    @GetMapping("/getCustomer")
    private List<Customers> getCustomers(){
        return commonMethodService.getCustomers();
    }


    @PostMapping("/addBooking")
    private String addBooking(@RequestBody Bookings bookings){
        return commonMethodService.addBooking(bookings);
    }

    @GetMapping("/getBooking")
    private List<Bookings> getBooking(){
        return commonMethodService.getBooking();
    }





    @GetMapping("/test")
    private String getPackages2() {
        return "Hello";
    }
}
