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
public class OperateurTest {
    
    public OperateurTest() {
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
     * Test of create method, of class Operateur.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = null;
        int ID = 0;
        String fabnom = "";
        String nom = "";
        String prenom = "";
        String mdp = "";
        String mail = "";
        Operateur expResult = null;
        Operateur result = Operateur.create(con, ID, fabnom, nom, prenom, mdp, mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Operateur.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Operateur instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Operateur.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = null;
        Operateur instance = null;
        instance.save(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByMail method, of class Operateur.
     */
    @Test
    public void testGetByMail() throws Exception {
        System.out.println("getByMail");
        Connection con = null;
        String mail = "";
        Operateur expResult = null;
        Operateur result = Operateur.getByMail(con, mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Operateur.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Operateur instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNom method, of class Operateur.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "";
        Operateur instance = null;
        instance.setNom(nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrenom method, of class Operateur.
     */
    @Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        Operateur instance = null;
        String expResult = "";
        String result = instance.getPrenom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrenom method, of class Operateur.
     */
    @Test
    public void testSetPrenom() {
        System.out.println("setPrenom");
        String prenom = "";
        Operateur instance = null;
        instance.setPrenom(prenom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMdp method, of class Operateur.
     */
    @Test
    public void testGetMdp() {
        System.out.println("getMdp");
        Operateur instance = null;
        String expResult = "";
        String result = instance.getMdp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMdp method, of class Operateur.
     */
    @Test
    public void testSetMdp() {
        System.out.println("setMdp");
        String mdp = "";
        Operateur instance = null;
        instance.setMdp(mdp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class Operateur.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        Operateur instance = null;
        String expResult = "";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMail method, of class Operateur.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "";
        Operateur instance = null;
        instance.setMail(mail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
