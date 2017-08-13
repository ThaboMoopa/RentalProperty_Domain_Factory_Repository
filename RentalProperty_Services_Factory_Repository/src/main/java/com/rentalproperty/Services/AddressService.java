package com.rentalproperty.Services;

import com.rentalproperty.domain.Address;

public interface AddressService {
    Address create(Address address);
    Address read(long id);
    Address update(Address address);
    void delete(long id);
}
