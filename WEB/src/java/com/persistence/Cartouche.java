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
public class Cartouche {

    private Timestamp dateremplacement;
    private Timestamp datefabrication;
    private String numerodeserie;
    private int quantiterestante;
    private int coutaumetre;

    public Cartouche(Timestamp dateremplacement, Timestamp datefabrication, String numerodeserie, int quantiterestante, int coutaumetre) {
        this.dateremplacement = dateremplacement;
        this.datefabrication = datefabrication;
        this.numerodeserie = numerodeserie;
        this.quantiterestante = quantiterestante;
        this.coutaumetre = coutaumetre;
    }

    /**
     * Créer un nouvel objet persistant
     *
     * @param con
     * @param ID // clé auto-incrementée
     * @param imp3dnom // clé etrangère
     * @param dateremplacement // remplacement de la cartouche
     * @param datefabrication
     * @param numerodeserie
     * @param quantiterestante
     * @param coutaumetre
     * @return
     * @ return une cartouche
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le code est
     * deja dans la BD
     *
     */
    static public Cartouche create(Connection con, String imp3dnom,
            Timestamp dateremplacement, Timestamp datefabrication,
            String numerodeserie, int quantiterestante, int coutaumetre) throws Exception {
        Cartouche cart = new Cartouche(dateremplacement, datefabrication, numerodeserie, quantiterestante, coutaumetre);

        String queryString
                = "insert into Cartouche (Imprimante3dNom,DateRemplacement,DateFabrication,NumeroDeSerie,QuantiteRestante,CoutAuMetre) "
                + " values ("
                + Utils.toString(imp3dnom) + ", "
                + Utils.toString(dateremplacement) + ", "
                + Utils.toString(datefabrication) + ", "
                + Utils.toString(numerodeserie) + ", "
                + Utils.toString(quantiterestante) + ", "
                + Utils.toString(coutaumetre)
                + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
        return cart;
    }

    /**
     * suppression de l'objet user dans la BD
     *
     * @param con
     * @return
     * @throws SQLException impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Cartouche where NumeroDeSerie='" + numerodeserie + "'";
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
                = "update Cartouche set "
                + " DateRemplacement =" + Utils.toString(dateremplacement) + ","
                + " DateFabrication =" + Utils.toString(datefabrication) + ","
                + " NumeroDeSerie =" + Utils.toString(numerodeserie) + ", "
                + " QuantiteRestante =" + Utils.toString(quantiterestante) + ","
                + " CoutAuMetre =" + Utils.toString(coutaumetre)
                + " where NumeroDeSerie ='" + numerodeserie + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
    }

    /**
     * Retourne un user trouve par son pseudo, saved is true
     *
     * @param con
     * @param mail du mail à trouver
     * @return user trouve par mail
     * @throws java.lang.Exception
     */
    public static Cartouche getByNumero(Connection con, String numerodeserie) throws Exception {
        String queryString = "select * from Cartouche where NumeroDeSerie='" + numerodeserie + "'";
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

    private static Cartouche creerParRequete(ResultSet result) throws Exception {
        Timestamp lDateR = result.getTimestamp("DateRemplacement");
        Timestamp lDateF = result.getTimestamp("DateFabrication");
        String lNum = result.getString("NumeroDeSerie");
        int lquantite = result.getInt("QuantiteRestante");
        int lcout = result.getInt("CoutAuMetre");

        return new Cartouche(lDateR,lDateF,lNum,lquantite,lcout);
    }

    public Timestamp getDateremplacement() {
        return dateremplacement;
    }

    public Timestamp getDatefabrication() {
        return datefabrication;
    }

    public String getNumerodeserie() {
        return numerodeserie;
    }

    public int getQuantiterestante() {
        return quantiterestante;
    }

    public int getCoutaumetre() {
        return coutaumetre;
    }

    public void setCoutaumetre(int coutaumetre) {
        this.coutaumetre = coutaumetre;
    }

}
