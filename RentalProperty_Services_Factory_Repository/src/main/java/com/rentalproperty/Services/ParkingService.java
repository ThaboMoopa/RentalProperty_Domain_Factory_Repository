package com.rentalproperty.Services;

import com.rentalproperty.domain.Parking;

public interface ParkingService {
    Parking create(Parking parking);
    Parking read(long id);
    Parking update(Parking parking);
    void delete(long id);
}
