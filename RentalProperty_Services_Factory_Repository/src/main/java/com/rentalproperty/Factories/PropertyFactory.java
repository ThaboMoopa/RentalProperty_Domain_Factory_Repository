package com.rentalproperty.Factories;

import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Property;
import com.rentalproperty.domain.Unit;

import java.util.List;

public class PropertyFactory {
    public static Property getProperty(long id, Address address, String name, List<Unit> unit)
    {
        Property property = new Property.Builder()
                .id(id)
                .address(address)
                .unit(unit)
                .build();
        return property;
    }
}
