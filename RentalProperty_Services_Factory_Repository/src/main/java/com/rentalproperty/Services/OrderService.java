package com.rentalproperty.Services;

import com.rentalproperty.domain.Order;

public interface OrderService {
    Order create(Order order);
    Order read(long id);
    Order update(Order order);
    void delete(long id);
}
