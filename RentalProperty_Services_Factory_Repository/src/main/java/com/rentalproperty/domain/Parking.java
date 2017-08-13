package com.rentalproperty.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Parking implements Serializable {

    private long id;
    private int parkingNumber;
    private double price;

    private Parking()
    {

    }

    public Parking(Builder builder) {
        this.id = builder.id;
        this.parkingNumber = builder.parkingNumber;
        this.price = builder.price;
    }
    public static class Builder{
        private long id;
        private int parkingNumber;
        private double price;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder parkingNumber(int value)
        {
            this.parkingNumber = value;
            return this;
        }
        public Builder price(double value)
        {
            this.price = value;
            return this;
        }
        public Parking build()
        {
            return new Parking(this);
        }

    }

    public long getId() {
        return id;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parking parking = (Parking) o;

        return id == parking.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
