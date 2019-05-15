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
public class Imprimante3d {

    private String nom; //clef primaire
    private double nbhdetravail; //nombre d'heures de travail de l'imprimante
    private String etat; // etat de l'imprimante
    private double dureerestante; //duree restante du job
    private int couthoraire; //Cout à l'heure de l'impression, à determiner

    /**
     * Créer un nouvel objet persistant
     * @param con
     * @param nom
     * @param jobid
     * @param nbheures
     * @param etat
     * @param dureerestante
     * @param couthoraire
     * @return
     * @ return une imprimante
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le nom est
     * deja dans la BD
     *
     */
    static public Imprimante3d create(Connection con, String nom, int jobid,
            double nbheures, String etat, double dureerestante, int couthoraire) throws Exception {
        Imprimante3d imp = new Imprimante3d(nom, nbheures, etat, dureerestante, couthoraire);

        String queryString
                = "insert into Imprimante3d (Nom,JobID,NbHeuresDeTravail,Etat,DureeRestante,CoutHoraire) "
                + " values ("
                + Utils.toString(nom) + ", "
                + Utils.toString(jobid) + ", "
                + Utils.toString(nbheures) + ", "
                + Utils.toString(etat) + ", "
                + Utils.toString(dureerestante) + ", "
                + Utils.toString(couthoraire)
                + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return imp;

    }

    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Imprimante3d where Nom='" + nom + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }

    public void save(Connection con) throws Exception {
        String queryString
                = "update Imprimante3d set "
                + " Nom =" + Utils.toString(nom) + ","
                + " NbHeuresDeTravail =" + Utils.toString(nbhdetravail) + ","
                + " Etat =" + Utils.toString(etat) + ", "
                + " DureeRestante =" + Utils.toString(dureerestante) + ","
                + " CoutHoraire =" + Utils.toString(couthoraire)
                +" where Nom ='" + nom + "'";
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
        double lNbheures = result.getDouble("NbHeuresDeTravail");
        String lEtat = result.getString("Etat");
        double lDureeRestante = result.getDouble("DureeRestante");
        int lCouthoraire = result.getInt("CoutHoraire");

        return new Imprimante3d(lNom, lNbheures, lEtat, lDureeRestante, lCouthoraire);
    }

    /**
     * Cree et initialise completement Imprimante3d
     */
    public Imprimante3d(String nom, double nbhdetravail, String etat, double dureerestante, int couthoraire) {
        this.nom = nom;
        this.nbhdetravail = nbhdetravail;
        this.etat = etat;
        this.dureerestante = dureerestante;
        this.couthoraire = couthoraire;
    }

    public String getNom() {
        return nom;
    }

    public double getNbhdetravail() {
        return nbhdetravail;
    }

    public void setNbhdetravail(double nbhdetravail) {
        this.nbhdetravail = nbhdetravail;
    }

    public String getEtat() {
        return etat;
    }


    public double getDureerestante() {
        return dureerestante;
    }

    public int getCoutHoraire() {
        return couthoraire;
    }

    public void setCoutHoraire(int couthoraire) {
        this.couthoraire = couthoraire;
    }

}
