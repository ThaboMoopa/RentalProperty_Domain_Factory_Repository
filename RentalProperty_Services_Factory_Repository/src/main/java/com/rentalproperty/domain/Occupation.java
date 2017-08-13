package com.rentalproperty.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Occupation implements Serializable {


        private long id;
        private Unit unit;
        private Date startDate;
        private Date endDate;

        private Occupation()
        {

        }

    public Occupation(Builder builder) {
        this.id = builder.id;
        this.unit = builder.unit;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }
    public static class Builder{
        private long id;
        private Unit unit;
        private Date startDate;
        private Date endDate;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder unit(Unit value)
        {
            this.unit = value;
            return this;
        }
        public Builder startDate(Date value)
        {
            this.startDate = value;
            return this;
        }
        public Builder endDate(Date value)
        {
            this.endDate = value;
            return this;

        }
        public Occupation build()
        {
            return new Occupation(this);
        }
    }

    public long getId() {
        return id;
    }

    public Unit getUnit() {
        return unit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Occupation that = (Occupation) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
