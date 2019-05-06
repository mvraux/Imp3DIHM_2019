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
public class CartoucheTest {
    
    public CartoucheTest() {
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
     * Test of create method, of class Cartouche.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = null;
        int ID = 0;
        String imp3dnom = "";
        Timestamp dateremplacement = null;
        Timestamp datefabrication = null;
        String numerodeserie = "";
        int quantiterestante = 0;
        int coutaumetre = 0;
        Cartouche expResult = null;
        Cartouche result = Cartouche.create(con, ID, imp3dnom, dateremplacement, datefabrication, numerodeserie, quantiterestante, coutaumetre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Cartouche.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Cartouche instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Cartouche.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = null;
        Cartouche instance = null;
        instance.save(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByNumero method, of class Cartouche.
     */
    @Test
    public void testGetByNumero() throws Exception {
        System.out.println("getByNumero");
        Connection con = null;
        String numerodeserie = "";
        Cartouche expResult = null;
        Cartouche result = Cartouche.getByNumero(con, numerodeserie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateremplacement method, of class Cartouche.
     */
    @Test
    public void testGetDateremplacement() {
        System.out.println("getDateremplacement");
        Cartouche instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDateremplacement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatefabrication method, of class Cartouche.
     */
    @Test
    public void testGetDatefabrication() {
        System.out.println("getDatefabrication");
        Cartouche instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDatefabrication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumerodeserie method, of class Cartouche.
     */
    @Test
    public void testGetNumerodeserie() {
        System.out.println("getNumerodeserie");
        Cartouche instance = null;
        String expResult = "";
        String result = instance.getNumerodeserie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getQuantiterestante method, of class Cartouche.
     */
    @Test
    public void testGetQuantiterestante() {
        System.out.println("getQuantiterestante");
        Cartouche instance = null;
        int expResult = 0;
        int result = instance.getQuantiterestante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getCoutaumetre method, of class Cartouche.
     */
    @Test
    public void testGetCoutaumetre() {
        System.out.println("getCoutaumetre");
        Cartouche instance = null;
        int expResult = 0;
        int result = instance.getCoutaumetre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoutaumetre method, of class Cartouche.
     */
    @Test
    public void testSetCoutaumetre() {
        System.out.println("setCoutaumetre");
        int coutaumetre = 0;
        Cartouche instance = null;
        instance.setCoutaumetre(coutaumetre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
