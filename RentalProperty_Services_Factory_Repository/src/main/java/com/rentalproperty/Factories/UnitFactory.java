package com.rentalproperty.Factories;

import com.rentalproperty.domain.Bathroom;
import com.rentalproperty.domain.Parking;
import com.rentalproperty.domain.Property;
import com.rentalproperty.domain.Unit;

import java.util.Map;

public class UnitFactory {
    public static Unit getUnit(long id, Map<String, Integer> values, String unitType, double price, Bathroom bathroom, Parking parking)
    {
        Unit unit = new Unit.Builder()
                .id(id)
                .unitNo(values.get("rooms"))
                .rooms(values.get("unitNo"))
                .unitType(unitType)
                .price(price)
                .bathroom(bathroom)
                .parking(parking)
                .build();
        return unit;
    }
}
