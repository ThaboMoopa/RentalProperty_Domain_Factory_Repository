package com.rentalproperty.Services;

import com.rentalproperty.domain.OrderLine;

public interface OrderLineService {
    OrderLine create(OrderLine orderLine);
    OrderLine read(long id);
    OrderLine update(OrderLine orderLine);
    void delete(long id);
}
