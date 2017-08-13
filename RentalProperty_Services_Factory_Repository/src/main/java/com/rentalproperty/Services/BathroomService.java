package com.rentalproperty.Services;

import com.rentalproperty.domain.Bathroom;

public interface BathroomService {
    Bathroom create(Bathroom bathroom);
    Bathroom read(long id);
    Bathroom update(Bathroom bathroom);
    void delete(long id);
}
