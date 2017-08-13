package com.rentalproperty.Services;

import com.rentalproperty.Factories.UnitFactory;
import com.rentalproperty.Repositories.Impl.UnitRepositoryImpl;
import com.rentalproperty.Repositories.UnitRepository;
import com.rentalproperty.Services.Impl.UnitServiceImpl;
import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Bathroom;
import com.rentalproperty.domain.Parking;
import com.rentalproperty.domain.Unit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class UnitServiceTest {

    Unit unit;
    Map<String, Integer> unitValues;
    UnitService unitService;
    long unitId;
    String unitType;
    double unitPrice;
    //Bathroom information
    Bathroom bathroom;

    //Parking information
    Parking parking;

    //Address address
    Address address;
    Map<String, String> addressValues;

    @BeforeMethod
    public void setUp() throws Exception {
        //unit information
        unitId = 1;
        unitType = "Bachelor";
        unitPrice = 5000;
        unitValues = new HashMap<String, Integer>();
        unitValues.put("rooms", 2);
        unitValues.put("unitNo", 24);
        unit = UnitFactory.getUnit(unitId,unitValues,unitType,unitPrice,bathroom,parking);
        unitService = new UnitServiceImpl();

    }

    @Test
    public void testCreate() throws Exception {
        unitService.create(unit);
        assertEquals("Bachelor", unit.getUnitType());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        unitService.create(unit);
        assertEquals("Bachelor", unit.getUnitType());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testUpdate() throws Exception {
        unit = unitService.read(1);
        Unit updateResident = new Unit.Builder()
                .id(unitId)
                .price(4500)
                .rooms(unitValues.get("rooms"))
                .unitNo(unitValues.get("unitNo"))
                .build();
        unitService.update(updateResident);
        unit = unitService.read(1);
        assertEquals(4500.00, unit.getPrice());
    }

    @Test(dependsOnMethods = {"testCreate","testRead"})
    public void testDelete() throws Exception {
        unitService.delete(1);
        unit = unitService.read(1);
        assertNull(unit);
    }
}

