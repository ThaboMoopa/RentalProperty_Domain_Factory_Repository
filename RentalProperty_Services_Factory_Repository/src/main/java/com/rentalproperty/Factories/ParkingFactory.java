package com.rentalproperty.Factories;

import com.rentalproperty.domain.Parking;

import java.util.List;

public class ParkingFactory {
    public static Parking getParking(long id, int parkingNumber, double price)
    {
        Parking parking = new Parking.Builder()
                .id(id)
                .parkingNumber(parkingNumber)
                .price(price)
                .build();
        return parking;
    }

}
