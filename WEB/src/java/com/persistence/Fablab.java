/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author snir2g2
 */
public class Fablab {
    private String nom; //clef primaire
    private double mintemp; //température minimum
    private double maxtemp; //température maximum
    private double minhumidite; // pourcentage d'humidité relative minimum
    private double maxhumidite; //pourcentage d'humidité relative maximum
    
     /**
     * Créer un nouvel objet persistant 
     * @param con
     * @param nom
     * @param imp3dnom
     * @param mintemp
     * @param maxtemp
     * @param minhumidite
     * @param maxhumidite
     * @return 
     * @ return  un Fablab
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     *                      ou le nom est deja dans la BD
     * 
     */
      static public Fablab create(Connection con,String nom,String imp3dnom, 
            double mintemp, double maxtemp, double minhumidite, double maxhumidite)  throws Exception {
        Fablab fab = new Fablab(nom,mintemp,maxtemp,minhumidite,maxhumidite);
        
        String queryString =
         "insert into Fablab (Nom,Imprimante3dNom,MinTemperature,MaxTemperature,MinHumidite,MaxHumidite) "
            + " values ("
                + Utils.toString(nom) + ", "
                + Utils.toString(imp3dnom) + ", "
                + Utils.toString(mintemp) + ", "
                + Utils.toString(maxtemp) + ", "
                + Utils.toString(minhumidite) + ", " 
                + Utils.toString(maxhumidite)
            + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return fab;
    }
    
     /**
     * suppression de l'objet fablab dans la BD
     * @param con
     * @return 
     * @throws SQLException impossible d'accéder à la ConnexionMySQL
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
         "update Utilisateur set "
                + " Nom =" + Utils.toString(nom) + ","  
                + " MinTemperature =" + Utils.toString(mintemp) + ","
                + " MaxTemperature =" + Utils.toString(maxtemp) + "," 
                + " MinHumidite =" + Utils.toString(minhumidite) + "," 
                + " MaxHumidite =" + Utils.toString(maxhumidite) + "," 
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
     */
    public Fablab(String nom, double mintemp, double maxtemp, double minhumidite, double maxhumudite) {
        this.nom = nom;
        this.mintemp = mintemp;
        this.maxtemp = maxtemp;
        this.minhumidite = minhumidite;
        this.maxhumidite = maxhumudite;
    }

    public String getNom(Connection con)  throws Exception {
        return nom;
    }

    public double getMintemp() {
        return mintemp;
    }

    public double getMaxtemp() {
        return maxtemp;
    }

    public double getMinhumidite() {
        return minhumidite;
    }


    public double getMaxhumidite() {
        return maxhumidite;
    }
    
}
