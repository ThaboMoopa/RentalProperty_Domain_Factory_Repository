package com.rentalproperty.Repositories;

import com.rentalproperty.domain.OrderLine;

public interface OrderLineRepository {
    OrderLine create(OrderLine orderLine);
    OrderLine read(long id);
    OrderLine update(OrderLine orderLine);
    void delete(long id);

}
