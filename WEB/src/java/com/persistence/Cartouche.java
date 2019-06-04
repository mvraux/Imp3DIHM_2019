/**
    Document    : Cartouche.java
    Description : Classe d'interface de la table Cartouche
    Created on  : Mars 2019
    Author      : Vraux
*/
package com.persistence;

import java.sql.*;

/**
 *
 * @author snir2g2
 */
public class Cartouche {
    private Timestamp dateRemplacement;
    private Timestamp dateFabrication;
    private String numeroDeSerie;
    private String indentifiantType;
    private double quantiteRestante;
    private int coutAuCm3;

    /**
     * Créer un nouvel objet persistant
     *
     * @param con
     * @param imp3dnom          // clé etrangère
     * @param dateRemplacement  // remplacement de la cartouche
     * @param dateFabrication
     * @param numeroDeSerie
     * @param identifiantType
     * @param quantiteRestante
     * @param coutAuCm3
     * @return
     * @ return une cartouche
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le code est
     * deja dans la BD
     *
     */
    static public Cartouche create(Connection con, String imp3dnom,
            Timestamp dateRemplacement, Timestamp dateFabrication,
            String numeroDeSerie, String identifiantType, 
            double quantiteRestante, int coutAuCm3) throws Exception {
        Cartouche cart = new Cartouche(dateRemplacement, dateFabrication, 
                  numeroDeSerie, identifiantType, quantiteRestante, coutAuCm3);

        String queryString
                = "insert into Cartouche (Imprimante3dNom,DateRemplacement,"
                + "DateFabrication,NumeroDeSerie,IndentifiantType,"
                + "QuantiteRestante,CoutAuCm3) values ("
                + Utils.toString(imp3dnom) + ", "
                + Utils.toString(dateRemplacement) + ", "
                + Utils.toString(dateFabrication) + ", "
                + Utils.toString(numeroDeSerie) + ", "
                + Utils.toString(identifiantType) + ", "
                + Utils.toString(quantiteRestante) + ", "
                + Utils.toString(coutAuCm3)
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
        String queryString = "delete from Cartouche where NumeroDeSerie='" 
                                                         + numeroDeSerie + "'";
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
                + " DateRemplacement =" + Utils.toString(dateRemplacement) + ","
                + " DateFabrication =" + Utils.toString(dateFabrication) + ","
                + " NumeroDeSerie =" + Utils.toString(numeroDeSerie) + ", "
                + " IndentifiantType =" + Utils.toString(indentifiantType) + ", "
                + " QuantiteRestante =" + Utils.toString(quantiteRestante) + ","
                + " CoutAuCm3 =" + Utils.toString(coutAuCm3)
                + " where NumeroDeSerie ='" + numeroDeSerie + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
    }

    /**
     * Retourne un user trouve par son pseudo, saved is true
     *
     * @param con
     * @param numeroDeSerie
     * @return user trouve par mail
     * @throws java.lang.Exception
     */
    public static Cartouche getByNumero(Connection con, String numeroDeSerie) throws Exception {
        String queryString = "select * from Cartouche where NumeroDeSerie='" 
                                                        + numeroDeSerie + "'";
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
        String lIdentType = result.getString("IndentifiantType");
        int lQuantite = result.getInt("QuantiteRestante");
        int lCout = result.getInt("CoutAuCm3");

        return new Cartouche(lDateR,lDateF,lNum,lIdentType,lQuantite,lCout);
    }

    private Cartouche(Timestamp dateRemplacement, Timestamp dateFabrication, 
    String numeroDeSerie, String lIdentType, double quantiteRestante, int coutAuCm3) {
        this.dateRemplacement = dateRemplacement;
        this.dateFabrication = dateFabrication;
        this.numeroDeSerie = numeroDeSerie;
        this.indentifiantType = lIdentType;
        this.quantiteRestante = quantiteRestante;
        this.coutAuCm3 = coutAuCm3;
    }

    public Timestamp getDateRemplacement() {
        return dateRemplacement;
    }

    public Timestamp getDateFabrication() {
        return dateFabrication;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public String getIndentifiantType() {
        return indentifiantType;
    }

    public double getQuantiteRestante() {
        return quantiteRestante;
    }

    public int getCoutaucm3() {
        return coutAuCm3;
    }
    
    public void setCoutaucm3(int coutAuCm3) {
        this.coutAuCm3 = coutAuCm3;
    }

    public void setDateRemplacement(Timestamp dateRemplacement) {
        this.dateRemplacement = dateRemplacement;
    }

    public void setDateFabrication(Timestamp dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }
    
    public void setIndentifiantType(String indentifiantType) {
        this.indentifiantType = indentifiantType;
    }

    public void setQuantiteRestante(double quantiteRestante) {
        this.quantiteRestante = quantiteRestante;
    }

    public void setCoutAuCm3(int coutAuCm3) {
        this.coutAuCm3 = coutAuCm3;
    }

}
