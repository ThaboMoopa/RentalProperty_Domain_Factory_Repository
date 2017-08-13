package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.ParkingRepository;
import com.rentalproperty.domain.Parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingRepositoryImpl implements ParkingRepository {

    private static ParkingRepositoryImpl repository = null;

    private Map<Long, Parking> parkingTable;

    private ParkingRepositoryImpl(){
        parkingTable = new HashMap<Long, Parking>();
    }

    public static ParkingRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new ParkingRepositoryImpl();
        return repository;
    }

    @Override
    public Parking create(Parking parking) {
        parkingTable.put(parking.getId(), parking);
        Parking saveParking = parkingTable.get(parking.getId());
        return saveParking;
    }

    @Override
    public Parking read(long id) {
        Parking parking = parkingTable.get(id);
        return parking;
    }

    @Override
    public Parking update(Parking parking) {
        parkingTable.put(parking.getId(), parking);
        Parking updateParking = parkingTable.get(parking.getId());
        return updateParking;
    }

    @Override
    public void delete(long id) {
        parkingTable.remove(id);
    }
}
