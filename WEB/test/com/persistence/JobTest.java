/*
 * Fichier : JobTest.java
 * Description : Classe de test de la classe Job.java en JUnit
 * Created on  : Mars 2019
 * Author      : Vraux
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
        String nom = "Piece2";
        Timestamp daterealisation = Utils.stringToTimestamp("2019/05/17 22:00:00");
        String etat = "FINI";
        int dureeconsommee = 0;
        int resteafaire = 0;
        double supportconsomme = 0.0;
        double matiereconsommee = 0.0;
        double supportestime = 0.0;
        double matiereestimee = 0.0;
        int prix = 0;
        String imprimante3dnom = "uprint1";
        String expResult = "FINI";
        Job result = Job.create(con, usercode, nom, daterealisation,
                etat, dureeconsommee, resteafaire, supportconsomme, 
                matiereconsommee, supportestime, matiereestimee, prix, imprimante3dnom);
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
        Job job1 = Job.getByDate(con, Utils.stringToTimestamp("2019/01/17 22:00:00"));
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
    public void testGetByDate() throws Exception {
        System.out.println("getByDate");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job result = Job.getByDate(con, date);
        assertEquals(date, result.getDateRealisation());
    }

    /**
     * Test of getNom method, of class Job.
     */
    @Test
    public void testGetNom()throws Exception {
        System.out.println("getNom");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        String expResult = "poignée";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDaterealisation method, of class Job.
     */
    @Test
    public void testGetDateRealisation()throws Exception {
        System.out.println("getDaterealisation");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        Timestamp expResult = date;
        Timestamp result = instance.getDateRealisation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEtat method, of class Job.
     */
    @Test
    public void testGetEtat()throws Exception {
        System.out.println("getEtat");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        String expResult = "FINI";
        String result = instance.getEtat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDureeconsommee method, of class Job.
     */
    @Test
    public void testGetDureeConsommee() throws Exception {
        System.out.println("getDureeConsommee");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        int expResult = 12000;
        int result = instance.getDureeConsommee();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getResteafaire method, of class Job.
     */
    @Test
    public void testGetResteAFaire() throws Exception {
        System.out.println("getResteAFaire");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        double expResult = 0;
        double result = instance.getResteAFaire();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getSupportconsomme method, of class Job.
     */
    @Test
    public void testGetSupportConsomme() throws Exception{
        System.out.println("getSupportConsomme");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        double expResult = 40.32;
        double result = instance.getSupportConsomme();
        assertEquals(expResult, result, 0);

    }

    /**
     * Test of getMatiereconsommee method, of class Job.
     */
    @Test
    public void testGetMatiereConsommee()throws Exception {
        System.out.println("getMatiereConsommee");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        double expResult = 12.18;
        double result = instance.getMatiereConsommee();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getSupportestime method, of class Job.
     */
    @Test
    public void testGetSupportEstime()throws Exception {
        System.out.println("getSupportEstime");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        double expResult = 0.0;
        double result = instance.getSupportEstime();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getMatiereestimee method, of class Job.
     */
    @Test
    public void testGetMatiereestimee()throws Exception {
        System.out.println("getMatiereEstimee");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        double expResult = 0.0;
        double result = instance.getMatiereEstimee();
        assertEquals(expResult, result, 0);

    }

    /**
     * Test of getPrix method, of class Job.
     */
    @Test
    public void testGetPrix()throws Exception {
        System.out.println("getPrix");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        int expResult = 14400;
        int result = instance.getPrix();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPrix method, of class Job.
     */
    @Test
    public void testSetPrix()throws Exception {
        System.out.println("setPrix");
        Connection con = ConnexionMySQL.newConnexion();
        Job instance = Job.getByDate(con, Utils.stringToTimestamp("2019/01/17 22:00:00"));
        instance.setPrix(10);
        instance.save(con);
        assertEquals(instance.getPrix(), 10);
        instance.setPrix(14400);
        instance.save(con);
    }

    /**
     * Test of getID method, of class Job.
     */
    @Test
    public void testGetID() throws Exception {
        System.out.println("getID");
        Connection con = ConnexionMySQL.newConnexion();
        Job instance = Job.getByDate(con, Utils.stringToTimestamp("2019/01/17 22:00:00"));
        int expResult = 1;
        int result = instance.getID(con);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class Job.
     */
  /*  @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Job instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
