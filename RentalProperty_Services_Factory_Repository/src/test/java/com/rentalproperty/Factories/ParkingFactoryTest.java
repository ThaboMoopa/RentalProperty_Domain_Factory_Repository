package com.rentalproperty.Factories;

import com.rentalproperty.domain.Parking;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParkingFactoryTest {
    Parking parking;

    @BeforeMethod
    public void setUp() throws Exception {
        long parkingId = 1;
        int parkingNumber = 24;
        double price = 6500;
        parking = ParkingFactory.getParking(parkingId, parkingNumber, price);
    }

    @Test
    public void testGetParking() throws Exception {
        assertEquals(true, parking.equals(parking));
    }

}