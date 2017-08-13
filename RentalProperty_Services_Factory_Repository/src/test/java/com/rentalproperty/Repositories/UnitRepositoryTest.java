package com.rentalproperty.Repositories;

import com.rentalproperty.Factories.*;
import com.rentalproperty.Repositories.Impl.UnitRepositoryImpl;
import com.rentalproperty.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class UnitRepositoryTest {

    Unit unit;
    Map<String, Integer> unitValues;
    UnitRepository unitRepository;
    long unitId;
    String unitType;
    double unitPrice;
    //Bathroom information
    Bathroom bathroom;

    //Parking information
    Parking parking;

    //Address address
    Address address;
    Map<String, String> addressValues;

    @BeforeMethod
    public void setUp() throws Exception {
        //Address information
        long addressId = 1;
        addressValues = new HashMap<String, String>();
        addressValues.put("street", "Kaapzchict");
        addressValues.put("city", "Cape Town");
        addressValues.put("province", "Western Cape");
        addressValues.put("postalCode", "0152");
        address = AddressFactory.getAddress(addressId, addressValues);

        //Parking information
        long parkingId = 1;
        int parkingNumber = 24;
        double price = 6500;
        parking = ParkingFactory.getParking(parkingId, parkingNumber, price);

        //Bathroom Information
        long bathroomId = 1;
        String bathroomType = "shower only";
        bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);

        //unit information
        unitId = 1;
        unitType = "Bachelor";
        unitPrice = 5000;
        unitValues = new HashMap<String, Integer>();
        unitValues.put("rooms", 2);
        unitValues.put("unitNo", 24);
        unit = UnitFactory.getUnit(unitId,unitValues,unitType,unitPrice,bathroom,parking);
        unitRepository = UnitRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        unitRepository.create(unit);
        assertEquals(24, unit.getRooms());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        unit = unitRepository.read(1);
        assertEquals("Bachelor", unit.getUnitType());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testUpdate() throws Exception {
        unit = unitRepository.read(1);
        Unit updateUnit = new Unit.Builder()
                .id(unitId)
                .unitType(unitType)
                .price(unitPrice)
                .rooms(3)
                .unitNo(unitValues.get("unitNo"))
                .build();
        unitRepository.update(updateUnit);
        unit = unitRepository.read(1);
        assertEquals(3, unit.getRooms());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testDelete() throws Exception {
        unitRepository.delete(1);
        unit = unitRepository.read(1);
        assertNull(unit);
    }

}