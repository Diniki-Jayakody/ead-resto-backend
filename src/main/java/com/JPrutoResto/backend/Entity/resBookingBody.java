package com.JPrutoResto.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class resBookingBody {

    private Bookings bookings;
    private Long packageId;


    public resBookingBody() {
    }
}
