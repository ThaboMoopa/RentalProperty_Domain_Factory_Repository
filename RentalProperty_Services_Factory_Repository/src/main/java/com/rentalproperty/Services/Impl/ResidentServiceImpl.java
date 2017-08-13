package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.Impl.ResidentRepositoryImpl;
import com.rentalproperty.Repositories.ResidentRepository;
import com.rentalproperty.Services.ResidentService;
import com.rentalproperty.domain.Resident;

public class ResidentServiceImpl implements ResidentService {

   ResidentRepository repository = ResidentRepositoryImpl.getRepository();


    public Resident create(Resident resident) {
        return repository.create(resident);
    }


    public Resident read(long id) {
        return repository.read(id);
    }


    public Resident update(Resident resident) {
        return repository.update(resident);
    }


    public void delete(long id) {
        repository.delete(id);
    }
}
