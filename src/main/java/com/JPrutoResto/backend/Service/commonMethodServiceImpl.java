package com.JPrutoResto.backend.Service;





import com.JPrutoResto.backend.Entity.Bookings;
import com.JPrutoResto.backend.Entity.Customers;
import com.JPrutoResto.backend.Entity.Packages;
import com.JPrutoResto.backend.Repository.packageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class commonMethodServiceImpl implements commonMethodService {

    @Autowired
    private packageRepository packageRepository;

    @Override
    public String addPackage(Packages packages) {
        packageRepository.save(packages);
        return "Added";
    }

    @Override
    public List<Packages> getPackages() {
        return packageRepository.findAll();
    }

    @Override
    public String addCustomer(Customers customers) {
        return null;
    }

    @Override
    public List<Customers> getCustomers() {
        return null;
    }

    @Override
    public String addBooking(Bookings bookings) {
        return null;
    }

    @Override
    public List<Bookings> getBooking() {
        return null;
    }
}
