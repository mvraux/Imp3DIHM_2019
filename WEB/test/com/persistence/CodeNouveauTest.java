/*
 * Fichier : CodeNouveauTest.java
 * Description : Classe de test de la classe CodeNouveau.java en JUnit
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
public class CodeNouveauTest {

    public CodeNouveauTest() {
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
     * Test of create method, of class CodeNouveau.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = ConnexionMySQL.newConnexion();;
        String code = "195648";
        String fabnom = "FabLab_Victor_Hugo";
        CodeNouveau result = CodeNouveau.create(con, code, fabnom);
        assertEquals("195648", result.getCode());
        result.delete(con);
    }

    /**
     * Test of delete method, of class Codenouveau.
     
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Connection con = null;
        Codenouveau instance = null;
        boolean expResult = false;
        boolean result = instance.delete(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of save method, of class CodeNouveau.
     */
    @Test
    public void testSave() throws Exception {
       System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        String fabnom = "FabLab_Victor_Hugo";
        String codenv = "48876Q9SD46";
        CodeNouveau instance = CodeNouveau.create(con, codenv, fabnom);
        instance.save(con);
        assertEquals("48876Q9SD46", instance.getCode());
        instance.delete(con);
    }

    /**
     * Test of getByCode method, of class CodeNouveau.
     */
    @Test
    public void testGetByCode() throws Exception {
        System.out.println("getByCode");
        Connection con = ConnexionMySQL.newConnexion();
        String code = "48876Q9SD4";
        CodeNouveau result = CodeNouveau.getByCode(con, code);
        assertEquals(code, result.getCode());
    }

    /**
     * Test of getCode method, of class CodeNouveau.
     */
    @Test
    public void testGetCode()throws Exception {
        System.out.println("getCode");
        Connection con = ConnexionMySQL.newConnexion();
        CodeNouveau instance = CodeNouveau.getByCode(con, "48876Q9SD4");
        assertEquals("48876Q9SD4", instance.getCode());
    }

}
