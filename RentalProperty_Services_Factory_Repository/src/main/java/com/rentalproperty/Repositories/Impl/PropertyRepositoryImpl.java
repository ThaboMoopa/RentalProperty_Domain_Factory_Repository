package com.rentalproperty.Repositories.Impl;


import com.rentalproperty.Repositories.PropertyRepository;
import com.rentalproperty.domain.Property;

import java.util.HashMap;
import java.util.Map;

public class PropertyRepositoryImpl implements PropertyRepository {

    private static PropertyRepositoryImpl repository = null;

    private Map<Long, Property> propertyTable;

    private PropertyRepositoryImpl()
    {
        propertyTable = new HashMap<Long, Property>();
    }
    public static PropertyRepositoryImpl getRepository()
    {
        if(repository == null)
            repository = new PropertyRepositoryImpl();
        return repository;
    }

    @Override
    public Property create(Property property) {
        propertyTable.put(property.getId(), property);
        Property saveProperty = propertyTable.get(property.getId());
        return saveProperty;
    }

    @Override
    public Property read(long id) {
        Property property = propertyTable.get(id);
        return property;
    }

    @Override
    public Property update(Property property) {
        propertyTable.put(property.getId(), property);
        Property updateProperty = propertyTable.get(property.getId());
        return updateProperty;
    }

    @Override
    public void delete(long id) {
    propertyTable.remove(id);
    }
}
