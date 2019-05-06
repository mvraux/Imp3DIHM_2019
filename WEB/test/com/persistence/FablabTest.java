/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
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
public class FablabTest {
    
    public FablabTest() {
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
     * Test of create method, of class Fablab.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = null;
        String nom = "";
        String imp3dnom = "";
        double mintemp = 0.0;
        double maxtemp = 0.0;
        double minhumidite = 0.0;
        double maxhumidite = 0.0;
        Fablab expResult = null;
        Fablab result = Fablab.create(con, nom, imp3dnom, mintemp, maxtemp, minhumidite, maxhumidite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Fablab.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Fablab instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Fablab.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = null;
        Fablab instance = null;
        instance.save(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByNom method, of class Fablab.
     */
    @Test
    public void testGetByNom() throws Exception {
        System.out.println("getByNom");
        Connection con = null;
        String nom = "";
        Fablab expResult = null;
        Fablab result = Fablab.getByNom(con, nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Fablab.
     */
    @Test
    public void testGetNom() throws Exception {
        System.out.println("getNom");
        Connection con = null;
        Fablab instance = null;
        String expResult = "";
        String result = instance.getNom(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of getMintemp method, of class Fablab.
     */
    @Test
    public void testGetMintemp() {
        System.out.println("getMintemp");
        Fablab instance = null;
        double expResult = 0.0;
        double result = instance.getMintemp();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getMaxtemp method, of class Fablab.
     */
    @Test
    public void testGetMaxtemp() {
        System.out.println("getMaxtemp");
        Fablab instance = null;
        double expResult = 0.0;
        double result = instance.getMaxtemp();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getMinhumidite method, of class Fablab.
     */
    @Test
    public void testGetMinhumidite() {
        System.out.println("getMinhumidite");
        Fablab instance = null;
        double expResult = 0.0;
        double result = instance.getMinhumidite();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getMaxhumidite method, of class Fablab.
     */
    @Test
    public void testGetMaxhumidite() {
        System.out.println("getMaxhumidite");
        Fablab instance = null;
        double expResult = 0.0;
        double result = instance.getMaxhumidite();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
