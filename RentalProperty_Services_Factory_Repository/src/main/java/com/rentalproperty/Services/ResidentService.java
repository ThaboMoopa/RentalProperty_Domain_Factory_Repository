package com.rentalproperty.Services;

import com.rentalproperty.domain.Resident;

public interface ResidentService {
    Resident create(Resident Resident);
    Resident read(long id);
    Resident update(Resident resident);
    void delete(long id);
}
