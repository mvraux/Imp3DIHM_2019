/*
 * Fichier : Utilisateur.java
 * Description : Classe interface de la table Utilisateur
 * Cette table stocke les infos sur les utilisateurs connus du logiciel
 *  Created on  : Mars 2019
 *  Author      : Vraux
 */

package com.persistence;

import java.sql.*;
import java.util.ArrayList;
import static com.persistence.Utils.*;

public class Utilisateur {
    private String    code;             //la clef primaire
    private boolean   mailValide;          // si le mail est valide // not null
    private int       nbJobsRealises;     // le nb de jobs réalisés // not null
    private int       nbEchecs;     // le nb d'échecs // not null
    private Timestamp dateInscription;     // la date de son inscription
    private String    etablissement;        // not null, unique
    private String    mail;
    private String    mdp;         // non null
    private String    nom;
    private String    prenom;
    
    /**
     * Créer un nouvel objet persistant 
     * @param con
     * @param code
     * @param fabnom
     * @param mail
     * @param mdp
     * @param nom
     * @param prenom
     * @param etablissement
     * @param dateregistered // date d'inscription
     * @param mailtrue // validité du mail
     * @param nbjobs
     * @param nbechecs
     * @return 
     * @ return  un user 
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     *                      ou le code est deja dans la BD
     * 
     */
    static public Utilisateur create(Connection con,String code,String fabnom, 
            String nom, String prenom, String mail, String mdp, 
            String etablissement,Timestamp dateregistered,boolean mailtrue,
            int nbjobs,int nbechecs)  throws Exception {
        // encryptage du mot de passe
        String cPassword = encryptPassword(mdp);
        Utilisateur user = new Utilisateur(code, nom, prenom,mail,cPassword,
                etablissement,dateregistered,nbjobs,nbechecs,mailtrue);
        
        String queryString =
         "insert into Utilisateur (Code,FabLabNom,Nom, Prenom,Mail,MotDePasse,"
            + "Etablissement,DateInscription,NbJobsRealises,NbEchecs,MailValide)"
            + " values ("
                + Utils.toString(code) + ", "
                + Utils.toString(fabnom) + ", "
                + Utils.toString(nom) + ", "
                + Utils.toString(prenom) + ", "
                + Utils.toString(mail) + ", " 
                + Utils.toString(cPassword) + ", " 
                + Utils.toString(etablissement) + ", " 
                + Utils.toString(dateregistered) + ", "
                + Utils.toString(nbjobs) + ", " 
                + Utils.toString(nbechecs) + ", " 
                + Utils.toString(mailtrue)
            + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return user;
    }
    
    /**
     * suppression de l'objet user dans la BD
     * @param con
     * @return 
     * @throws SQLException impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from Utilisateur where Mail='" + mail + "'";
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
        String queryString = "update Utilisateur set "
            + " Nom =" + Utils.toString(nom) + ","  
            + " Prenom =" + Utils.toString(prenom) + ","
            + " Mail =" + Utils.toString(mail) + ", " 
            + " MotdePasse =" + Utils.toString(mdp) + "," 
            + " Etablissement =" + Utils.toString(etablissement) + ", " 
            + " DateInscription =" + Utils.toString(dateInscription) + ", "
            + " NbJobsRealises =" + Utils.toString(nbJobsRealises) + ", " 
            + " NbEchecs =" + Utils.toString(nbEchecs) + ", " 
            + " MailValide =" + Utils.toString(mailValide)
            + " where Code ='" + code + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
    }    
    
    /**
     * Retourne un user trouve par son pseudo, saved is true
     * @param con
     * @param  code du user à trouver
     * @return user trouve par code
     * @throws java.lang.Exception
     */
    public static Utilisateur getByCode(Connection con, String code) throws Exception {
        String queryString = "select * from Utilisateur where Code='" + code + "'";
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
    
    /**
     * Retourne un user trouve par son pseudo, saved is true
     * @param con
     * @param  mail du mail à trouver
     * @return user trouve par mail
     * @throws java.lang.Exception
     */
    public static Utilisateur getByMail(Connection con, String mail) throws Exception {
        String queryString = "select * from Utilisateur where Mail='" + mail + "'";
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
    
    public static ArrayList<Utilisateur> getListeDesUtilisateurs(Connection con) throws Exception {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        // 
        String queryString = "select * from Utilisateur order by Nom";
        Statement lStat = con.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);  
        while (lResult.next()) {
            utilisateurs.add(creerParRequete(lResult));
        }
        return utilisateurs;
    }
        
    private static Utilisateur creerParRequete(ResultSet result) throws Exception {
            String    lCode = result.getString("Code");
            String    lNom = result.getString("Nom");
            String    lPrenom = result.getString("Prenom");
            String    lMail = result.getString("Mail");
            String    lMdp = result.getString("MotDePasse");
            String    lEtablissement = result.getString("Etablissement");
            Timestamp    lDate = result.getTimestamp("DateInscription");
            int    lNbjobs = result.getInt("NbJobsRealises");
            int    lNbechecs = result.getInt("NbEchecs");
            boolean    lMailTrue = result.getBoolean("MailValide");
            
            return new Utilisateur(lCode,lNom,lPrenom,lMail,lMdp, lEtablissement, 
                                            lDate, lNbjobs, lNbechecs, lMailTrue);
    }
    
    /**
     * Cree et initialise completement User
     */
    private Utilisateur( String code1, String nom1, String prenom1, String mail1,
                    String mdp1, String etablissement1, Timestamp dateregistered, 
                                    int nbjobs, int nbechecs, boolean mailtrue) {
        this.code = code1;
        this.nom = nom1;
        this.prenom = prenom1;
        this.mail = mail1;
        this.mdp = mdp1;        // encrypté
        this.etablissement = etablissement1;
        this.dateInscription = dateregistered;
        this.nbJobsRealises = nbjobs;
        this.nbEchecs = nbechecs;
        this.mailValide = mailtrue;
        
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isMailValide() {
        return mailValide;
    }

    public void setMailValide(boolean mailValide) {
        this.mailValide = mailValide;
    }

    public int getNbJobsRealises() {
        return nbJobsRealises;
    }

    public void setNbJobsRealises(int nbJobsRealises) {
        this.nbJobsRealises = nbJobsRealises;
    }

    public int getNbEchecs() {
        return nbEchecs;
    }

    public void setNbEchecs(int nbEchecs) {
        this.nbEchecs = nbEchecs;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Timestamp dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = encryptPassword(mdp);
    }

    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
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
}

