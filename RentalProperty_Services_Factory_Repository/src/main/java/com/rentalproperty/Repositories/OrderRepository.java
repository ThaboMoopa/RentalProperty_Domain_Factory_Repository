package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Order;

public interface OrderRepository {
    Order create(Order order);
    Order read(long id);
    Order update(Order order);
    void delete(long id);
}
