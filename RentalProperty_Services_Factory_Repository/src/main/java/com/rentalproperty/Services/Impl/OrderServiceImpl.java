package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.Impl.OrderRepositoryImpl;
import com.rentalproperty.Repositories.OrderRepository;
import com.rentalproperty.Services.OrderService;
import com.rentalproperty.domain.Order;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = OrderRepositoryImpl.getRepository();

    @Override
    public Order create(Order order) {
        return orderRepository.create(order);
    }

    @Override
    public Order read(long id) {
        return orderRepository.read(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);

    }
}
