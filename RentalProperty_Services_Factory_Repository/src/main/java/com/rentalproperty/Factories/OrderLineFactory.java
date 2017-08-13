package com.rentalproperty.Factories;

import com.rentalproperty.domain.Order;
import com.rentalproperty.domain.OrderLine;
import com.rentalproperty.domain.Property;

public class OrderLineFactory {
    public static OrderLine getOrderLine(long id, int quantity, double price, Property property, Order order)
    {
        OrderLine orderLine = new OrderLine.Builder()
                .id(id)
                .quantity(quantity)
                .price(price)
                .property(property)
                .order(order)
                .build();
        return orderLine;
    }
}
