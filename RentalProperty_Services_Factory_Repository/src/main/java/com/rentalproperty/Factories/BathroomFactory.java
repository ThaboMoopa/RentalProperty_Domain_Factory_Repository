package com.rentalproperty.Factories;

import com.rentalproperty.domain.Bathroom;

public class BathroomFactory {
    public static Bathroom getBathroom (long id, String bathroomType)
    {
        Bathroom bathroom = new Bathroom.Builder()
                .id(id)
                .bathroomType(bathroomType)
                .build();
        return bathroom;
    }
}
