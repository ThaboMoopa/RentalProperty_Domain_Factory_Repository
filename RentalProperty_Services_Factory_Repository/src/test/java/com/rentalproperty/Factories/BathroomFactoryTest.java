package com.rentalproperty.Factories;

import com.rentalproperty.domain.Bathroom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BathroomFactoryTest {

    //bathroom information
    Bathroom bathroom;
    long bathroomId;
    String bathroomType;

    @BeforeMethod
    public void setUp() throws Exception {
        //bathroom information
        bathroomId = 1;
        bathroomType = "shower only";
        bathroom = BathroomFactory.getBathroom(bathroomId, bathroomType);
    }

    @Test
    public void testGetBathroom() throws Exception {
        assertEquals(true, bathroom.equals(bathroom));
    }

}