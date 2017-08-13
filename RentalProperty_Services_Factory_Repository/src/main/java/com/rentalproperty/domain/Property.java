package com.rentalproperty.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

public class Property implements Serializable {
    private long id;
    private Address address;
    private String name;
    private List<Unit> unit;

    private Property()
    {

    }

    public Property(Builder builder) {
        this.id = builder.id;
        this.address = builder.address;
        this.name = builder.name;
        this.unit = builder.unit;
    }
    public static class Builder{
        private long id;
        private Address address;
        private String name;
        private List<Unit> unit;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder name(String value)
        {
            this.name = value;
            return this;
        }
        public Builder address(Address value)
        {
            this.address = value;
            return this;
        }
        public Builder unit(List<Unit> value)
        {
            this.unit = value;
            return this;
        }
        public Property build()
        {
            return new Property(this);
        }
    }

    public long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public List<Unit> getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        return id == property.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
