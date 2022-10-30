package com.JPrutoResto.backend.Repository;

import com.JPrutoResto.backend.Entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookingRepository  extends JpaRepository<Bookings, Long> {
}
