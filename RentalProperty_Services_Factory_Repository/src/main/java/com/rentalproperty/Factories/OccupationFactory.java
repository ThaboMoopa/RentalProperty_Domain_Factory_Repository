package com.rentalproperty.Factories;

import com.rentalproperty.domain.Occupation;
import com.rentalproperty.domain.Unit;

import java.util.Date;
import java.util.Map;

public class OccupationFactory {
    public static Occupation getOccupation(long id, Unit unit, Date startDate, Date endDate)
    {
        Occupation occupation = new Occupation.Builder()
                .id(id)
                .unit(unit)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        return occupation;
    }
}
