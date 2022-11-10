package com.JPrutoResto.backend.Controller;

import com.JPrutoResto.backend.Entity.*;
import com.JPrutoResto.backend.Repository.packageUrlRepository;
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

    @Autowired
    private packageUrlRepository packageUrlRepository;

    @PostMapping("/addPackage")
    private String addPackage(@RequestBody addPackageBody packages){
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
    private String addBooking(@RequestBody addBookingBody bookings){
        return commonMethodService.addBooking(bookings);
    }

    @GetMapping("/getBooking")
    private List<resBookingBody> getBooking(){
        return commonMethodService.getBooking();
    }





    @GetMapping("/getPackageNames")
    private List<packageName> getPackageNames(){
        return commonMethodService.getPackageUrlNames();
    }

    @GetMapping("/getPackageUrls/{time}")
    private List<GetPackageUrls> getPackageNames(@PathVariable String time){
        return commonMethodService.getPackageUrls(time);
    }

    @GetMapping("/getPackagesByUrl/{id}")
    private List<Packages> getPackageUrls(@PathVariable Long id){
        return commonMethodService.getPackagesByPackageUrl(id);
    }

    @PutMapping("/availabilityUpdate/{id}/{availability}")
    private String updatePackage(@PathVariable Long id , @PathVariable boolean availability){
        return commonMethodService.updateAvailabilityOFPackage(id, availability);
    }

    @DeleteMapping("/deletePackage/{id}")
    private String deletePackage(@PathVariable Long id){
        return commonMethodService.deletePackage(id);
    }

    @GetMapping("/test")
    private String getPackages2() {
        return "Hello";
    }
}
