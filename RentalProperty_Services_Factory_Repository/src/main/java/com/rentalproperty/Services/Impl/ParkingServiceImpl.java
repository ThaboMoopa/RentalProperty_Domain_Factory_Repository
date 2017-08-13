package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.Impl.ParkingRepositoryImpl;
import com.rentalproperty.Repositories.ParkingRepository;
import com.rentalproperty.Services.ParkingService;
import com.rentalproperty.domain.Parking;

public class ParkingServiceImpl implements ParkingService {

    ParkingRepository parkingRepository = ParkingRepositoryImpl.getRepository();

    @Override
    public Parking create(Parking parking) {
        return parkingRepository.create(parking);
    }

    @Override
    public Parking read(long id) {
        return parkingRepository.read(id);
    }

    @Override
    public Parking update(Parking parking) {
        return parkingRepository.update(parking);
    }

    @Override
    public void delete(long id) {
        parkingRepository.delete(id);
    }
}
