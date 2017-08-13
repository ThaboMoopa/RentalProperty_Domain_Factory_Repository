package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.Impl.PropertyRepositoryImpl;
import com.rentalproperty.Repositories.PropertyRepository;
import com.rentalproperty.Services.PropertyService;
import com.rentalproperty.domain.Property;

import java.util.PropertyResourceBundle;

public class PropertyServiceImpl implements PropertyService {

    PropertyRepository propertyRepository = PropertyRepositoryImpl.getRepository();

    @Override
    public Property create(Property property) {
        return propertyRepository.create(property);
    }

    @Override
    public Property read(long id) {
        return propertyRepository.read(id);
    }

    @Override
    public Property update(Property property) {
        return propertyRepository.update(property);
    }

    @Override
    public void delete(long id) {
        propertyRepository.delete(id);

    }
}
