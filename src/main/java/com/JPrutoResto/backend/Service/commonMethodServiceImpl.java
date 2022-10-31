package com.JPrutoResto.backend.Service;





import com.JPrutoResto.backend.Entity.*;
import com.JPrutoResto.backend.Repository.bookingRepository;
import com.JPrutoResto.backend.Repository.customerRepository;
import com.JPrutoResto.backend.Repository.packageRepository;
import com.JPrutoResto.backend.Repository.packageUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class commonMethodServiceImpl implements commonMethodService {

    @Autowired
    private packageRepository packageRepository;

    @Autowired
    private packageUrlRepository packageUrlRepository;

    @Autowired
    private customerRepository customerRepository;

    @Autowired
    private bookingRepository bookingRepository;
    @Override
    public String addPackage(addPackageBody addPackageBody) {
        Optional<packageUrl> packageUrl = packageUrlRepository.findByName(addPackageBody.getPackageUrl().getName());
        if(packageUrl.isPresent()){
            addPackageBody.getPackages().setPackageUrl(packageUrl.get());
        }
        else {
            Long id = packageUrlRepository.save(addPackageBody.getPackageUrl()).getId();
            Optional<packageUrl> packageUrl1 = packageUrlRepository.findById(id);
            packageUrl1.ifPresent(url -> addPackageBody.getPackages().setPackageUrl(url));
        }
        packageRepository.save(addPackageBody.getPackages());
        return "Added";
    }

    private boolean makeTimeCheck(int makeDelay , String time){
        String hour = time.substring(0,2);
        String min = time.substring(3);
        int hourNow = LocalTime.now().getHour();
        int minNow = LocalTime.now().getMinute();
        int minCount = hourNow*60+minNow;
        int hourGiven = Integer.parseInt(hour);
        int minGiven = Integer.parseInt(min);
        int minCountGiven = hourGiven*60+minGiven;
        if(minCountGiven> minCount+makeDelay){
            return true;
        }
        return false;
    }
    private boolean timeCompare(String time){
        String hour = time.substring(0,2);
        String min = time.substring(3);
        LocalTime time1;
        time1 = LocalTime.of(Integer.parseInt(hour) , Integer.parseInt(min) , 0);
        int returnVal = time1.compareTo(LocalTime.now());
        System.out.println(returnVal);
        if(returnVal > 0){
            return true;
        }
        return false;
    }

    private String checkType(String time){
        String hour = time.substring(0,2);
        String min = time.substring(3);
        int hourGiven = Integer.parseInt(hour);
        int minGiven = Integer.parseInt(min);
        if(hourGiven>= 12 && hourGiven<=17){
            return "Lunch";
        }
        else if(hourGiven>=19 && hourGiven<=23){
            return "Dinner";
        }

        return "Closed";
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
    public String addBooking(addBookingBody addBookingBody) {
        Optional<Customers> customer = customerRepository.findByNic(addBookingBody.getCustomers().getNic());
        if(customer.isPresent()){
            addBookingBody.getBookings().setCustomers(customer.get());
        }
        else {
            Long id = customerRepository.save(addBookingBody.getCustomers()).getId();
            Optional<Customers> customers = customerRepository.findById(id);
            customers.ifPresent(url -> addBookingBody.getBookings().setCustomers(url));
        }
        addBookingBody.getBookings().setPackages(packageRepository.findById(addBookingBody.getPackageId()).get());
        bookingRepository.save(addBookingBody.getBookings());
        return "Added";
    }

    @Override
    public List<resBookingBody> getBooking() {
        List<Packages> packages = packageRepository.findAll();
        List<getBookingBody> bookingBodies = new ArrayList<>();
        List<resBookingBody> bookings = new ArrayList<>();
        for(Packages packages1 : packages){
            List<Bookings> bookings1 = packages1.getBookings();
            for(Bookings bookings2 : bookings1){
                String time = bookings2.getTime();
                String hour = time.substring(0,2);
                String min = time.substring(3,5);
                int hourNow = LocalTime.now().getHour();
                int minNow = LocalTime.now().getMinute();
                int minCount = hourNow*60+minNow;
                int hourGiven = Integer.parseInt(hour);
                int minGiven = Integer.parseInt(min);
                int minCountGiven = hourGiven*60+minGiven;
                getBookingBody getBookingBody = new getBookingBody();
                getBookingBody.setBookings(bookings2);
                getBookingBody.setMinCount(minCountGiven);
                getBookingBody.setId(packages1.getId());
                if (minCountGiven>minCount){
                    bookingBodies.add(getBookingBody);
                }

            }
        }

        int i=0;
        while (i<bookingBodies.size()-1){
            if(bookingBodies.get(i).getMinCount()>bookingBodies.get(i+1).getMinCount()){
                getBookingBody getBookingBody = bookingBodies.get(i);
                bookingBodies.get(i).setBookings(bookingBodies.get(i+1).getBookings());
                bookingBodies.get(i).setMinCount(bookingBodies.get(i+1).getMinCount());
                bookingBodies.get(i+1).setBookings(getBookingBody.getBookings());
                bookingBodies.get(i+1).setMinCount(getBookingBody.getMinCount());

                int j = i;

                while (j>0){
                    if(bookingBodies.get(j).getMinCount()<bookingBodies.get(j-1).getMinCount()){
                        getBookingBody getBookingBody2 = bookingBodies.get(j);
                        bookingBodies.get(j).setBookings(bookingBodies.get(j-1).getBookings());
                        bookingBodies.get(j).setMinCount(bookingBodies.get(j-1).getMinCount());
                        bookingBodies.get(j-1).setBookings(getBookingBody2.getBookings());
                        bookingBodies.get(j-1).setMinCount(getBookingBody2.getMinCount());

                    }
                    j--;
                }
            }
            i++;
        }

        for(getBookingBody bookingBody : bookingBodies){
            resBookingBody resBookingBody = new resBookingBody();
            resBookingBody.setBookings(bookingBody.getBookings());
            resBookingBody.setPackageId(bookingBody.getId());
            bookings.add(resBookingBody);
        }
        return bookings;
    }

    @Override
    public List<packageName> getPackageUrlNames() {
        List<packageUrl> packages =  packageUrlRepository.findAll();
        List<packageName> packageNames = new ArrayList<>();
        for (packageUrl packages1 : packages){
            packageName packageName = new packageName();
            packageName.setName(packages1.getName());
            packageNames.add(packageName);
        }
        return packageNames;
    }

    @Override
    public List<GetPackageUrls> getPackageUrls(String time) {
        List<packageUrl> packages =  packageUrlRepository.findAll();
        List<GetPackageUrls> packageUrls = new ArrayList<>();
        if(timeCompare(time)){
            String type = checkType(time);
            for (packageUrl packages1 : packages){
                if(packages1.getStatus()==null){
                    continue;
                }
                if(type.equalsIgnoreCase(packages1.getStatus()) || packages1.getStatus().equalsIgnoreCase("Both")){
                    if(makeTimeCheck(packages1.getMakeTime() , time)){
                        GetPackageUrls packageName = new GetPackageUrls();
                        packageName.setName(packages1.getName());
                        packageName.setUrl(packages1.getUrl());
                        packageName.setId(packages1.getId());
                        packageUrls.add(packageName);
                    }
                }

            }


        }
        return packageUrls;
    }

    @Override
    public List<Packages> getPackagesByPackageUrl(Long id) {
        Optional<packageUrl> packageUrl = packageUrlRepository.findById(id);
        List<Packages> packages = new ArrayList<>();
        if (packageUrl.isPresent()){
            List<Packages> packages1 = packageUrl.get().getPackages();
            for (Packages packages2 : packages1){
                if(packages2.isAvailability()){
                    packages.add(packages2);
                }
            }
        }
        return packages;
    }

    @Override
    public String updateAvailabilityOFPackage(Long id , boolean availability) {
        Optional<Packages> packages = packageRepository.findById(id);
        if(packages.isPresent()){
            packages.get().setAvailability(availability);
            packageRepository.save(packages.get());
            return "success";
        }
        return "error id";
    }

    @Override
    public String deletePackage(Long id) {
        Optional<Packages> packages = packageRepository.findById(id);
        if(packages.isPresent()){
            List<Bookings> bookings = packages.get().getBookings();
            for(Bookings bookings1 : bookings){
                bookingRepository.delete(bookings1);
            }
            packageRepository.delete(packages.get());
            return "success";
        }
        return "error id";
    }
}
