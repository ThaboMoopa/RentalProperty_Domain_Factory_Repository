package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.OrderRepository;
import com.rentalproperty.domain.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepositoryImpl repository = null;

    private Map<Long, Order> orderTable;

    private OrderRepositoryImpl()
    {
        orderTable = new HashMap<Long, Order>();
    }

    public static OrderRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new OrderRepositoryImpl();
        return repository;
    }

    @Override
    public Order create(Order order) {
        orderTable.put(order.getId(), order);
        Order saveOrder = orderTable.get(order.getId());
        return saveOrder;
    }

    @Override
    public Order read(long id) {
        Order order = orderTable.get(id);
        return order;
    }

    @Override
    public Order update(Order order) {
        orderTable.put(order.getId(), order);
        Order updateOrder = orderTable.get(order.getId());
        return updateOrder;
    }

    @Override
    public void delete(long id) {
        orderTable.remove(id);
    }
}
