package com.rentalproperty.Services;

import com.rentalproperty.Factories.ResidentFactory;
import com.rentalproperty.Repositories.OrderRepository;
import com.rentalproperty.Services.Impl.ResidentServiceImpl;
import com.rentalproperty.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class ResidentServiceTest {
    Resident resident;
    long id;
    Map<String, String> residentValues;
    ResidentService service;

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


        id = 1;

        //Setup for Resident
        residentValues = new HashMap<String, String>();
        residentValues.put("name", "Thabo");
        residentValues.put("surname", "Moopa");
        residentValues.put("email", "Thabo.moopa@gmail.com");
        residentValues.put("contact", "0849262255");
        residentValues.put("password", "John1moopa");
        resident = ResidentFactory.getResident(id,residentValues, orderList);
        service = new ResidentServiceImpl();

    }

    @Test
    public void create() throws Exception {
        //
        service.create(resident);
        assertEquals(resident.getName(), "Thabo");
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {
        resident = service.read(1);
        assertEquals("Moopa", resident.getSurname());
    }

    @Test(dependsOnMethods = {"read","create"})
    public void update() throws Exception {
        resident = service.read(1);
        Resident updateResident = new Resident.Builder()
                .id(id)
                .name(residentValues.get("name"))
                .surname(residentValues.get("surname"))
                .contact("0829379914")
                .email(residentValues.get("email"))
                .password(residentValues.get("password"))
                .build();
        service.update(updateResident);
        resident = service.read(1);
        assertEquals(resident.getContact(), "0829379914");
    }

    @Test(dependsOnMethods = {"create", "read"})
    public void delete() throws Exception {
        service.delete(1);
        resident = service.read(1);
        assertNull(resident);
    }

}