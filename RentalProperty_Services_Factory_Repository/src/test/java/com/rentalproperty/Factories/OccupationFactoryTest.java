package com.rentalproperty.Factories;

import com.rentalproperty.domain.Bathroom;
import com.rentalproperty.domain.Occupation;
import com.rentalproperty.domain.Parking;
import com.rentalproperty.domain.Unit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class OccupationFactoryTest {

    //Occupation information
    Occupation occupation;
    long occupationId;
    Date startDate;
    Date endDate;

    //Unit information
    Unit unit;
    Map<String, Integer> unitValues;

    //Bathroom
    Bathroom bathroom;

    //Parking information
    Parking parking;

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

        //Bathroom information
        long bathroomId = 2;
        String bathroomType = "Shower only";
        bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);

        //Parking information
        long parkingId = 1;
        int parkingNumber = 24;
        double parkingPrice = 6500;
        parking = ParkingFactory.getParking(parkingId, parkingNumber, parkingPrice);

        //occupation information
        occupationId= 1;
        startDate = new Date();
        endDate = new Date();
        occupation = OccupationFactory.getOccupation(occupationId, unit, startDate, endDate);
    }

    @Test
    public void testGetOccupation() throws Exception {
        assertEquals(true, occupation.equals(occupation));
    }

}