package com.rentalproperty.Repositories;

import com.rentalproperty.Factories.BathroomFactory;
import com.rentalproperty.Repositories.Impl.BathroomRepositoryImpl;
import com.rentalproperty.domain.Bathroom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BathroomRepositoryTest {

    //bathroom information
    Bathroom bathroom;
    BathroomRepository bathroomRepository;
    long bathroomId;
    String bathroomType;


    @BeforeMethod
    public void setUp() throws Exception {
        //bathroom information
        bathroomId = 1;
        bathroomType = "shower only";
        bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);
        bathroomRepository = BathroomRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        bathroom = bathroomRepository.create(bathroom);
        assertEquals("shower only", bathroom.getBathroomType());
    }

    @Test(dependsOnMethods = ("testCreate"))
    public void testRead() throws Exception {
         bathroom = bathroomRepository.read(1);
        assertEquals(1, bathroom.getId());

    }

    @Test(dependsOnMethods = {"testRead", "testCreate"})
    public void testUpdate() throws Exception {
        bathroom = bathroomRepository.read(1);
        Bathroom updateBathroom = new Bathroom.Builder()
                .id(bathroomId)
                .bathroomType("Shower and Bath")
                .build();
        bathroomRepository.update(updateBathroom);
        bathroom = bathroomRepository.read(1);
        assertEquals("Shower and Bath", bathroom.getBathroomType());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        bathroomRepository.delete(1);
        Bathroom bathroom = bathroomRepository.read(1);
        assertNull(bathroom);
    }

}