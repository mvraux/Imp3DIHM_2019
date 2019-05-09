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
public class JobTest {
    
    public JobTest() {
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
     * Test of create method, of class Job.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = ConnexionMySQL.newConnexion();
        String usercode = "SDQ5S7GFS98S";
        String nom = "Pieceqq";
        Timestamp daterealisation =  new Timestamp(System.currentTimeMillis());
        String etat = "FINI";
        double dureeconsommee = 0.0;
        double resteafaire = 0.0;
        int supportconsomme = 0;
        int matiereconsommee = 0;
        int supportestime = 0;
        int matiereestimee = 0;
        int prix = 0;
        String expResult = "FINI";
        Job result = Job.create(con, usercode, nom, daterealisation,
                etat, dureeconsommee, resteafaire, supportconsomme, 
                matiereconsommee, supportestime, matiereestimee, prix);
        assertEquals(expResult, result.getEtat());
        result.delete(con);
    }

    /**
     * Test of delete method, of class Job.
     *
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Job instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of save method, of class Job.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        Job job1 = Job.getByNom(con, "poignée");
        job1.setPrix(20);
        job1.save(con);
        assertEquals(20, job1.getPrix());
        job1.setPrix(14400);
        job1.save(con);
    }

    /**
     * Test of getByNom method, of class Job.
     */
    @Test
    public void testGetByNom() throws Exception {
        System.out.println("getByNom");
        Connection con = null;
        String nom = "";
        Job expResult = null;
        Job result = Job.getByNom(con, nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Job.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Job instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaterealisation method, of class Job.
     */
    @Test
    public void testGetDaterealisation() {
        System.out.println("getDaterealisation");
        Job instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDaterealisation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDaterealisation method, of class Job.
     */
    @Test
    public void testSetDaterealisation() {
        System.out.println("setDaterealisation");
        Timestamp daterealisation = null;
        Job instance = null;
        instance.setDaterealisation(daterealisation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEtat method, of class Job.
     */
    @Test
    public void testGetEtat() {
        System.out.println("getEtat");
        Job instance = null;
        String expResult = "";
        String result = instance.getEtat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDureeconsommee method, of class Job.
     */
    @Test
    public void testGetDureeconsommee() {
        System.out.println("getDureeconsommee");
        Job instance = null;
        double expResult = 0.0;
        double result = instance.getDureeconsommee();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResteafaire method, of class Job.
     */
    @Test
    public void testGetResteafaire() {
        System.out.println("getResteafaire");
        Job instance = null;
        double expResult = 0.0;
        double result = instance.getResteafaire();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupportconsomme method, of class Job.
     */
    @Test
    public void testGetSupportconsomme() {
        System.out.println("getSupportconsomme");
        Job instance = null;
        int expResult = 0;
        int result = instance.getSupportconsomme();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatiereconsommee method, of class Job.
     */
    @Test
    public void testGetMatiereconsommee() {
        System.out.println("getMatiereconsommee");
        Job instance = null;
        int expResult = 0;
        int result = instance.getMatiereconsommee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupportestime method, of class Job.
     */
    @Test
    public void testGetSupportestime() {
        System.out.println("getSupportestime");
        Job instance = null;
        int expResult = 0;
        int result = instance.getSupportestime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatiereestimee method, of class Job.
     */
    @Test
    public void testGetMatiereestimee() {
        System.out.println("getMatiereestimee");
        Job instance = null;
        int expResult = 0;
        int result = instance.getMatiereestimee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrix method, of class Job.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        Job instance = null;
        int expResult = 0;
        int result = instance.getPrix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrix method, of class Job.
     */
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        int prix = 0;
        Job instance = null;
        instance.setPrix(prix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
