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
import java.util.ArrayList;

/**
 *
 * @author snir2g2
 */
public class Operateur {

    private String nom;
    private String prenom;
    private String mdp;
    private String mail;

    public Operateur(String nom, String prenom, String mdp, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
    }

    /**
     * Créer un nouvel objet persistant
     *
     * @param con
     * @param ID
     * @param fabnom
     * @param nom
     * @param prenom
     * @param mdp
     * @param mail
     * @return
     * @ return un operateur
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le mail est
     * deja dans la BD
     *
     */
    static public Operateur create(Connection con, String fabnom,
            String nom, String prenom, String mdp, String mail) throws Exception {
        Operateur op = new Operateur(nom, prenom, mdp, mail);

        String queryString
                = "insert into Operateur (FabLabNom,Nom, Prenom,MotDePasse,Mail) "
                + " values ("
                + Utils.toString(fabnom) + ", "
                + Utils.toString(nom) + ", "
                + Utils.toString(prenom) + ", "
                + Utils.toString(mdp) + ", "
                + Utils.toString(mail)
                + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
        return op;
    }

    /**
     * suppression de l'objet Operateur dans la BD
     *
     * @param con
     * @return
     * @throws SQLException impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Operateur where Mail='" + mail + "'";
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
                = "update Operateur set "
                + " Nom =" + Utils.toString(nom) + ","
                + " Prenom =" + Utils.toString(prenom) + ","
                + " MotDePasse =" + Utils.toString(mdp) + ", "
                + " Mail =" + Utils.toString(mail)
                + " where Mail ='" + mail + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
    }

    public static Operateur getByMail(Connection con, String mail) throws Exception {
        String queryString = "select * from Operateur where Mail='" + mail + "'";
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

    private static Operateur creerParRequete(ResultSet result) throws Exception {
        String lNom = result.getString("Nom");
        String lPrenom = result.getString("Prenom");
        String lMdp = result.getString("MotDePasse");
        String lMail = result.getString("Mail");

        return new Operateur(lNom, lPrenom, lMdp, lMail);
    }

    public static ArrayList<Operateur> getListeDesOperateurs(Connection con) throws Exception {
        ArrayList<Operateur> operateurs = new ArrayList<>();
        String queryString = "select * from Operateur Order by Nom";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        while (lResult.next()) {
            String lNom = lResult.getString("Nom");
            String lPrenom = lResult.getString("Prenom");
            String lMdp = lResult.getString("MotDePasse");
            String lMail = lResult.getString("Mail");
            Operateur operateur = new Operateur(lNom, lPrenom, lMdp, lMail);
            operateurs.add(operateur);
        }
        return operateurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = Utils.encryptPassword(mdp);;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
