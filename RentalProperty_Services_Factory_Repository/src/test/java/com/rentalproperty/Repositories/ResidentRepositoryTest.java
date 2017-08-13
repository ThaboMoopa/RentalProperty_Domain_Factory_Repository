package com.rentalproperty.Repositories;

import com.rentalproperty.Factories.ResidentFactory;
import com.rentalproperty.Repositories.Impl.ResidentRepositoryImpl;
import com.rentalproperty.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class ResidentRepositoryTest {

    Map<String, String> residentValues;
    ResidentRepository residentRepository;
    long id;
    Resident resident;
    //Order information
    Order order;
    long orderId;
    Date date;
    List<Order> orderList;
    OrderRepository orderRepository;

    //OrderLine information
    OrderLine orderLine;
    List<OrderLine> orderLineList;

    //Bathroom
    Bathroom bathroom;

    //Address
    Address address;
    Map<String, String> addressValues;

    //Parking
    Parking parking;

    //Property
    Property property;

    //Unit
    Unit unit;
    Map<String, Integer> unitValues;
    List<Unit> unitList;
    @BeforeMethod
    public void setUp() throws Exception {
        id = 2;
        residentRepository = ResidentRepositoryImpl.getRepository();
        residentValues = new HashMap<String, String>();
        residentValues.put("name", "Thabo");
        residentValues.put("surname", "Moopa");
        residentValues.put("email", "Thabo.moopa@gmail.com");
        residentValues.put("contact", "0849262255");
        residentValues.put("password", "John1moopa");
        resident = ResidentFactory.getResident(id,residentValues, orderList);
    }

    @Test
    public void testCreate() throws Exception {

        residentRepository.create(resident);
        assertEquals(2, resident.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Resident resident = residentRepository.read(2);
        assertEquals("Thabo", resident.getName());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testUpdate() throws Exception {
        resident = residentRepository.read(2);
        Resident updateResident = new Resident.Builder()
                .id(id)
                .name(residentValues.get("name"))
                .surname(residentValues.get("surname"))
                .contact(residentValues.get("contact"))
                .email("thabo.moopa@gmail")
                .password("password")
                .build();
        residentRepository.update(updateResident);
        resident = residentRepository.read(2);
        assertEquals("thabo.moopa@gmail", resident.getEmail());
    }

    @Test(dependsOnMethods = {"testCreate","testUpdate"})
    public void testDelete() throws Exception {
        residentRepository.delete(2);
        Resident resident = residentRepository.read(2);
        assertNull(resident);
    }

}