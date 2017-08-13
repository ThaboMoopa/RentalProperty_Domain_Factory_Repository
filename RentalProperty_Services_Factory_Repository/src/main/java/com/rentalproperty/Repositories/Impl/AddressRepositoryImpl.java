package com.rentalproperty.Repositories.Impl;

import com.rentalproperty.Repositories.AddressRepository;
import com.rentalproperty.domain.Address;

import java.util.HashMap;
import java.util.Map;

public class AddressRepositoryImpl implements AddressRepository {

    private static AddressRepositoryImpl repository = null;

    private Map<Long, Address> addressTable;

    private AddressRepositoryImpl()
    {
        addressTable = new HashMap<Long, Address>();
    }

    public static AddressRepositoryImpl getRepository()
    {
        if(repository == null)
        {
            repository = new AddressRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Address create(Address address) {
        addressTable.put(address.getId(), address);
        Address saveResident = addressTable.get(address.getId());
        return saveResident;
    }

    @Override
    public Address read(long id) {
        Address address = addressTable.get(id);
        return address;
    }

    @Override
    public Address update(Address address) {
        addressTable.put(address.getId(), address);
        Address updateAddress = addressTable.get(address.getId());
        return updateAddress;
    }

    @Override
    public void delete(long id) {
        addressTable.remove(id);
    }
}
