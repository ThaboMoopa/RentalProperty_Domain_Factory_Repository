package com.rentalproperty.Services;

import com.rentalproperty.Factories.BathroomFactory;
import com.rentalproperty.Repositories.BathroomRepository;
import com.rentalproperty.Repositories.Impl.BathroomRepositoryImpl;
import com.rentalproperty.Services.Impl.BathroomServiceImpl;
import com.rentalproperty.domain.Bathroom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BathroomServiceTest {

    //bathroom information
    Bathroom bathroom;
    BathroomService bathroomService;
    long bathroomId;
    String bathroomType;

    @BeforeMethod
    public void setUp() throws Exception {
        //bathroom information
        bathroomId = 1;
        bathroomType = "shower only";
        bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);
        bathroomService = new BathroomServiceImpl();
    }

    @Test
    public void testCreate() throws Exception {
        bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);
        bathroomService.create(bathroom);
        assertEquals("shower only", bathroom.getBathroomType());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        bathroomService.read(1);
        assertEquals("shower only", bathroom.getBathroomType());
    }

    @Test(dependsOnMethods = {"testRead", "testCreate"})
    public void testUpdate() throws Exception {
        bathroomService.read(1);
        Bathroom updateBathroom = new Bathroom.Builder()
                .id(bathroomId)
                .bathroomType("shower and bath")
                .build();
        bathroomService.update(updateBathroom);
        bathroom = bathroomService.read(1);
        assertEquals("shower and bath", bathroom.getBathroomType());
    }


    @Test(dependsOnMethods = {"testRead", "testCreate"})
    public void testDelete() throws Exception {
        bathroomService.delete(1);
        bathroom = bathroomService.read(1);
        assertNull(bathroom);
    }

}