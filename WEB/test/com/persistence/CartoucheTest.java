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
        Connection con = ConnexionMySQL.newConnexion();
        String imp3dnom = "uprint1";
        Timestamp dateremplacement = new Timestamp(System.currentTimeMillis());
        Timestamp datefabrication = new Timestamp(System.currentTimeMillis());
        String numerodeserie = "0123456789";
        int quantiterestante = 40;
        int coutaumetre = 10;
        String expResult = "0123456789";
        Cartouche result = Cartouche.create(con, imp3dnom, dateremplacement, datefabrication, numerodeserie, quantiterestante, coutaumetre);
        assertEquals(expResult, result.getNumerodeserie());
        result.delete(con);
    }

    /**
     * Test of save method, of class Cartouche.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-SUP");
        instance.setCoutaumetre(1250);
        instance.save(con);
        assertEquals(1250, instance.getCoutaumetre());
        instance.setCoutaumetre(1500);
        instance.save(con);
    }

    /**
     * Test of getByNumero method, of class Cartouche.
     */
    @Test
    public void testGetByNumero() throws Exception {
        System.out.println("getByNumero");
        Connection con = ConnexionMySQL.newConnexion();
        String numerodeserie = "CARTEST4991-SUP";
        Cartouche result = Cartouche.getByNumero(con, numerodeserie);
        assertEquals("CARTEST4991-SUP", result.getNumerodeserie());
    }

    /**
     * Test of getDateremplacement method, of class Cartouche.
     */
    @Test
    public void testGetDateremplacement() throws Exception {
        System.out.println("getDateremplacement");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        Timestamp expResult = Utils.stringToTimestamp("2019/01/01 00:00:00");
        Timestamp result = instance.getDateremplacement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatefabrication method, of class Cartouche.
     */
    @Test
    public void testGetDatefabrication() throws Exception {
        System.out.println("getDatefabrication");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        Timestamp expResult = Utils.stringToTimestamp("2018/12/01 00:00:00");
        Timestamp result = instance.getDatefabrication();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumerodeserie method, of class Cartouche.
     */
    @Test
    public void testGetNumerodeserie() throws Exception {
        System.out.println("getNumerodeserie");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        String expResult = "CARTEST4991-MAT";
        String result = instance.getNumerodeserie();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantiterestante method, of class Cartouche.
     */
    @Test
    public void testGetQuantiterestante() throws Exception {
        System.out.println("getQuantiterestante");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        int expResult = 487;
        int result = instance.getQuantiterestante();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCoutaumetre method, of class Cartouche.
     */
    @Test
    public void testGetCoutaumetre() throws Exception {
        System.out.println("getCoutaumetre");
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        int expResult = 1500;
        int result = instance.getCoutaumetre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCoutaumetre method, of class Cartouche.
     */
    @Test
    public void testSetCoutaumetre() throws Exception {
        System.out.println("setCoutaumetre");
        int coutaumetre = 1284;
        Connection con = ConnexionMySQL.newConnexion();
        Cartouche instance = Cartouche.getByNumero(con, "CARTEST4991-MAT");
        instance.setCoutaumetre(coutaumetre);
        instance.save(con);
        assertEquals(1284, instance.getCoutaumetre());
        instance.setCoutaumetre(1500);
        instance.save(con);
    }

}
