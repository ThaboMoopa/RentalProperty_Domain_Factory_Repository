package com.rentalproperty.Services;

import com.rentalproperty.Factories.AddressFactory;
import com.rentalproperty.Services.Impl.AddressServiceImpl;
import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Property;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class AddressServiceTest {
    Address address;
    Map<String, String> addressValues;
    AddressService addressService;
    long addressId;

    Property property;

    @BeforeMethod
    public void setUp() throws Exception {
        addressId = 1;
        addressValues = new HashMap<String, String>();
        addressValues.put("street", "Kaapzicht");
        addressValues.put("city", "Cape Town");
        addressValues.put("province", "Western Cape");
        addressValues.put("postalCode", "0152");
        address = AddressFactory.getAddress(addressId, addressValues);
        addressService = new AddressServiceImpl();


    }

    @Test
    public void testCreate() throws Exception {
        addressService.create(address);
        assertEquals("Cape Town", address.getCity());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        addressService.read(1);
        assertEquals("Cape Town", address.getCity());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testUpdate() throws Exception {
        addressService.read(1);
        Address updateBathroom = new Address.Builder()
                .id(addressId)
                .street("pretoria")
                .city(addressValues.get("city"))
                .province(addressValues.get("province"))
                .postalCode(addressValues.get("postalCode"))
                .build();
        addressService.update(updateBathroom);
        address = addressService.read(1);
        assertEquals("pretoria", address.getStreet());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testDelete() throws Exception {
        addressService.delete(1);
        address = addressService.read(1);
        assertNull(address);
    }

}