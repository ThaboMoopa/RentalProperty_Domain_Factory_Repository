package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Unit;

public interface UnitRepository {
    Unit create(Unit unit);
    Unit read(long id);
    Unit update(Unit unit);
    void delete(long id);
}
