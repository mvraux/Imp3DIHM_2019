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
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "fabtest";
        String imp3dnom = "uprint1";
        double mintemp = 0.0;
        double maxtemp = 100.0;
        double minhumidite = 0.0;
        double maxhumidite = 100.0;
        String expResult = "fabtest";
        Fablab result = Fablab.create(con, nom, imp3dnom, mintemp, maxtemp, minhumidite, maxhumidite);
        assertEquals(expResult, result.getNom(con));
        result.delete(con);
    }

    /**
     * Test of delete method, of class Fablab.
     *
     * @Test public void testDelete() throws Exception {
     * System.out.println("delete"); Connection con = null; Fablab instance =
     * null; boolean expResult = false; boolean result = instance.delete(con);
     * assertEquals(expResult, result); // TODO review the generated test code
     * and remove the default call to fail. fail("The test case is a
     * prototype."); }
     */
    /**
     * Test of save method, of class Fablab.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "fabtest";
        String imp3dnom = "uprint1";
        double temp = 26.8;
        double hum = 45.9;
        double maxtemp = 53.8;
        double maxhum = 96.9;
        Fablab instance = Fablab.create(con, nom, imp3dnom, temp, maxtemp,hum, maxhum);
        instance.save(con);
        assertEquals(53.8, instance.getMaxtemp(), 0.01);
        instance.delete(con);
    }

    /**
     * Test of getByNom method, of class Fablab.
     */
    @Test
    public void testGetByNom() throws Exception {
        System.out.println("getByNom");
        Connection con = ConnexionMySQL.newConnexion();
        String mail = "FabLab_Victor_Hugo";
        Fablab result = Fablab.getByNom(con, mail);
        assertEquals("FabLab_Victor_Hugo", result.getNom(con));
    }

    /**
     * Test of getNom method, of class Fablab.
     */
    @Test
    public void testGetNom() throws Exception {
        System.out.println("getNom");
        Connection con = ConnexionMySQL.newConnexion();
        Fablab instance = Fablab.getByNom(con, "FabLab_Victor_Hugo");
        assertEquals(35, instance.getMaxtemp(),0);
    }

    /**
     * Test of getMintemp method, of class Fablab.
     */
    @Test
    public void testGetMintemp()  throws Exception {
        System.out.println("getMintemp");
        Connection con = ConnexionMySQL.newConnexion();
        Fablab instance = Fablab.getByNom(con, "FabLab_Victor_Hugo");
        double expResult = 15.0;
        double result = instance.getMintemp();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaxtemp method, of class Fablab.
     */
    @Test
    public void testGetMaxtemp() throws Exception {
        System.out.println("getMaxtemp");
        Connection con = ConnexionMySQL.newConnexion();
        Fablab instance = Fablab.getByNom(con, "FabLab_Victor_Hugo");
        double expResult = 35.0;
        double result = instance.getMaxtemp();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMinhumidite method, of class Fablab.
     */
    @Test
    public void testGetMinhumidite() throws Exception {
        System.out.println("getMinhumidite");
        Connection con = ConnexionMySQL.newConnexion();
        Fablab instance = Fablab.getByNom(con, "FabLab_Victor_Hugo");
        double expResult = 30.0;
        double result = instance.getMinhumidite();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaxhumidite method, of class Fablab.
     */
    @Test
    public void testGetMaxhumidite()throws Exception  {
        System.out.println("getMaxhumidite");
        Connection con = ConnexionMySQL.newConnexion();
        Fablab instance = Fablab.getByNom(con, "FabLab_Victor_Hugo");
        double expResult = 70.0;
        double result = instance.getMaxhumidite();
        assertEquals(expResult, result, 0.0);
    }

}
