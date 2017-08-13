package com.rentalproperty.Factories;

import com.rentalproperty.domain.Bathroom;
import com.rentalproperty.domain.Parking;
import com.rentalproperty.domain.Property;
import com.rentalproperty.domain.Unit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class UnitFactoryTest {
    Unit unit;
    Bathroom bathroom;
    Parking parking;

    Map<String, Integer> unitValues;

    @BeforeMethod
    public void setUp() throws Exception {

    //unit Information
    long unitId = 1;
    String unitType = "Bachelor";
    double unitPrice = 5000;

    unitValues = new HashMap<String, Integer>();
    unitValues.put("rooms", 2);
    unitValues.put("unitNo", 24);
    unit = UnitFactory.getUnit(unitId,unitValues,unitType,unitPrice,bathroom,parking);

    //Property information

    //Bathroom information
    long bathroomId = 2;
    String bathroomType = "Shower only";
    bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);

    //Parking information
        long parkingId = 1;
        int parkingNumber = 24;
        double parkingPrice = 6500;
        parking = ParkingFactory.getParking(parkingId, parkingNumber, parkingPrice);
    }

    @Test
    public void testGetUnit() throws Exception {
        assertEquals(true, unit.equals(unit));
    }

}