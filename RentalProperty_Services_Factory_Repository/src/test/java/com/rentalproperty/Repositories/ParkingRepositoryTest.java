package com.rentalproperty.Repositories;

import com.rentalproperty.Factories.ParkingFactory;
import com.rentalproperty.Repositories.Impl.ParkingRepositoryImpl;
import com.rentalproperty.domain.Parking;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParkingRepositoryTest {
    Parking parking;
    long parkingId;
    int parkingNumber;
    double price;
    ParkingRepository parkingRepository;
    @BeforeMethod
    public void setUp() throws Exception {
        //Parking information
        parkingId = 1;
        parkingNumber = 24;
        price = 65;
        parking = ParkingFactory.getParking(parkingId, parkingNumber, price);
        parkingRepository = ParkingRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        parking = parkingRepository.create(parking);
        assertEquals(65.00, parking.getPrice());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        parking = parkingRepository.read(1);
        assertEquals(24, parking.getParkingNumber());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        parking = parkingRepository.read(1);
        Parking updateParking = new Parking.Builder()
                .id(parkingId)
                .price(64)
                .parkingNumber(parkingNumber)
                .build();
        parkingRepository.update(updateParking);
        parking = parkingRepository.read(1);
        assertEquals(1, parking.getId());

    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testDelete() throws Exception {
        parkingRepository.delete(1);
        parking = parkingRepository.read(1);
        assertNull(parking);
    }

}