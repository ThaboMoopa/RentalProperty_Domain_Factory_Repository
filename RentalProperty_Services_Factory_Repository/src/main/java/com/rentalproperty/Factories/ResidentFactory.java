package com.rentalproperty.Factories;

import com.rentalproperty.domain.Order;
import com.rentalproperty.domain.Resident;

import java.util.List;
import java.util.Map;

    public class ResidentFactory {
        public static Resident getResident( long id,Map<String, String> values, List<Order> order)
        {
            Resident resident = new Resident.Builder()
                    .id(id)
                    .name(values.get("name"))
                    .surname(values.get("surname"))
                    .email(values.get("email"))
                    .contact(values.get("contact"))
                    .password(values.get("password"))
                    .order(order)
                    .build();
            return resident;
        }
    }


