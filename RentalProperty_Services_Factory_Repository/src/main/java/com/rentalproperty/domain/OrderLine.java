package com.rentalproperty.domain;

import java.io.Serializable;

public class OrderLine implements Serializable {

    private long id;
    private int quantity;
    private double price;
    private Property property;
    private Order order;

    private OrderLine()
    {

    }

    public OrderLine(Builder builder) {
        this.id = builder.id;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.property = builder.property;
        this.order = builder.order;
    }
    public static class Builder{
        private long id;
        private int quantity;
        private double price;
        private Property property;
        private Order order;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder quantity(int value)
        {
            this.quantity = value;
            return this;
        }
        public Builder price(double value)
        {
            this.price = value;
            return this;
        }
        public Builder property(Property value)
        {
            this.property = value;
            return this;
        }
        public Builder order(Order value)
        {
            this.order = value;
            return this;
        }
        public OrderLine build()
        {
            return new OrderLine(this);
        }
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Property getProperty() {
        return property;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLine that = (OrderLine) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
