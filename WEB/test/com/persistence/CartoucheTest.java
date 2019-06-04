/*
 * Fichier : CartoucheTest.java
 * Description : Classe de test de la classe Cartouche.java en JUnit
 * Created on  : Mars 2019
 * Author      : Vraux
 */
package com.persistence;

import java.sql.*;
import org.junit.*;
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
        Connection con = ConnexionMySQL.newConnexion();
        String imp3dNom = "uprint1";
        Timestamp dateRemplacement = new Timestamp(System.currentTimeMillis());
        Timestamp dateFabrication = new Timestamp(System.currentTimeMillis());
        String numeroDeSerie = "0123456789";
        String identType = "12E";
        int quantiteRestante = 40;
        int coutAuCm3 = 10;
        String expResult = "0123456789";
        Cartouche result = Cartouche.create(con, imp3dNom, dateRemplacement, 
                dateFabrication,numeroDeSerie,identType,quantiteRestante,coutAuCm3);
        assertEquals(expResult, result.getNumeroDeSerie());
        result.delete(con);
    }

    /**
     * Test of delete method, of class Cartouche.
     *
     * @Test public void testDelete() throws Exception {
     * System.out.println("delete"); Connection con = null; Cartouche instance =
     * null; boolean expResult = false; boolean result = instance.delete(con);
     * assertEquals(expResult, result); // TODO review the generated test code
     * and remove the default call to fail. fail("The test case is a
     * prototype."); }
     */
    /**
     * Test of save method, of class Cartouche.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-SUP");
        instance.setCoutaucm3(1250);
        instance.save(con);
        assertEquals(1250, instance.getCoutaucm3());
        instance.setCoutaucm3(1500);
        instance.save(con);
    }

    /**
     * Test of getByNumero method, of class Cartouche.
     */
    @Test
    public void testGetByNumero() throws Exception {
        System.out.println("getByNumero");
        Connection con = ConnexionMySQL.newConnexion();
        String numeroDeSerie = "CARTEST4991-SUP";
        Cartouche result = Cartouche.getByNumero(con, numeroDeSerie);
        assertEquals("CARTEST4991-SUP", result.getNumeroDeSerie());
    }

    /**
     * Test of getDateremplacement method, of class Cartouche.
     */
    @Test
    public void testGetDateRemplacement() throws Exception {
        System.out.println("getDateremplacement");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        Timestamp expResult = Utils.stringToTimestamp("2019/01/01 00:00:00");
        Timestamp result = instance.getDateRemplacement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatefabrication method, of class Cartouche.
     */
    @Test
    public void testGetDateFabrication() throws Exception {
        System.out.println("getDatefabrication");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        Timestamp expResult = Utils.stringToTimestamp("2018/12/01 00:00:00");
        Timestamp result = instance.getDateFabrication();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumeroDeSerie method, of class Cartouche.
     */
    @Test
    public void testGetNumeroDeSerie() throws Exception {
        System.out.println("getNumeroDeSerie");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        String expResult = "CARTEST4991-MAT";
        String result = instance.getNumeroDeSerie();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantiterestante method, of class Cartouche.
     */
    @Test
    public void testGetQuantiteRestante() throws Exception {
        System.out.println("getQuantiterestante");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        double expResult = 527.00;
        double result = instance.getQuantiteRestante();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getCoutaucm3 method, of class Cartouche.
     */
    @Test
    public void testGetCoutaucm3() throws Exception {
        System.out.println("getCoutaucm3");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        int expResult = 1500;
        int result = instance.getCoutaucm3();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCoutaucm3 method, of class Cartouche.
     */
    @Test
    public void testSetCoutaucm3() throws Exception {
        System.out.println("setCoutaucm3");
        int coutAuCm3 = 1284;
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        instance.setCoutaucm3(coutAuCm3);
        instance.save(con);
        assertEquals(1284, instance.getCoutaucm3());
        instance.setCoutaucm3(1500);
        instance.save(con);
    }

}
