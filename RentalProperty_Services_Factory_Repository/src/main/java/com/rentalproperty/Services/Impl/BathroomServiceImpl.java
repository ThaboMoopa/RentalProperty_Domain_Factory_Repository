package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.BathroomRepository;
import com.rentalproperty.Repositories.Impl.BathroomRepositoryImpl;
import com.rentalproperty.Services.BathroomService;
import com.rentalproperty.domain.Bathroom;

public class BathroomServiceImpl implements BathroomService {

    BathroomRepository repository = BathroomRepositoryImpl.getRepository();

    @Override
    public Bathroom create(Bathroom bathroom) {
        return repository.create(bathroom);
    }

    @Override
    public Bathroom read(long id) {
        return repository.read(id);
    }

    @Override
    public Bathroom update(Bathroom bathroom) {
        return repository.update(bathroom);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
