package com.rentalproperty.Repositories;

import com.rentalproperty.Factories.AddressFactory;
import com.rentalproperty.Repositories.Impl.AddressRepositoryImpl;
import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Bathroom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class AddressRepositoryTest {


    //Address Information
    Address address;
    Map<String, String> addressValues;
    AddressRepository addressRepository;
    long addressId;

    @BeforeMethod
    public void setUp() throws Exception {
        addressId = 2;
        addressValues = new HashMap<String, String>();
        addressValues.put("street", "Kaapzchict");
        addressValues.put("city", "Cape Town");
        addressValues.put("province", "Western Cape");
        addressValues.put("postalCode", "0152");
        address = AddressFactory.getAddress(addressId, addressValues);
        addressRepository = AddressRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        address = addressRepository.create(address);
        assertEquals("Cape Town", address.getCity());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        address = addressRepository.read(2);
        assertEquals(2, address.getId());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        address = addressRepository.read(2);
        Address updateAddress = new Address.Builder()
                .id(addressId)
                .city("pretoria")
                .province(addressValues.get("province"))
                .street(addressValues.get("street"))
                .postalCode(addressValues.get("postalCode"))
                .build();
        addressRepository.update(updateAddress);
        address = addressRepository.read(2);
        assertEquals("pretoria", address.getCity());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        addressRepository.delete(2);
        address = addressRepository.read(2);
        assertNull(address);
    }

}