package com.JPrutoResto.backend.Service;


import com.JPrutoResto.backend.Entity.Bookings;
import com.JPrutoResto.backend.Entity.Customers;
import com.JPrutoResto.backend.Entity.Packages;

import java.util.List;

public interface commonMethodService {

    String addPackage(Packages packages);
    List<Packages> getPackages();

    String addCustomer(Customers customers);
    List<Customers> getCustomers();

    String addBooking(Bookings bookings);
    List<Bookings> getBooking();

}
