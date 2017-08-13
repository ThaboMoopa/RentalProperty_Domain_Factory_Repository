package com.rentalproperty.Services;

import com.rentalproperty.domain.Unit;

public interface UnitService {
    Unit create(Unit unit);
    Unit read(long id);
    Unit update(Unit unit);
    void delete(long id);
}
