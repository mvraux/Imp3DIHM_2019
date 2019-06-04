/**
    Document    : CodeNouveau.java
    Description : Classe d'interface de la table CodeNouveau
    Created on  : Mars 2019
    Author      : Vraux
*/
package com.persistence;

import java.sql.*;

/**
 *
 * @author snir2g2
 */
public class CodeNouveau {

    private String code; //clef primaire

    public CodeNouveau(String code) {
        this.code = code;
    }

    /**
     * Créer un nouvel objet persistant
     *
     * @param con
     * @param code
     * @param fabnom
     * @return
     * @ return un code nouveau
     * @throws Exception impossible d'accéder à la ConnexionMySQL ou le code est
     * deja dans la BD
     *
     */
    static public CodeNouveau create(Connection con, String code, String fabnom) throws Exception {
        CodeNouveau codenv = new CodeNouveau(code);

        String queryString
                = "insert into Codenouveau (Code,FabLabNom) "
                + " values ("
                + Utils.toString(code) + ", "
                + Utils.toString(fabnom)
                + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return codenv;
    }

    /**
     * suppression de l'objet user dans la BD
     *
     * @param con
     * @return
     * @throws SQLException impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Codenouveau where Code='" + code + "'";
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
                = "update Codenouveau set "
                + " Code =" + Utils.toString(code)
                + " where Code ='" + code + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
    }
    
     /**
     * Retourne un user trouve par son pseudo, saved is true
     * @param con
     * @param code
     * @return user trouve par mail
     * @throws java.lang.Exception
     */
    public static CodeNouveau getByCode(Connection con, String code) throws Exception {
        String queryString = "select * from Codenouveau where Code='" + code + "'";
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
    
     private static CodeNouveau creerParRequete(ResultSet result) throws Exception {
            String    lCode = result.getString("Code");
            
            return new CodeNouveau(lCode);
    }

    public String getCode() {
        return code;
    }


}
