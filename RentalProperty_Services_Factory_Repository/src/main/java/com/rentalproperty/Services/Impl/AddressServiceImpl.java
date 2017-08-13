package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.AddressRepository;
import com.rentalproperty.Repositories.Impl.AddressRepositoryImpl;
import com.rentalproperty.Services.AddressService;
import com.rentalproperty.domain.Address;

public class AddressServiceImpl implements AddressService {

    AddressRepository repository = AddressRepositoryImpl.getRepository();

    @Override
    public Address create(Address address) {
        return repository.create(address);
    }

    @Override
    public Address read(long id) {
        return repository.read(id);
    }

    @Override
    public Address update(Address address) {
        return repository.update(address);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
