package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Parking;

public interface ParkingRepository {
    Parking create(Parking parking);
    Parking read(long id);
    Parking update(Parking parking);
    void delete(long id);
}
