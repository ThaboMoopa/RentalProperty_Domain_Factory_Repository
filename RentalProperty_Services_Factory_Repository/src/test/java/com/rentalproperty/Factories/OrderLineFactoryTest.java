package com.rentalproperty.Factories;

import com.rentalproperty.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class OrderLineFactoryTest {
    //Order information
    Order order;

    //Property information
    Property property;

    //OrderLine information
    OrderLine orderLine;

    //bathroom information
    Bathroom bathroom;

    //Address information
    Address address;
    Map<String, String> addressValues;

    //Parking information
    Parking parking;

    //Unit Information
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
        double price = 6500;
        parking = ParkingFactory.getParking(parkingId, parkingNumber, price);

        //Bathroom Information
        long bathroomId = 1;
        String bathroomType = "shower only";
        bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);

        //Property Information
        long propertyId = 1;
        String propertyName = "Rosenvale";
        property = PropertyFactory.getProperty(propertyId,address, propertyName, unitList);

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



        //OrderLine information
        long orderLineId = 1;
        int quantity = 3;
        double orderLinePrice = 7900;
        orderLine = OrderLineFactory.getOrderLine(orderLineId,quantity,orderLinePrice, property, order);
    }

    @Test
    public void testGetOrderLine() throws Exception {
        assertEquals(true, orderLine.equals(orderLine));
    }

}