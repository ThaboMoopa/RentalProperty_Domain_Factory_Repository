package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.Impl.UnitRepositoryImpl;
import com.rentalproperty.Repositories.UnitRepository;
import com.rentalproperty.Services.UnitService;
import com.rentalproperty.domain.Unit;

public class UnitServiceImpl implements UnitService {

    UnitRepository unitRepository = UnitRepositoryImpl.getRepository();
    @Override
    public Unit create(Unit unit) {
        return unitRepository.create(unit);
    }

    @Override
    public Unit read(long id) {
        return unitRepository.read(id);
    }

    @Override
    public Unit update(Unit unit) {
        return unitRepository.update(unit);
    }

    @Override
    public void delete(long id) {
        unitRepository.delete(id);

    }
}
