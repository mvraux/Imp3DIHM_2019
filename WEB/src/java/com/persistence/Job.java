/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author snir2g2
 */
public class Job {

    private String nom;
    private Timestamp daterealisation;
    private String etat;
    private double dureeconsommee;
    private double resteafaire;
    private int supportconsomme;
    private int matiereconsommee;
    private int supportestime;
    private int matiereestimee;
    private int prix;

    public Job(String nom, Timestamp daterealisation, String etat, double dureeconsommee, double resteafaire, int supportconsomme, int matiereconsommee, int supportestime, int matiereestimee, int prix) {
        this.nom = nom;
        this.daterealisation = daterealisation;
        this.etat = etat;
        this.dureeconsommee = dureeconsommee;
        this.resteafaire = resteafaire;
        this.supportconsomme = supportconsomme;
        this.matiereconsommee = matiereconsommee;
        this.supportestime = supportestime;
        this.matiereestimee = matiereestimee;
        this.prix = prix;
    }

    /**
     * Créer un nouvel objet persistant
     *
     * @param con
     * @param impnom // nom de l'imprimante
     * @param usercode // code utilisateur
     * @param nom
     * @param daterealisation
     * @param etat // etat du job : "en cours", "fini" ou "neant"
     * @param dureeconsommee
     * @param resteafaire
     * @param supportconsomme
     * @param matiereconsommee
     * @param supportestime
     * @param matiereestimee
     * @param prix
     * @return
     * @ return un user
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le code est
     * deja dans la BD
     *
     */
    static public Job create(Connection con,String impnom, String usercode, String nom,
            Timestamp daterealisation, String etat, double dureeconsommee, double resteafaire,
            int supportconsomme, int matiereconsommee, int supportestime,
            int matiereestimee, int prix) throws Exception {
        Job newjob = new Job(nom, daterealisation, etat, dureeconsommee, resteafaire,
                supportconsomme, matiereconsommee, supportestime, matiereestimee, prix);

        String queryString
                = "insert into Job (Imprimante3dNom,UtilisateurCode,Nom,DateRealisation,Etat,DureeConsommee,ResteAFaireEstimee,"
                + "SupportConsomme,MatiereConsommee,SupportEstime,MatiereEstimee,Prix) "
                + " values ("
                + Utils.toString(impnom) + ", "
                + Utils.toString(usercode) + ", "
                + Utils.toString(nom) + ", "
                + Utils.toString(daterealisation) + ", "
                + Utils.toString(etat) + ", "
                + Utils.toString(dureeconsommee) + ", "
                + Utils.toString(resteafaire) + ", "
                + Utils.toString(supportconsomme) + ", "
                + Utils.toString(matiereconsommee) + ", "
                + Utils.toString(supportestime) + ", "
                + Utils.toString(matiereestimee) + ", "
                + Utils.toString(prix)
                + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
        return newjob;
    }

    /**
     * suppression de l'objet user dans la BD
     *
     * @param con
     * @return
     * @throws SQLException impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Job where nom ='" + nom + "'"
                + "and DateRealisation='" + daterealisation + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }

    /**
     * update de l'objet user dans la ConnexionMySQL
     *
     * @param con
     * @throws Exception impossible d'accéder à la ConnexionMySQL
     */
    public void save(Connection con) throws Exception {
        String queryString
                = "update Job set "
                + " Nom =" + Utils.toString(nom) + ","
                + " DateRealisation =" + Utils.toString(daterealisation) + ","
                + " Etat =" + Utils.toString(etat) + ", "
                + " DureeConsommee =" + Utils.toString(dureeconsommee) + ","
                + " ResteAFaireEstimee =" + Utils.toString(resteafaire) + ", "
                + " SupportConsomme =" + Utils.toString(supportconsomme) + ", "
                + " MatiereConsommee =" + Utils.toString(matiereconsommee) + ", "
                + " SupportEstime =" + Utils.toString(supportestime) + ", "
                + " MatiereEstimee =" + Utils.toString(matiereestimee) + ", "
                + " Prix =" + Utils.toString(prix)
                + " where Nom='" + nom + "'"
                + " and DateRealisation='" + daterealisation + "';";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
    }

    public static Job getByDate(Connection con, Timestamp date) throws Exception {
        String queryString = "select * from Job where DateRealisation='" + date + "'";
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

    private static Job creerParRequete(ResultSet result) throws Exception {
        String lNom = result.getString("Nom");
        Timestamp lDate = result.getTimestamp("DateRealisation");
        String letat = result.getString("Etat");
        double lduree = result.getDouble("DureeConsommee");
        double lreste = result.getDouble("ResteAFaireEstimee");
        int supportc = result.getInt("SupportConsomme");
        int matierec = result.getInt("MatiereConsommee");
        int supporte = result.getInt("SupportEstime");
        int matieree = result.getInt("MatiereEstimee");
        int lprix = result.getInt("Prix");

        return new Job(lNom, lDate, letat, lduree, lreste, supportc,
                matierec, supporte, matieree, lprix);
    }

    public static ArrayList<Job> getListeDesJobs(Connection con) throws Exception {
        ArrayList<Job> jobs = new ArrayList<>();
        String queryString = "select * from Job order by DateRealisation desc";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        while (lResult.next()) {
            String lNom = lResult.getString("Nom");
            Timestamp lDate = lResult.getTimestamp("DateRealisation");
            String letat = lResult.getString("Etat");
            double lduree = lResult.getDouble("DureeConsommee");
            double lreste = lResult.getDouble("ResteAFaireEstimee");
            int supportc = lResult.getInt("SupportConsomme");
            int matierec = lResult.getInt("MatiereConsommee");
            int supporte = lResult.getInt("SupportEstime");
            int matieree = lResult.getInt("MatiereEstimee");
            int lprix = lResult.getInt("Prix");
            Job job = new Job(lNom, lDate, letat, lduree, lreste, supportc,
                    matierec, supporte, matieree, lprix);

            jobs.add(job);
        }
        return jobs;
    }

    public int getID(Connection con) throws SQLException {
        String queryString = "select ID from Job where DateRealisation='" + daterealisation + "'";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        if (lResult.next()) {
            return lResult.getInt("ID");
        }
        return 0;
    }

    public String getNom() {
        return nom;
    }

    public Timestamp getDaterealisation() {
        return daterealisation;
    }

    public String getEtat() {
        return etat;
    }

    public double getDureeconsommee() {
        return dureeconsommee;
    }

    public double getResteafaire() {
        return resteafaire;
    }

    public int getSupportconsomme() {
        return supportconsomme;
    }

    public int getMatiereconsommee() {
        return matiereconsommee;
    }

    public int getSupportestime() {
        return supportestime;
    }

    public int getMatiereestimee() {
        return matiereestimee;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

}
