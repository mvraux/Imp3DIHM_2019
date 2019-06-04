/**
    Document    : Fablab.java
    Description : Classe d'interface de la table Fablabs
    Created on  : Mars 2019
    Author      : Vraux
*/
package com.persistence;

import java.sql.*;

/**
 *
 * @author snir2g2
 */
public class Fablab {
    private String nom; //clef primaire
    private double minTemp; //température minimum
    private double maxTemp; //température maximum
    private double minHumidite; // pourcentage d'humidité relative minimum
    private double maxHumidite; //pourcentage d'humidité relative maximum
    
     /**
     * Créer un nouvel objet persistant 
     * @param con
     * @param nom
     * @param minTemp
     * @param maxTemp
     * @param minHumidite
     * @param maxHumidite
     * @return 
     * @ return  un Fablab
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     *                      ou le nom est deja dans la BD
     * 
     */
      static public Fablab create(Connection con,String nom, double minTemp, 
              double maxTemp, double minHumidite, double maxHumidite)  throws Exception {
        Fablab fab = new Fablab(nom,minTemp,maxTemp,minHumidite,maxHumidite);
        
        String queryString =
         "insert into Fablab (Nom,MinTemperature,MaxTemperature,MinHumidite,MaxHumidite)"
            + " values ("
                + Utils.toString(nom) + ", "
                + Utils.toString(minTemp) + ", "
                + Utils.toString(maxTemp) + ", "
                + Utils.toString(minHumidite) + ", " 
                + Utils.toString(maxHumidite)
            + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return fab;
    }
    
     /**
     * suppression de l'objet fablab dans la BD
     * @param con
     * @return 
     * @throws Exception impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Fablab where Nom='" + nom + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }
    /**
     * update de l'objet fablab dans la ConnexionMySQL
     * @param con
     * @throws Exception impossible d'accéder à la ConnexionMySQL
     */
    public void save(Connection con) throws Exception {
        String queryString =
         "update Fablab set "
                + " Nom =" + Utils.toString(nom) + ","  
                + " MinTemperature =" + Utils.toString(minTemp) + ","
                + " MaxTemperature =" + Utils.toString(maxTemp) + "," 
                + " MinHumidite =" + Utils.toString(minHumidite) + "," 
                + " MaxHumidite =" + Utils.toString(maxHumidite)
                + " where Nom ='" + nom + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
    }
    
    public static Fablab getByNom(Connection con, String nom) throws Exception {
        String queryString = "select * from Fablab where Nom='" + nom + "'";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        if (lResult.next()) {
            return creerParRequete(lResult);
        }
        else
            return null;
    } 
          
    private static Fablab creerParRequete(ResultSet result) throws Exception {
        String    lNom = result.getString("Nom");
        double    lMintemp = result.getDouble("MinTemperature");
        double    lMaxtemp = result.getDouble("MaxTemperature");
        double    lMinHum = result.getDouble("MinHumidite");
        double    lMaxHum = result.getDouble("MaxHumidite");

        return new Fablab(lNom,lMintemp,lMaxtemp,lMinHum, lMaxHum);
    }
    
    /**
     * Cree et initialise completement Fablab
     * @param nom
     * @param minTemp
     * @param maxTemp
     * @param minHumidite
     * @param maxHumidite
     */
    public Fablab(String nom, double minTemp, double maxTemp, double minHumidite, double maxHumidite) {
        this.nom = nom;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.minHumidite = minHumidite;
        this.maxHumidite = maxHumidite;
    }

    public String getNom(Connection con)  throws Exception {
        return nom;
    }

    public double getMintemp() {
        return minTemp;
    }

    public double getMaxtemp() {
        return maxTemp;
    }

    public double getMinhumidite() {
        return minHumidite;
    }


    public double getMaxhumidite() {
        return maxHumidite;
    }
    
}
