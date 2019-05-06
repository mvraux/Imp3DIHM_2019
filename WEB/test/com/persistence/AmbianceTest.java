/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import java.sql.Timestamp;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author snir2g2
 */
public class AmbianceTest {
    
    public AmbianceTest() {
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
     * Test of create method, of class Ambiance.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = null;
        int ID = 0;
        String fabnom = "";
        double temperature = 0.0;
        double humidite = 0.0;
        Timestamp date = null;
        Ambiance expResult = null;
        Ambiance result = Ambiance.create(con, ID, fabnom, temperature, humidite, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Ambiance.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Ambiance instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Ambiance.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = null;
        Ambiance instance = null;
        instance.save(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByDate method, of class Ambiance.
     */
    @Test
    public void testGetByDate() throws Exception {
        System.out.println("getByDate");
        Connection con = null;
        Timestamp date = null;
        Ambiance expResult = null;
        Ambiance result = Ambiance.getByDate(con, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemperature method, of class Ambiance.
     */
    @Test
    public void testGetTemperature() {
        System.out.println("getTemperature");
        Ambiance instance = null;
        double expResult = 0.0;
        double result = instance.getTemperature();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHumidite method, of class Ambiance.
     */
    @Test
    public void testGetHumidite() {
        System.out.println("getHumidite");
        Ambiance instance = null;
        double expResult = 0.0;
        double result = instance.getHumidite();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Ambiance.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Ambiance instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
