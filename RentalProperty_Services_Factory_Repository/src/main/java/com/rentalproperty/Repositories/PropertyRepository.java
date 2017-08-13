package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Property;

public interface PropertyRepository {
    Property create(Property property);
    Property read(long id);
    Property update(Property property);
    void delete(long id);
}
