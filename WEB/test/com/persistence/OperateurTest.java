/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
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
public class OperateurTest {

    public OperateurTest() {
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
     * Test of create method, of class Operateur.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = ConnexionMySQL.newConnexion();
        String fabnom = "FabLab_Victor_Hugo";
        String nom = "DURAND";
        String prenom = "Jean";
        String mdp = "monmdp";
        String mail = "monmail@gmail.com";
        String expResult = "monmail@gmail.com";
        Operateur result = Operateur.create(con, fabnom, nom, prenom, mdp, mail);
        assertEquals(expResult, result.getMail());
        result.delete(con);
    }

    /**
     * Test of save method, of class Operateur.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        instance.setNom("DUMAS");
        instance.save(con);
        assertEquals("DUMAS", instance.getNom());
        instance.setNom("Dumas");
        instance.save(con);
    }

    /**
     * Test of getByMail method, of class Operateur.
     */
    @Test
    public void testGetByMail() throws Exception {
        System.out.println("getByMail");
        Connection con = ConnexionMySQL.newConnexion();
        String mail = "operateur@gmail.com";
        Operateur result = Operateur.getByMail(con, mail);
        assertEquals("operateur@gmail.com", result.getMail());
    }

    /**
     * Test of getNom method, of class Operateur.
     */
    @Test
    public void testGetNom() throws Exception {
        System.out.println("getNom");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        assertEquals("Dumas", instance.getNom());
    }

    /**
     * Test of setNom method, of class Operateur.
     */
    @Test
    public void testSetNom() throws Exception {
        System.out.println("setNom");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        instance.setNom("nomtest");
        instance.save(con);
        assertEquals(instance.getNom(), "nomtest");
        instance.setNom("Dumas");
        instance.save(con);
    }

    /**
     * Test of getPrenom method, of class Operateur.
     */
    @Test
    public void testGetPrenom() throws Exception {
        System.out.println("getPrenom");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        assertEquals("Jean pierre", instance.getPrenom());
    }

    /**
     * Test of setPrenom method, of class Operateur.
     */
    @Test
    public void testSetPrenom() throws Exception {
        System.out.println("setPrenom");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        instance.setPrenom("nomtest");
        instance.save(con);
        assertEquals(instance.getPrenom(), "nomtest");
        instance.setPrenom("Jean pierre");
        instance.save(con);
    }

    /**
     * Test of getMdp method, of class Operateur.
     */
    @Test
    public void testGetMdp() throws Exception {
        System.out.println("getMdp");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        assertEquals(Utils.encryptPassword("vhimp3d2019"), instance.getMdp());
    }

    /**
     * Test of setMdp method, of class Operateur.
     */
    @Test
    public void testSetMdp() throws Exception {
        System.out.println("setMdp");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        instance.setMdp("mdptest");
        instance.save(con);
        assertEquals(Utils.encryptPassword("mdptest"), instance.getMdp());
        instance.setMdp("vhimp3d2019");
        instance.save(con);
    }

    /**
     * Test of getMail method, of class Operateur.
     */
    @Test
    public void testGetMail() throws Exception {
        System.out.println("getMail");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        assertEquals("operateur@gmail.com", instance.getMail());
    }

    /**
     * Test of setMail method, of class Operateur.
     */
    @Test
    public void testSetMail() throws Exception {
        System.out.println("setMail");
        Connection con = ConnexionMySQL.newConnexion();
        Operateur instance = Operateur.getByMail(con, "operateur@gmail.com");
        instance.setMail("nouveaumail@gmail.com");
        instance.save(con);
        assertEquals(instance.getMail(), "nouveaumail@gmail.com");
        instance.setMail("operateur@gmail.com");
        instance.save(con);
    }

    
    /**
     * Test of getListeDesOperateurs method, of class Operateur.
     */
    @Test
    public void testGetListeDesOperateurs() throws Exception {
        System.out.println("getListeDesOperateurs");
        Connection con = ConnexionMySQL.newConnexion();
        String expResult = "tech";
        ArrayList<Operateur> resultarray = Operateur.getListeDesOperateurs(con);
        Operateur result = resultarray.get(1);
        assertEquals(expResult, result.getNom());
    }

}
