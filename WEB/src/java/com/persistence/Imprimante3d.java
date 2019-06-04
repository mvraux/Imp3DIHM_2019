/**
    Document    : Imprimante3d.java
    Description : Classe d'interface de la table Imprimante3d
    Created on  : Mars 2019
    Author      : Vraux
*/
package com.persistence;

import java.sql.*;

/**
 *
 * @author snir2g2
 */
public class Imprimante3d {
    private String nom; //clef primaire
    private double nbHrDeTravail; //nombre d'heures de travail de l'imprimante
    private int    coutHoraire; //Cout à l'heure de l'impression, à determiner
    private String fablabNom;   // nom du fablab ou se trouve l'imprimante

    /**
     * Créer un nouvel objet persistant
     *
     * @param con
     * @param nom
     * @param fablabNom
     * @param nbheures
     * @param coutHoraire
     * @return
     * @ return une imprimante
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le nom est
     * deja dans la BD
     *
     */
    static public Imprimante3d create(Connection con, String nom, String fablabNom,
            double nbheures, int coutHoraire) throws Exception {
        Imprimante3d imp = new Imprimante3d(nom, fablabNom, nbheures, coutHoraire);

        String queryString
                = "insert into Imprimante3d (Nom,FablabNom,NbHeuresDeTravail,CoutHoraire) "
                + " values ("
                + Utils.toString(nom) + ", "
                + Utils.toString(fablabNom) + ", "
                + Utils.toString(nbheures) + ", "
                + Utils.toString(coutHoraire)
                + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return imp;

    }

    /**
     * suppression de l'objet Imprimante3d dans la BD
     *
     * @param con
     * @return
     * @throws SQLException impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Imprimante3d where Nom='" + nom + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }

    /**
     * update de l'objet Imprimante3d dans la ConnexionMySQL
     *
     * @param con
     * @throws Exception impossible d'accéder à la ConnexionMySQL
     */
    public void save(Connection con) throws Exception {
        String queryString
                = "update Imprimante3d set "
                + " Nom =" + Utils.toString(nom) + ","
                + " NbHeuresDeTravail =" + Utils.toString(nbHrDeTravail) + ","
                + " CoutHoraire =" + Utils.toString(coutHoraire)
                + " where Nom ='" + nom + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
    }

    public static Imprimante3d getByNom(Connection con, String nom) throws Exception {
        String queryString = "select * from Imprimante3d where Nom='" + nom + "'";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        if (lResult.next()) {
            return creerParRequete(lResult);
        } else {
            return null;
        }
    }

    private static Imprimante3d creerParRequete(ResultSet result) throws Exception {
        String lNom = result.getString("Nom");
        String lFablabnom = result.getString("FablabNom");
        double lNbheures = result.getDouble("NbHeuresDeTravail");
        int lCouthoraire = result.getInt("CoutHoraire");

        return new Imprimante3d(lNom, lFablabnom, lNbheures, lCouthoraire);
    }

    /**
     * Cree et initialise completement Imprimante3d
     * @param nom
     * @param fablabNom
     * @param nbHrDeTravail
     * @param coutHoraire
     */
    public Imprimante3d(String nom, String fablabNom, double nbHrDeTravail, 
                                                             int coutHoraire) {
        this.nom = nom;
        this.fablabNom = fablabNom;
        this.nbHrDeTravail = nbHrDeTravail;
        this.coutHoraire = coutHoraire;
    }

    public String getNom() {
        return nom;
    }

    public double getNbHrDeTravail() {
        return nbHrDeTravail;
    }

    public void setNbHrDeTravail(double nbHrDeTravail) {
        this.nbHrDeTravail = nbHrDeTravail;
    }

    public int getCoutHoraire() {
        return coutHoraire;
    }

    public void setCoutHoraire(int coutHoraire) {
        this.coutHoraire = coutHoraire;
    }

}
