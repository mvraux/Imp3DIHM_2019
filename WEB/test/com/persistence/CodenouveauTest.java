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
public class CodenouveauTest {

    public CodenouveauTest() {
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
     * Test of create method, of class Codenouveau.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = ConnexionMySQL.newConnexion();;
        String code = "195648";
        String fabnom = "FabLab_Victor_Hugo";
        Codenouveau result = Codenouveau.create(con, code, fabnom);
        assertEquals("195648", result.getCode());
        result.delete(con);
    }

    /**
     * Test of save method, of class Codenouveau.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        String fabnom = "FabLab_Victor_Hugo";
        String codenv = "48876Q9SD46";
        Codenouveau instance = Codenouveau.create(con, codenv, fabnom);
        instance.save(con);
        assertEquals("48876Q9SD46", instance.getCode());
        instance.delete(con);
    }

    /**
     * Test of getByCode method, of class Codenouveau.
     */
    @Test
    public void testGetByCode() throws Exception {
        System.out.println("getByCode");
        Connection con = ConnexionMySQL.newConnexion();
        String code = "48876Q9SD4";
        Codenouveau result = Codenouveau.getByCode(con, code);
        assertEquals(code, result.getCode());
    }

    /**
     * Test of getCode method, of class Codenouveau.
     */
    @Test
    public void testGetCode() throws Exception {
        System.out.println("getCode");
        Connection con = ConnexionMySQL.newConnexion();
        Codenouveau instance = Codenouveau.getByCode(con, "48876Q9SD4");
        assertEquals("48876Q9SD4", instance.getCode());
    }

}
