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
public class Imprimante3dTest {
    
    public Imprimante3dTest() {
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
     * Test of create method, of class Imprimante3d.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con =  ConnexionMySQL.newConnexion();;
        String nom = "uprint2";
        Job job = Job.getByDate(con, Utils.stringToTimestamp("2019/01/17 22:00:00"));
        int id = job.getID(con);
        double nbheures = 0.0;
        String etat = "TRAVAIL";
        double dureerestante = 40.0;
        int couthoraire = 80;
        String expResult = "TRAVAIL";
        Imprimante3d result = Imprimante3d.create(con, nom, id, nbheures, etat, dureerestante, couthoraire);
        assertEquals(expResult, result.getEtat());
        result.delete(con);
    }

    /**
     * Test of delete method, of class Imprimante3d.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Imprimante3d instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Imprimante3d.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = null;
        Imprimante3d instance = null;
        instance.save(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByNom method, of class Imprimante3d.
     */
    @Test
    public void testGetByNom() throws Exception {
        System.out.println("getByNom");
        Connection con = null;
        String nom = "";
        Imprimante3d expResult = null;
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Imprimante3d.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Imprimante3d instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of getNbhdetravail method, of class Imprimante3d.
     */
    @Test
    public void testGetNbhdetravail() {
        System.out.println("getNbhdetravail");
        Imprimante3d instance = null;
        double expResult = 0.0;
        double result = instance.getNbhdetravail();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNbhdetravail method, of class Imprimante3d.
     */
    @Test
    public void testSetNbhdetravail() {
        System.out.println("setNbhdetravail");
        double nbhdetravail = 0.0;
        Imprimante3d instance = null;
        instance.setNbhdetravail(nbhdetravail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEtat method, of class Imprimante3d.
     */
    @Test
    public void testGetEtat() {
        System.out.println("getEtat");
        Imprimante3d instance = null;
        String expResult = "";
        String result = instance.getEtat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of getDureerestante method, of class Imprimante3d.
     */
    @Test
    public void testGetDureerestante() {
        System.out.println("getDureerestante");
        Imprimante3d instance = null;
        double expResult = 0.0;
        double result = instance.getDureerestante();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getCoutHoraire method, of class Imprimante3d.
     */
    @Test
    public void testGetCoutHoraire() {
        System.out.println("getCoutHoraire");
        Imprimante3d instance = null;
        int expResult = 0;
        int result = instance.getCoutHoraire();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoutHoraire method, of class Imprimante3d.
     */
    @Test
    public void testSetCoutHoraire() {
        System.out.println("setCoutHoraire");
        int CoutHoraire = 0;
        Imprimante3d instance = null;
        instance.setCoutHoraire(CoutHoraire);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
