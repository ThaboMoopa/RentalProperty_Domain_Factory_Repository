package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Resident;

public interface ResidentRepository {
    Resident create(Resident resident);
    Resident read(long id);
    Resident update(Resident resident);
    void delete(long id);
}
