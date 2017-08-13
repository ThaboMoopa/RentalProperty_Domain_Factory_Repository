package com.rentalproperty.Factories;

import com.rentalproperty.domain.Order;
import com.rentalproperty.domain.OrderLine;
import com.rentalproperty.domain.Resident;

import java.util.Date;
import java.util.List;

public class OrderFactory {
    public static Order getOrder(long id, Resident resident, List<OrderLine> orderLine, Date date)
    {
        Order order = new Order.Builder()
                .id(id)
                .resident(resident)
                .date(date)
                .ordersLine(orderLine)
                .build();
        return order;
    }
}
