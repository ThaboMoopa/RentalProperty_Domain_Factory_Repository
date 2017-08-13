package com.rentalproperty.Factories;

import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Property;

import java.util.Map;

public class AddressFactory {
    public static Address getAddress(long id, Map<String, String> addressValues)
    {
        Address address = new Address.Builder()
                .id(id)
                .street(addressValues.get("street"))
                .city(addressValues.get("city"))
                .province(addressValues.get("province"))
                .postalCode(addressValues.get("postalCode"))
                .build();
        return address;
    }
}
