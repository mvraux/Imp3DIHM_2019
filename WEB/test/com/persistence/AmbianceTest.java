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
public class AmbianceTest {

    public AmbianceTest() {
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
     * Test of create method, of class Ambiance.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Connection con = ConnexionMySQL.newConnexion();
        String fabnom = "FabLab_Victor_Hugo";
        double temperature = 22.2;
        double humidite = 22.2;
        Timestamp date = new Timestamp(System.currentTimeMillis());
        Ambiance result = Ambiance.create(con, fabnom, temperature, humidite, date);
        assertEquals(date, result.getDate());
        result.delete(con);
    }

    /**
     * Test of save method, of class Ambiance.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp amb1 = Utils.stringToTimestamp("2019/02/12 00:00:00");
        String fabnom = "FabLab_Victor_Hugo";
        double temp = 26.8;
        double hum = 45.9;
        Ambiance instance = Ambiance.create(con, fabnom, temp, hum, amb1);
        instance.save(con);
        assertEquals(26.8, instance.getTemperature(), 0.01);
        instance.delete(con);
    }

    /**
     * Test of getByDate method, of class Ambiance.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetByDate() throws Exception {
        System.out.println("getByDate");
        Connection con = ConnexionMySQL.newConnexion();
        Timestamp date = Utils.stringToTimestamp("2019/02/19 00:00:00");
        Ambiance result = Ambiance.getByDate(con, date);
        assertEquals(Utils.stringToTimestamp("2019/02/19 00:00:00"), result.getDate());
    }

    /**
     * Test of getTemperature method, of class Ambiance.
     */
    @Test
    public void testGetTemperature() throws Exception {
        System.out.println("getTemperature");
        Connection con = ConnexionMySQL.newConnexion();
        Ambiance instance = Ambiance.getByDate(con, Utils.stringToTimestamp("2019/02/19 00:00:00"));
        double expResult = 12.0;
        double result = instance.getTemperature();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getHumidite method, of class Ambiance.
     */
    @Test
    public void testGetHumidite() throws Exception {
        System.out.println("getHumidite");
        Connection con = ConnexionMySQL.newConnexion();
        Ambiance instance = Ambiance.getByDate(con, Utils.stringToTimestamp("2019/02/18 00:00:00"));
        double expResult = 60.0;
        double result = instance.getHumidite();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDate method, of class Ambiance.
     */
    @Test
    public void testGetDate() throws Exception {
        System.out.println("getDate");
        Connection con = ConnexionMySQL.newConnexion();
        Ambiance instance = Ambiance.getByDate(con, Utils.stringToTimestamp("2019/02/19 00:00:00"));
        assertEquals(Utils.stringToTimestamp("2019/02/19 00:00:00"), instance.getDate());
    }

}
