package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.OrderLineRepository;
import com.rentalproperty.domain.OrderLine;

import java.util.HashMap;
import java.util.Map;

public class OrderLineRepositoryImpl implements OrderLineRepository {

    private static OrderLineRepositoryImpl repository = null;

    private Map<Long, OrderLine> orderLineTable;

    private OrderLineRepositoryImpl()
    {
        orderLineTable = new HashMap<Long, OrderLine>();
    }

    public static OrderLineRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new OrderLineRepositoryImpl();
        return repository;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        orderLineTable.put(orderLine.getId(), orderLine);
        OrderLine saveOrderLine = orderLineTable.get(orderLine.getId());
        return saveOrderLine;

    }

    @Override
    public OrderLine read(long id) {
        OrderLine orderLine = orderLineTable.get(id);
        return orderLine;
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        orderLineTable.put(orderLine.getId(), orderLine);
        OrderLine updateOrderLine = orderLineTable.get(orderLine.getId());
        return updateOrderLine;
    }

    @Override
    public void delete(long id) {
        orderLineTable.remove(id);
    }
}
