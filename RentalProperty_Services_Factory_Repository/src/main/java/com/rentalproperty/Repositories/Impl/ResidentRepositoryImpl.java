package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.ResidentRepository;
import com.rentalproperty.domain.Resident;

import java.util.HashMap;
import java.util.Map;

public class ResidentRepositoryImpl implements ResidentRepository {

    private static ResidentRepositoryImpl repository = null;

    private Map<Long, Resident> residentTable;

    private ResidentRepositoryImpl()
    {
        residentTable = new HashMap<Long, Resident>();
    }

    public static ResidentRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new ResidentRepositoryImpl();
        return repository;
    }


    public Resident create(Resident resident) {
        residentTable.put(resident.getId(), resident);
        Resident saveResident = residentTable.get(resident.getId());
        return saveResident;
    }

    public Resident read(long id) {
        Resident resident = residentTable.get(id);
        return resident;
    }


    public Resident update(Resident resident) {
        residentTable.put(resident.getId(), resident);
        Resident updateResident = residentTable.get(resident.getId());
        return updateResident;
    }


    public void delete(long id) {
        residentTable.remove(id);

    }
}
