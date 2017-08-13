package com.rentalproperty.Services;

import com.rentalproperty.domain.Property;

public interface PropertyService {
    Property create(Property property);
    Property read(long id);
    Property update(Property property);
    void delete(long id);
}
