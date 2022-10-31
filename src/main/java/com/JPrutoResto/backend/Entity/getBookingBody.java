package com.JPrutoResto.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class getBookingBody {

    private Bookings bookings;
    private int minCount;


    public getBookingBody() {
    }
}
