package com.rentalproperty.Repositories;

import com.rentalproperty.Factories.*;
import com.rentalproperty.Repositories.Impl.OccupationRepositoryImpl;
import com.rentalproperty.Repositories.Impl.UnitRepositoryImpl;
import com.rentalproperty.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class OccupationRepositoryTest {

    //Occupation
    Occupation occupation;
    long occupationId;
    Date startDate;
    Date endDate;
    OccupationRepository occupationRepository;

    //unit
    Unit unit;
    Map<String, Integer> unitValues;

    //Address
    Address address;
    Map<String, String > addressValues;

    //Parking
    Parking parking;

    //Bathroom
    Bathroom bathroom;

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
        long unitId = 1;
        String unitType = "Bachelor";
        double unitPrice = 5000;
        unitValues = new HashMap<String, Integer>();
        unitValues.put("rooms", 2);
        unitValues.put("unitNo", 24);
        unit = UnitFactory.getUnit(unitId,unitValues,unitType,unitPrice,bathroom,parking);

        //occupation information
        occupationId= 1;
        startDate = new Date();
        endDate = new Date();
        occupation = OccupationFactory.getOccupation(occupationId, unit, startDate, endDate);
        occupationRepository = OccupationRepositoryImpl.getRepository();



    }

    @Test
    public void testCreate() throws Exception {
        occupation = occupationRepository.create(occupation);
        assertEquals(5000.00, occupation.getUnit().getPrice());

    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        occupation = occupationRepository.read(1);
        assertEquals(1, bathroom.getId());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testUpdate() throws Exception {
        occupation = occupationRepository.read(1);
        Occupation updateOccupation = new Occupation.Builder()
                .id(2)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        occupationRepository.update(updateOccupation);
        occupation = occupationRepository.read(2);
        assertEquals(2, occupation.getId());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testDelete() throws Exception {
        occupationRepository.delete(1);
        occupation = occupationRepository.read(1);
        assertNull(occupation);
    }

}