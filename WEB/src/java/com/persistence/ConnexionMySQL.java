/*
 * Fichier : ConnexionMySQL.java
 * Description : Classe interface de la connexion à la base de données imp3D
 * Cette table gère l'accès à la BD imp3D
 *  Created on  : Mars 2019
 *  Author      : Vraux
 */

package com.persistence;

import java.sql.*;

/**
 * Singleton instance that gives the connection to the database
 * @author  LVH
 * @since   02/2019 
 * 
 * @version 0.1.0
 *
 */
public class ConnexionMySQL {
// ---------------------------------------------------------------------
//                          MySQL changes
// ---------------------------------------------------------------------
    /** driverDst : MySQl driver  */
    private static String driver    = "com.mysql.jdbc.Driver";
    /** url : ConnexionMySQL URL */
    private static String url       = "jdbc:mysql://localhost:3306/imp3d?zeroDateTimeBehavior=convertToNull";
// ---------------------------------------------------------------------
    /** userName : eventskytracker */
    private static String userName  = "imp3d";
    /** password : estNovae31 */
    private static String password  = "imp3d31";
    /** destination connection on the database */
    private static Connection conn  = null;
    
    private ConnexionMySQL() throws Exception { }
    
    /**
     * getter for the ConnexionMySQL instance
     * @return the ConnexionMySQL instance
     * @throws java.lang.Exception
     */    
    public static Connection getInstance() throws Exception  {
       if (conn == null) {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
        }
        return conn;
    }
    
    public static Connection newConnexion() throws Exception {
        Connection _conn = null;
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}

