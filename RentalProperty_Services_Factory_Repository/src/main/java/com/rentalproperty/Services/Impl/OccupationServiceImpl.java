package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.Impl.OccupationRepositoryImpl;
import com.rentalproperty.Repositories.OccupationRepository;
import com.rentalproperty.Services.OccupationService;
import com.rentalproperty.domain.Occupation;

public class OccupationServiceImpl implements OccupationService {

    OccupationRepository repository = OccupationRepositoryImpl.getRepository();

    @Override
    public Occupation create(Occupation occupation) {
        return repository.create(occupation);
    }

    @Override
    public Occupation read(long id) {
        return repository.read(id);
    }

    @Override
    public Occupation update(Occupation occupation) {
        return repository.update(occupation);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);

    }
}
