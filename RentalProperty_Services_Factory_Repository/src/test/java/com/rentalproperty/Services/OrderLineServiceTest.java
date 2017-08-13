package com.rentalproperty.Services;

import com.rentalproperty.Factories.OrderLineFactory;
import com.rentalproperty.Repositories.Impl.OrderLineRepositoryImpl;
import com.rentalproperty.Repositories.Impl.OrderRepositoryImpl;
import com.rentalproperty.Repositories.OrderLineRepository;
import com.rentalproperty.Services.Impl.OrderLineServiceImpl;
import com.rentalproperty.Services.Impl.OrderServiceImpl;
import com.rentalproperty.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class OrderLineServiceTest {
    //Order information
    Order order;
    long orderId;
    Date date;
    List<Order> orderList;

    //OrderLine information
    OrderLine orderLine;
    List<OrderLine> orderLineList;
    OrderLineRepository orderLineRepository;
    double orderLinePrice;
    long orderLineId;
    int quantity;

    OrderLineService orderLineService;

    //Resident Information
    Resident resident;
    Map<String,String> residentValues;

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

        //OrderLine information
        orderLineId = 1;
        quantity = 3;
        orderLinePrice = 7900;
        orderLine = OrderLineFactory.getOrderLine(orderLineId,quantity,orderLinePrice, property, order);
        orderLineRepository = OrderLineRepositoryImpl.getRepository();

        orderLineService = new OrderLineServiceImpl();
    }

    @Test
    public void testCreate() throws Exception {
        orderLineService.create(orderLine);
        assertEquals(7900.00, orderLine.getPrice());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        orderLineService.read(1);
        assertEquals(7900.00, orderLine.getPrice());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testUpdate() throws Exception {
        orderLineService.read(1);
        OrderLine updateBathroom = new OrderLine.Builder()
                .id(orderLineId)
                .price(7800)
                .quantity(quantity)
                .build();
        orderLineService.update(updateBathroom);
        orderLine = orderLineService.read(1);
        assertEquals(7800.00, orderLine.getPrice());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testDelete() throws Exception {
        orderLineService.delete(1);
        orderLine = orderLineService.read(1);
        assertNull(orderLine);
    }

}