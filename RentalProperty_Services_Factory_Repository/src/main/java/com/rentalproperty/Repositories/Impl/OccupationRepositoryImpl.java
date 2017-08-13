package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.OccupationRepository;
import com.rentalproperty.domain.Occupation;

import java.util.HashMap;
import java.util.Map;

public class OccupationRepositoryImpl implements OccupationRepository {

    private static OccupationRepositoryImpl repository = null ;

    private Map<Long, Occupation> occupationTable;

    private OccupationRepositoryImpl()
    {
        occupationTable = new HashMap<Long, Occupation>();
    }

    public static OccupationRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new OccupationRepositoryImpl();
        return repository;
    }

    @Override
    public Occupation create(Occupation occupation) {
        occupationTable.put(occupation.getId(), occupation);
        Occupation saveOccupation = occupationTable.get(occupation.getId());
        return saveOccupation;
    }

    @Override
    public Occupation read(long id) {
        Occupation occupation = occupationTable.get(id);
        return occupation;
    }

    @Override
    public Occupation update(Occupation occupation) {
        occupationTable.put(occupation.getId(), occupation);
        Occupation updateOccupation = occupationTable.get(occupation.getId());
        return updateOccupation;
    }

    @Override
    public void delete(long id) {
        occupationTable.remove(id);
    }
}
