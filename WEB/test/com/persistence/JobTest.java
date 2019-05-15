/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        Timestamp daterealisation = Utils.stringToTimestamp("2019/05/17 22:00:00");
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
        assertEquals(date, result.getDaterealisation());
    }

    /**
     * Test of getNom method, of class Job.
     */
    @Test
    public void testGetNom() throws Exception {
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
    public void testGetDaterealisation() throws Exception {
        System.out.println("getDaterealisation");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        Timestamp expResult = date;
        Timestamp result = instance.getDaterealisation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEtat method, of class Job.
     */
    @Test
    public void testGetEtat() throws Exception {
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
    public void testGetDureeconsommee() throws Exception {
        System.out.println("getDureeconsommee");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        double expResult = 18.0;
        double result = instance.getDureeconsommee();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getResteafaire method, of class Job.
     */
    @Test
    public void testGetResteafaire() throws Exception {
        System.out.println("getResteafaire");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        double expResult = 0.0;
        double result = instance.getResteafaire();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSupportconsomme method, of class Job.
     */
    @Test
    public void testGetSupportconsomme() throws Exception {
        System.out.println("getSupportconsomme");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        int expResult = 40;
        int result = instance.getSupportconsomme();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMatiereconsommee method, of class Job.
     */
    @Test
    public void testGetMatiereconsommee() throws Exception {
        System.out.println("getMatiereconsommee");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        int expResult = 12;
        int result = instance.getMatiereconsommee();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSupportestime method, of class Job.
     */
    @Test
    public void testGetSupportestime() throws Exception {
        System.out.println("getSupportestime");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        int expResult = 0;
        int result = instance.getSupportestime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMatiereestimee method, of class Job.
     */
    @Test
    public void testGetMatiereestimee() throws Exception {
        System.out.println("getMatiereestimee");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/01/17 22:00:00");
        Job instance = Job.getByDate(con, date);
        int expResult = 0;
        int result = instance.getMatiereestimee();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPrix method, of class Job.
     */
    @Test
    public void testGetPrix() throws Exception {
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
    public void testSetPrix() throws Exception {
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
     * Test of getListeDesJobs method, of class Job.
     */
    @Test
    public void testGetListeDesJobs() throws Exception {
        System.out.println("getListeDesJobs");
        Connection con = null;
        ArrayList<Job> expResult = null;
        ArrayList<Job> result = Job.getListeDesJobs(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
