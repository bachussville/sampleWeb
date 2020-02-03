/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.persistence;

import com.bville.sampleproj.objectmapping.BasicJsonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bart
 */
public class FloraDtoTest {
    
    public FloraDtoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of setCanStandTheHeat method, of class FloraDto.
     */
    @Test
    public void testMapping() {
        BasicJsonMapper mapper = new BasicJsonMapper();
        
        
        System.out.println("setCanStandTheHeat");
        Boolean canStandTheHeat = null;
        FloraDto instance = new FloraDto();
        instance.setCanStandTheHeat(canStandTheHeat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
