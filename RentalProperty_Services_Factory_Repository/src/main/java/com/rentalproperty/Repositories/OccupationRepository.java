package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Occupation;

public interface OccupationRepository {
    Occupation create(Occupation occupation);
    Occupation read(long id);
    Occupation update(Occupation occupation);
    void delete(long id);
}
