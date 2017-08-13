package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Bathroom;

public interface BathroomRepository {
    Bathroom create(Bathroom bathroom);
    Bathroom read(long id);
    Bathroom update(Bathroom bathroom);
    void delete(long id);
}
