package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.Impl.OrderLineRepositoryImpl;
import com.rentalproperty.Repositories.OrderLineRepository;
import com.rentalproperty.Services.OrderLineService;
import com.rentalproperty.domain.OrderLine;

public class OrderLineServiceImpl implements OrderLineService {

    OrderLineRepository orderLineRepository = OrderLineRepositoryImpl.getRepository();

    @Override
    public OrderLine create(OrderLine orderLine) {
        return orderLineRepository.create(orderLine);
    }

    @Override
    public OrderLine read(long id) {
       return orderLineRepository.read(id);
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return orderLineRepository.update(orderLine);
    }

    @Override
    public void delete(long id) {
        orderLineRepository.delete(id);
    }
}
