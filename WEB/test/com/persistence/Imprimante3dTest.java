/*
 * Fichier : Imprimante3dTest.java
 * Description : Classe de test de la classe Imprimante3d.java en JUnit
 * Created on  : Mars 2019
 * Author      : Vraux
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
        String fablabnom = "FabLab_Victor_Hugo";
        double nbheures = 0.0;
        int couthoraire = 80;
        String expResult = "uprint2";
        Imprimante3d result = Imprimante3d.create(con, nom, fablabnom, nbheures, couthoraire);
        assertEquals(expResult, result.getNom());
        result.delete(con);
    }
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
        String expResult = "uprint1";
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getNom());
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
    public void testGetNbhdetravail() throws Exception {
        System.out.println("getNbhdetravail");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        double expResult = 1500;
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getNbHrDeTravail(), 0);

    }

    /**
     * Test of setNbhdetravail method, of class Imprimante3d.
     */
    @Test
    public void testSetNbhdetravail() throws Exception {
        System.out.println("setNbhdetravail");
        Connection con = ConnexionMySQL.newConnexion();
        Imprimante3d instance = Imprimante3d.getByNom(con, "uprint1");
        instance.setNbHrDeTravail(18);
        instance.save(con);
        assertEquals(18, instance.getNbHrDeTravail(), 0);
        instance.setNbHrDeTravail(1500);
        instance.save(con);
    }

    /**
     * Test of getCoutHoraire method, of class Imprimante3d.
     */
    @Test
    public void testGetCoutHoraire() throws Exception {
        System.out.println("getCoutHoraire");
        Connection con = ConnexionMySQL.newConnexion();
        String nom = "uprint1";
        int expResult = 800;
        Imprimante3d result = Imprimante3d.getByNom(con, nom);
        assertEquals(expResult, result.getCoutHoraire(), 0);
    }

    /**
     * Test of setCoutHoraire method, of class Imprimante3d.
     */
    @Test
    public void testSetCoutHoraire() throws Exception {
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
