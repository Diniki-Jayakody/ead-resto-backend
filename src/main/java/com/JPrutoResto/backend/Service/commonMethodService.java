package com.JPrutoResto.backend.Service;


import com.JPrutoResto.backend.Entity.*;

import java.util.List;

public interface commonMethodService {

    String addPackage(addPackageBody addPackageBody);
    List<Packages> getPackages();

    String addCustomer(Customers customers);
    List<Customers> getCustomers();

    String addBooking(addBookingBody bookings);
    List<Bookings> getBooking();

    List<packageName> getPackageUrlNames();

    List<GetPackageUrls> getPackageUrls(String time);

    List<Packages> getPackagesByPackageUrl(Long id);

    String updateAvailabilityOFPackage(Long id , boolean availability);

    String deletePackage(Long id);
}
