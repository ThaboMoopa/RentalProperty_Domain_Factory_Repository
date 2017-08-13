package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.BathroomRepository;
import com.rentalproperty.domain.Bathroom;

import java.util.HashMap;
import java.util.Map;

public class BathroomRepositoryImpl implements BathroomRepository {

    private static BathroomRepositoryImpl repository = null;

    private Map<Long, Bathroom> bathroomTable;

    private BathroomRepositoryImpl()
    {
        bathroomTable = new HashMap<Long, Bathroom>();

    }

    public static BathroomRepositoryImpl getRepository()
    {
        if(repository == null)
        {
            repository = new BathroomRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Bathroom create(Bathroom bathroom) {
        bathroomTable.put(bathroom.getId(), bathroom);
        Bathroom saveBathroom = bathroomTable.get(bathroom.getId());
        return saveBathroom;
    }

    @Override
    public Bathroom read(long id) {
        Bathroom bathroom = bathroomTable.get(id);
        return bathroom;
    }

    @Override
    public Bathroom update(Bathroom bathroom) {
        bathroomTable.put(bathroom.getId(), bathroom);
        Bathroom updateBathroom = bathroomTable.get(bathroom.getId());
        return updateBathroom;
    }

    @Override
    public void delete(long id) {
        bathroomTable.remove(id);
    }
}
