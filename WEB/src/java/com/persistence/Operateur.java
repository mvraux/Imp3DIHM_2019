/**
    Document    : Operateur.java
    Description : Classe d'interface de la table Operateur
    Created on  : Mars 2019
    Author      : Vraux
*/
package com.persistence;

import java.sql.*;
import java.util.ArrayList;
import static com.persistence.Utils.*;

/**
 *
 * @author snir2g2
 */
public class Operateur {
    private String nom;
    private String prenom;
    private String mdp;
    private String mail;
    private String fabLabNom;
    
     /**
     * Créer un nouvel objet persistant 
     * @param con
     * @param fabLabNom
     * @param nom
     * @param prenom
     * @param mdp
     * @param mail
     * @return 
     * @ return  un operateur 
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     *                      ou le mail est deja dans la BD
     * 
     */
    
    static public Operateur create(Connection con, String fabLabNom, 
            String nom, String prenom, String mdp, String mail)  throws Exception {
        // encryptage du mot de passe
        String cPassword = encryptPassword(mdp);
        Operateur op = new Operateur(nom,prenom,cPassword,mail,fabLabNom);
        
        String queryString =
         "insert into Operateur (FabLabNom,Nom,Prenom,MotDePasse,Mail) "
            + " values ("
                + Utils.toString(fabLabNom) + ", "
                + Utils.toString(nom) + ", "
                + Utils.toString(prenom) + ", "
                + Utils.toString(cPassword) + ", " 
                + Utils.toString(mail)
            + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
        return op;
    }
        
          /**
     * suppression de l'objet Operateur dans la BD
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
     * @param con
     * @throws Exception impossible d'accéder à la ConnexionMySQL
     */
    public void save(Connection con) throws Exception {
        String queryString =
         "update Operateur set "
                + " Nom =" + Utils.toString(nom) + ","  
                + " Prenom =" + Utils.toString(prenom) + ","
                + " MotDePasse =" + Utils.toString(mdp) + ", " 
                + " Mail =" + Utils.toString(mail) + ", "
                + " FabLabNom =" + Utils.toString(fabLabNom)
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
        }
        else
            return null;
    }
    
    public static ArrayList<Operateur> getListeDesOperateurs(Connection con) 
                                                            throws Exception {
        ArrayList<Operateur> operateurs = new ArrayList<>();
        // 
        String queryString = "select * from Operateur";
        Statement lStat = con.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);  
        while (lResult.next()) {
            operateurs.add(creerParRequete(lResult));
        }
        return operateurs;
    }
    
    private static Operateur creerParRequete(ResultSet result) throws Exception {
            String    lNom = result.getString("Nom");
            String    lPrenom = result.getString("Prenom");
            String    lMdp = result.getString("MotDePasse");
            String    lMail = result.getString("Mail");
            String    lFabLabNom = result.getString("FabLabNom");
            
            return new Operateur(lNom,lPrenom,lMdp,lMail,lFabLabNom);
    }
    
    public Operateur(String nom, String prenom, String mdp, String mail, String fabLabNom) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.fabLabNom = fabLabNom;
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
        this.mdp =  encryptPassword(mdp);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
     
    public String getFabLabNom() {
        return fabLabNom;
    }
      
}
