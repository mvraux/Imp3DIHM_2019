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
public class UtilisateurTest {

    public UtilisateurTest() {
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
     * Test of create method, of class Utilisateur.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = ConnexionMySQL.newConnexion();
        String code = "18956468";
        String fabnom = "FabLab_Victor_Hugo";
        String nom = "user";
        String prenom = "user";
        String mail = "user@gmail.com";
        String mdp = "mdpuser";
        String etablissement = "lycee";
        Timestamp dateregistered = new Timestamp(System.currentTimeMillis());;
        boolean mailtrue = false;
        int nbjobs = 0;
        int nbechecs = 0;
        Utilisateur result = Utilisateur.create(con, code, fabnom, nom, prenom,
                mail, mdp, etablissement, dateregistered, mailtrue, nbjobs, nbechecs);
        assertEquals("user@gmail.com", result.getMail());
        result.delete(con);
    }

    /**
     * Test of delete method, of class Utilisateur.
     *
     * @Test public void testDelete() throws Exception {
     * System.out.println("delete"); Connection con =
     * ConnexionMySQL.newConnexion(); Utilisateur instance = null; boolean
     * expResult = false; boolean result = instance.delete(con);
     * assertEquals(expResult, result); // TODO review the generated test code
     * and remove the default call to fail. fail("The test case is a
     * prototype."); }
     */
    /**
     * Test of save method, of class Utilisateur.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur user = Utilisateur.getByMail(con, "user1@gmail.com");
        user.setNom("nomtest");
        user.save(con);
        assertEquals("nomtest", user.getNom());
        user.setNom("Millet");
        user.save(con);
    }

    /**
     * Test of getByMail method, of class Utilisateur.
     */
    @Test
    public void testGetByMail() throws Exception {
        System.out.println("getByMail");
        Connection con = ConnexionMySQL.newConnexion();
        String mail = "user1@gmail.com";
        Utilisateur result = Utilisateur.getByMail(con, mail);
        assertEquals("user1@gmail.com", result.getMail());
    }

    /**
     * Test of getCode method, of class Utilisateur.
     */
    @Test
    public void testGetCode() throws Exception {
        System.out.println("getCode");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals("SDQ5S7GFS98S", instance.getCode(con));
    }

    /**
     * Test of isMailValide method, of class Utilisateur.
     */
    @Test
    public void testIsMailValide() throws Exception {
        System.out.println("isMailValide");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals(true, instance.isMailValide());
    }

    /**
     * Test of setMailValide method, of class Utilisateur.
     */
    @Test
    public void testSetMailValide() throws Exception {
        System.out.println("setMailValide");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setMailValide(false);
        instance.save(con);
        assertEquals(false, instance.isMailValide());
        instance.setMailValide(true);
        instance.save(con);
    }

    /**
     * Test of getNbJobsRealises method, of class Utilisateur.
     */
    @Test
    public void testGetNbJobsRealises() throws Exception {
        System.out.println("getNbJobsRealises");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals(2, instance.getNbJobsRealises());
    }

    /**
     * Test of setNbJobsRealises method, of class Utilisateur.
     */
    @Test
    public void testSetNbJobsRealises() throws Exception {
        System.out.println("setNbJobsRealises");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setNbJobsRealises(18);
        instance.save(con);
        assertEquals(18, instance.getNbJobsRealises());
        instance.setNbJobsRealises(2);
        instance.save(con);
    }

    /**
     * Test of getNbEchecs method, of class Utilisateur.
     */
    @Test
    public void testGetNbEchecs() throws Exception {
        System.out.println("getNbEchecs");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals(1, instance.getNbEchecs());
    }

    /**
     * Test of setNbEchecs method, of class Utilisateur.
     */
    @Test
    public void testSetNbEchecs() throws Exception {
        System.out.println("setNbEchecs");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setNbEchecs(54);
        instance.save(con);
        assertEquals(54, instance.getNbEchecs());
        instance.setNbEchecs(1);
        instance.save(con);
    }

    /**
     * Test of getDateInscription method, of class Utilisateur.
     */
    @Test
    public void testGetDateInscription() throws Exception {
        System.out.println("getDateInscription");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals(Utils.stringToTimestamp("2018/01/01 00:00:00"), instance.getDateInscription());
    }

    /**
     * Test of setDateInscription method, of class Utilisateur.
     */
    @Test
    public void testSetDateInscription() throws Exception {
        System.out.println("setDateInscription");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setDateInscription(Utils.stringToTimestamp("2019/01/01 00:00:00"));
        instance.save(con);
        assertEquals(Utils.stringToTimestamp("2019/01/01 00:00:00"), instance.getDateInscription());
        instance.setDateInscription(Utils.stringToTimestamp("2018/01/01 00:00:00"));
        instance.save(con);
    }

    /**
     * Test of getEtablissement method, of class Utilisateur.
     */
    @Test
    public void testGetEtablissement() throws Exception {
        System.out.println("getEtablissement");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals("Lycée Bellevue", instance.getEtablissement());
    }

    /**
     * Test of setEtablissement method, of class Utilisateur.
     */
    @Test
    public void testSetEtablissement() throws Exception {
        System.out.println("setEtablissement");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setEtablissement("lycéetest");
        instance.save(con);
        assertEquals("lycéetest", instance.getEtablissement());
        instance.setEtablissement("Lycée Bellevue");
        instance.save(con);
    }

    /**
     * Test of getMdp method, of class Utilisateur.
     */
    @Test
    public void testGetMdp() throws Exception {
        System.out.println("getMdp");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals(Utils.encryptPassword("mdpuser"), instance.getMdp());
    }

    /**
     * Test of setMdp method, of class Utilisateur.
     */
    @Test
    public void testSetMdp() throws Exception {
        System.out.println("setMdp");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setMdp("mdptest");
        instance.save(con);
        assertEquals(Utils.encryptPassword("mdptest"), instance.getMdp());
        instance.setMdp("mdpuser");
        instance.save(con);
    }

    /**
     * Test of getMail method, of class Utilisateur.
     */
    @Test
    public void testGetMail() throws Exception {
        System.out.println("getMail");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals("user1@gmail.com", instance.getMail());
    }

    /**
     * Test of setMail method, of class Utilisateur.
     */
    @Test
    public void testSetMail() throws Exception {
        System.out.println("setMail");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setMail("nouveaumail@gmail.com");
        instance.save(con);
        assertEquals(instance.getMail(), "nouveaumail@gmail.com");
        instance.setMail("user1@gmail.com");
        instance.save(con);
    }

    /**
     * Test of getNom method, of class Utilisateur.
     */
    @Test
    public void testGetNom() throws Exception {
        System.out.println("getNom");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals("Millet", instance.getNom());
    }

    /**
     * Test of setNom method, of class Utilisateur.
     */
    @Test
    public void testSetNom() throws Exception { 
        System.out.println("setNom");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setNom("nomtest");
        instance.save(con);
        assertEquals(instance.getNom(), "nomtest");
        instance.setNom("Millet");
        instance.save(con);
    }

    /**
     * Test of getPrenom method, of class Utilisateur.
     */
    @Test
    public void testGetPrenom()throws Exception {
        System.out.println("getPrenom");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        assertEquals("Bertrand", instance.getPrenom());
    }

    /**
     * Test of setPrenom method, of class Utilisateur.
     */
    @Test
    public void testSetPrenom() throws Exception {
        System.out.println("setPrenom");
        Connection con = ConnexionMySQL.newConnexion();
        Utilisateur instance = Utilisateur.getByMail(con, "user1@gmail.com");
        instance.setPrenom("nomtest");
        instance.save(con);
        assertEquals(instance.getPrenom(), "nomtest");
        instance.setPrenom("Bertrand");
        instance.save(con);
    }

}
