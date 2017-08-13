package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.UnitRepository;
import com.rentalproperty.domain.Resident;
import com.rentalproperty.domain.Unit;

import java.util.HashMap;
import java.util.Map;

public class UnitRepositoryImpl implements UnitRepository {

    private static UnitRepositoryImpl repository = null;

    private Map<Long, Unit> unitTable;

    private UnitRepositoryImpl()
    {
        unitTable = new HashMap<Long, Unit>();
    }
    public static UnitRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new UnitRepositoryImpl();
        return repository;
    }

    @Override
    public Unit create(Unit unit) {
        unitTable.put(unit.getId(), unit);
        Unit saveUnit = unitTable.get(unit.getId());
        return saveUnit;
    }

    @Override
    public Unit read(long id) {
        Unit unit = unitTable.get(id);
        return unit;
    }

    @Override
    public Unit update(Unit unit) {
        unitTable.put(unit.getId(), unit);
        Unit updateUnit = unitTable.get(unit.getId());
        return updateUnit;
    }

    @Override
    public void delete(long id) {
        unitTable.remove(id);
    }
}
