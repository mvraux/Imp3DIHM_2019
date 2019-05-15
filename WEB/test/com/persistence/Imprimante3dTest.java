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
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint2";
        Job job = Job.getByDate(con, Utils.stringToTimestamp("2019/04/04 00:00:00"));
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
     *
     * @Test public void testDelete() throws Exception {
     * System.out.println("delete"); Connection con = null; Imprimante3d
     * instance = null; boolean expResult = false; boolean result =
     * instance.delete(con); assertEquals(expResult, result); // TODO review the
     * generated test code and remove the default call to fail. fail("The test
     * case is a prototype."); }
     */
    /**
     * Test of save method, of class Imprimante3d.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        int expResult = 4785;
        Imprimante3d result = Imprimante3d.getByNom(con, "uprint1");
        result.setCoutHoraire(4785);
        result.save(con);
        assertEquals(expResult, result.getCoutHoraire());
        result.setCoutHoraire(800);
        result.save(con);
    }

    /**
     * Test of getByNom method, of class Imprimante3d.
     */
    @Test
    public void testGetByNom() throws Exception {
        System.out.println("getByNom");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        String expResult = "REPOS";
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getEtat());
    }

    /**
     * Test of getNom method, of class Imprimante3d.
     */
    @Test
    public void testGetNom() throws Exception {
        System.out.println("getNom");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        String expResult = "uprint1";
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getNom());
    }

    /**
     * Test of getNbhdetravail method, of class Imprimante3d.
     */
    @Test
    public void testGetNbhdetravail() throws Exception  {
        System.out.println("getNbhdetravail");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        double expResult = 1500;
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getNbhdetravail(),0);

    }

    /**
     * Test of setNbhdetravail method, of class Imprimante3d.
     */
    @Test
    public void testSetNbhdetravail() throws Exception  {
        System.out.println("setNbhdetravail");
        Connection con = ConnexionMySQL.newConnexion();
        Imprimante3d instance = Imprimante3d.getByNom(con, "uprint1");
        instance.setNbhdetravail(18);
        instance.save(con);
        assertEquals(18, instance.getNbhdetravail(),0);
        instance.setNbhdetravail(1500);
        instance.save(con);
    }

    /**
     * Test of getEtat method, of class Imprimante3d.
     */
    @Test
    public void testGetEtat()throws Exception  {
        System.out.println("getEtat");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        String expResult = "REPOS";
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getEtat());
    }

    /**
     * Test of getDureerestante method, of class Imprimante3d.
     */
    @Test
    public void testGetDureerestante()throws Exception {
        System.out.println("getDureerestante");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        double expResult = 22;
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getDureerestante(),0);
    }

    /**
     * Test of getCoutHoraire method, of class Imprimante3d.
     */
    @Test
    public void testGetCoutHoraire()throws Exception {
        System.out.println("getCoutHoraire");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        int expResult = 800;
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getCoutHoraire(),0);
    }

    /**
     * Test of setCoutHoraire method, of class Imprimante3d.
     */
    @Test
    public void testSetCoutHoraire() throws Exception{
        System.out.println("setCoutHoraire");
        Connection con = ConnexionMySQL.newConnexion();
        Imprimante3d instance = Imprimante3d.getByNom(con, "uprint1");
        instance.setCoutHoraire(18);
        instance.save(con);
        assertEquals(18, instance.getCoutHoraire());
        instance.setCoutHoraire(800);
        instance.save(con);
    }

}
