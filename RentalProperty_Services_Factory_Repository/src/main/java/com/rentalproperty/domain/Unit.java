package com.rentalproperty.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Unit implements Serializable {

    private long id;
    private int rooms;
    private int unitNo;
    private String unitType;
    private double price;

   private Bathroom bathroom;
   private Parking parking;


   private Unit()
   {

   }

    public Unit(Builder builder) {
        this.id = builder.id;
        this.rooms = builder.rooms;
        this.unitNo = builder.unitNo;
        this.unitType = builder.unitType;
        this.price = builder.price;
        this.bathroom = builder.bathroom;
        this.parking = builder.parking;

    }
    public static class Builder{
        private long id;
        private int rooms;
        private int unitNo;
        private String unitType;
        private double price;

        private Bathroom bathroom;
        private Parking parking;


        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder rooms(int value)
        {
            this.rooms = value;
            return this;
        }
        public Builder unitNo(int value)
        {
            this.unitNo = value;
            return this;
        }
        public Builder unitType(String value)
        {
            this.unitType = value;
            return this;
        }
        public Builder price(double value)
        {
            this.price = value;
            return this;
        }
        public Builder bathroom(Bathroom value)
        {
            this.bathroom = value;
            return this;
        }
        public Builder parking(Parking value)
        {
            this.parking = value;
            return this;
        }

        public Unit build()
        {
            return new Unit(this);
        }
    }

    public long getId() {
        return id;
    }

    public int getRooms() {
        return rooms;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public String getUnitType() {
        return unitType;
    }

    public double getPrice() {
        return price;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public Parking getParking() {
        return parking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        return id == unit.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

