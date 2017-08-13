package com.rentalproperty.Repositories;

import com.rentalproperty.Factories.*;
import com.rentalproperty.Repositories.Impl.PropertyRepositoryImpl;
import com.rentalproperty.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.StrictMath.round;
import static org.testng.Assert.*;

public class PropertyRepositoryTest {
    Property property;
    PropertyRepository propertyRepository;
    long propertyId;
    //parking information
    Parking parking;

    //Bathroom information
    Bathroom bathroom;

    //Address information
    Address address;
    Map<String, String> addressValues;

    //Unit information
    Unit unit;
    Map<String, Integer> unitValues;
    List<Unit> unitList;


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
        double price = 65;
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
        unitList = new ArrayList<Unit>();
        unitList.add(unit);

        //Property Information
        propertyId = 1;
        String propertyName = "Rosenvale";
        property = PropertyFactory.getProperty(propertyId,address, propertyName, unitList);
        propertyRepository = PropertyRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        property = propertyRepository.create(property);
        assertEquals(5000.00, property.getUnit().get(0).getPrice());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        property = propertyRepository.read(1);
        assertEquals(65.00, property.getUnit().get(0).getParking().getPrice());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        property = propertyRepository.read(1);
        Property updateProperty = new Property.Builder()
                .id(propertyId)
                .name("Buh Rein")
                .build();
        propertyRepository.update(updateProperty);
        property = propertyRepository.read(1);
        assertEquals("Buh Rein", property.getName());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        propertyRepository.delete(1);
        property = propertyRepository.read(1);
        assertNull(property);
    }

}