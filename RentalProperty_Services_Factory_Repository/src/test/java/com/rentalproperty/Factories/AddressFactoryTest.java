package com.rentalproperty.Factories;

import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Property;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class AddressFactoryTest {
    Address address;

    Map<String, String> addressValues;

    @BeforeMethod
    public void setUp() throws Exception {
       long addressId = 1;
       addressValues = new HashMap<String, String>();
       addressValues.put("street", "Kaapzchict");
       addressValues.put("city", "Cape Town");
       addressValues.put("province", "Western Cape");
       addressValues.put("postalCode", "0152");
       address = AddressFactory.getAddress(addressId, addressValues);
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals(true, address.equals(address));
    }

}