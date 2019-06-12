/**
    Document    : Job.java
    Description : Classe d'interface de la table Job
    Created on  : Mars 2019
    Author      : Vraux
*/
package com.persistence;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author snir2g2
 */
public class Job {
    private String userCode;
    private String nom;
    private Timestamp dateRealisation;
    private String etat;
    private int dureeConsommee;
    private int resteAFaire;
    private double supportConsomme;
    private double matiereConsommee;
    private double supportEstime;
    private double matiereEstimee;
    private int prix;
    private String imprimante3dNom;

    public Job(String userCode, String nom, Timestamp daterealisation, String etat, 
            int dureeconsommee, int resteafaire, double supportconsomme, 
            double matiereconsommee, double supportestime, double matiereestimee, 
            int prix, String imprimante3dNom) {
        this.userCode = userCode;
        this.nom = nom;
        this.dateRealisation = daterealisation;
        this.etat = etat;
        this.dureeConsommee = dureeconsommee;
        this.resteAFaire = resteafaire;
        this.supportConsomme = supportconsomme;
        this.matiereConsommee = matiereconsommee;
        this.supportEstime = supportestime;
        this.matiereEstimee = matiereestimee;
        this.prix = prix;
        this.imprimante3dNom = imprimante3dNom;
    }

    /**
     * Créer un nouvel objet persistant
     *
     * @param con
     * @param userCode // code utilisateur
     * @param nom
     * @param dateRealisation
     * @param etat // etat du job : "en cours", "fini" ou "neant"
     * @param dureeConsommee
     * @param resteAFaire
     * @param supportConsomme
     * @param matiereConsommee
     * @param supportEstime
     * @param matiereEstimee
     * @param prix
     * @return
     * @ return un user
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le code est
     * deja dans la BD
     *
     */
    static public Job create(Connection con, String userCode, String nom,
            Timestamp dateRealisation, String etat, int dureeConsommee, int resteAFaire,
            double supportConsomme, double matiereConsommee, double supportEstime,
            double matiereEstimee, int prix, String imprimante3dNom) throws Exception {
        Job newjob = new Job(userCode, nom, dateRealisation, etat, dureeConsommee, resteAFaire,
                supportConsomme, matiereConsommee, supportEstime, matiereEstimee, prix, imprimante3dNom);

        String queryString
                = "insert into job (UtilisateurCode,Nom,DateRealisation,Etat,DureeConsommee,ResteAFaireEstimee,"
                + "SupportConsomme,MatiereConsommee,SupportEstime,MatiereEstimee,Prix,Imprimante3dNom) "
                + " values ("
                + Utils.toString(userCode) + ", "
                + Utils.toString(nom) + ", "
                + Utils.toString(dateRealisation) + ", "
                + Utils.toString(etat) + ", "
                + Utils.toString(dureeConsommee) + ", "
                + Utils.toString(resteAFaire) + ", "
                + Utils.toString(supportConsomme) + ", "
                + Utils.toString(matiereConsommee) + ", "
                + Utils.toString(supportEstime) + ", "
                + Utils.toString(matiereEstimee) + ", "
                + Utils.toString(prix) + ", "
                + Utils.toString(imprimante3dNom)
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
        String queryString = "delete from job where nom ='"+nom+"'"
                            + "and DateRealisation='" + dateRealisation + "'";
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
                = "update job set "
                + " UtilisateurCode =" + Utils.toString(userCode) + ","
                + " Nom =" + Utils.toString(nom) + ","
                + " DateRealisation =" + Utils.toString(dateRealisation) + ","
                + " Etat =" + Utils.toString(etat) + ", "
                + " DureeConsommee =" + Utils.toString(dureeConsommee) + ","
                + " ResteAFaireEstimee =" + Utils.toString(resteAFaire) + ", "
                + " SupportConsomme =" + Utils.toString(supportConsomme) + ", "
                + " MatiereConsommee =" + Utils.toString(matiereConsommee) + ", "
                + " SupportEstime =" + Utils.toString(supportEstime) + ", "
                + " MatiereEstimee =" + Utils.toString(matiereEstimee) + ", "
                + " Prix =" + Utils.toString(prix) + ", "
                + " Imprimante3dNom =" + Utils.toString(imprimante3dNom)
                + " where Nom='" + nom + "'"
                + " and DateRealisation='" + dateRealisation + "';";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
    }

    public static Job getByDate(Connection con, Timestamp date) throws Exception {
        String queryString = "select * from job where DateRealisation='" + date + "'";
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

    public static Job getByNom(Connection con, String nom) throws Exception {
        String queryString = "select * from job where Nom='" + nom + "'";
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

    public static Job getJobEnCours(Connection con) throws Exception {
        String queryString = "select * from job where Etat='EN_COURS'";
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
    
    public static int nbJobsParUserCode(Connection con, String code) throws Exception {
        String queryString = "select count(*) as count from job where UtilisateurCode='" + code + "'";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if (lResult.next())
            return (lResult.getInt("count"));
        else 
            return 0;
    }
    
    public static ArrayList<Job> getListeDesJobs(Connection con) throws Exception {
        ArrayList<Job> jobs = new ArrayList<>();
        
        String queryString = "select * from job order by DateRealisation desc";
        Statement lStat = con.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);  
        while (lResult.next()) {
            jobs.add(creerParRequete(lResult));
        }
        return jobs;
    }
        
    public static ArrayList<Job> getListeDeMesJobs(Connection con, String userCode) 
                                                                throws Exception {
        ArrayList<Job> jobs = new ArrayList<>();
        
        String queryString = "select * from job where UtilisateurCode='"
                            + userCode + "' order by DateRealisation desc";
        Statement lStat = con.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);  
        while (lResult.next()) {
            jobs.add(creerParRequete(lResult));
        }
        return jobs;
    }

    private static Job creerParRequete(ResultSet result) throws Exception {
        String lUserCode = result.getString("UtilisateurCode");
        String lNom = result.getString("Nom");
        Timestamp lDate = result.getTimestamp("DateRealisation");
        String letat = result.getString("Etat");
        int lduree = result.getInt("DureeConsommee");
        int lreste = result.getInt("ResteAFaireEstimee");
        double supportc = result.getDouble("SupportConsomme");
        double matierec = result.getDouble("MatiereConsommee");
        double supporte = result.getDouble("SupportEstime");
        double matieree = result.getDouble("MatiereEstimee");
        int lprix = result.getInt("Prix");
        String lImprimante3dNom = result.getString("Imprimante3dNom");

        return new Job(lUserCode, lNom, lDate, letat, lduree, lreste, supportc,
                matierec, supporte, matieree, lprix, lImprimante3dNom);
    }
    
    public int getID(Connection con) throws SQLException {
        String queryString = "select ID from job where DateRealisation='" 
                                                        + dateRealisation + "'";
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

    public String getUserCode() {
        return userCode;
    }

    public String getNom() {
        return nom;
    }

    public Timestamp getDateRealisation() {
        return dateRealisation;
    }

    public String getEtat() {
        return etat;
    }

    public int getDureeConsommee() {
        return dureeConsommee;
    }

    public int getResteAFaire() {
        return resteAFaire;
    }

    public double getSupportConsomme() {
        return supportConsomme;
    }

    public double getMatiereConsommee() {
        return matiereConsommee;
    }

    public double getSupportEstime() {
        return supportEstime;
    }

    public double getMatiereEstimee() {
        return matiereEstimee;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public String getImprimante3dNom() {
        return imprimante3dNom;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDureeConsommee(int dureeConsommee) {
        this.dureeConsommee = dureeConsommee;
    }

    public void setResteAFaire(int resteAFaire) {
        this.resteAFaire = resteAFaire;
    }

    public void setSupportConsomme(double supportConsomme) {
        this.supportConsomme = supportConsomme;
    }

    public void setMatiereConsommee(double matiereConsommee) {
        this.matiereConsommee = matiereConsommee;
    }

    public void setSupportEstime(double supportEstime) {
        this.supportEstime = supportEstime;
    }

    public void setMatiereEstimee(double matiereEstimee) {
        this.matiereEstimee = matiereEstimee;
    }
    
}
