package com.rentalproperty.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{

    private long id;
    private Date date;
    private List<OrderLine> orderLine;
    private Resident resident;

    private Order()
    {

    }
    public Order(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.orderLine = builder.orderLine;
        this.resident = builder.resident;
    }

    public static class Builder{
        private long id;
        private Date date;
        private List<OrderLine> orderLine;
        private Resident resident;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder date(Date value)
        {
            this.date = value;
            return this;
        }
        public Builder ordersLine(List<OrderLine> value)
        {
            this.orderLine = value;
            return this;
        }
        public Builder resident(Resident value)
        {
            this.resident = value;
            return this;
        }
        public Order build()
        {
            return new Order(this);
        }
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public Resident getResident() {
        return resident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
