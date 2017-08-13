package com.rentalproperty.domain;

import java.io.Serializable;
import java.util.List;

public class Resident implements Serializable {

    private long id;
    private String name;
    private String surname;
    private String email;
    private String contact;
    private String password;

    public List<Order> getOrder() {
        return order;
    }

    private List<Order> order;

    private Resident() {

    }

    public Resident(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.contact = builder.contact;
        this.password = builder.password;
        this.order = builder.order;
    }


    public static class Builder {
        long id;
        private String name;
        private String surname;
        private String email;
        private String contact;
        private String password;
        private List<Order> order;

        public Builder order(List<Order> value)
        {
            this.order = value;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder surname(String value) {
            this.surname = value;
            return this;
        }

        public Builder email(String value) {
            this.email = value;
            return this;
        }

        public Builder contact(String value) {
            this.contact = value;
            return this;
        }

        public Builder password(String value) {
            this.password = value;
            return this;
        }

        public Resident build() {
            return new Resident(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resident resident = (Resident) o;

        return id == resident.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}



