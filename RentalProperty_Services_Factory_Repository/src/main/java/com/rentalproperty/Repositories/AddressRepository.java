package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Address;

public interface AddressRepository {
    Address create(Address address);
    Address read(long id);
    Address update(Address address);
    void delete(long id);
}
