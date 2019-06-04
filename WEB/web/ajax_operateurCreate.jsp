<%-- 
    Document   : ajax_operateurCreate.jsp
    Description: page de la création dans la BD d'un operateur
    Created on : Mai 2019
    Author     : Fabre
--%>

<%@page import="com.metier.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.*"%>
<%@page pageEncoding="UTF-8"%>

<%
    Connection con = (Connection) session.getAttribute("con");
    if (con == null) {
        con = ConnexionMySQL.newConnexion();
        session.setAttribute("con", con);
    }
    Operateur operateur = (Operateur) session.getAttribute("operateur");
    // une personne autorisée est connecté ?
    if (operateur != null) {
        // le texte commence par "nom: "
        String nom = request.getParameter("nom");
        // le texte commence par "prenom: "
        String prenom = request.getParameter("prenom");
        // le texte commence par "mail "
        String mail = request.getParameter("mail");
        // le texte commence par "pwd "
        String mdp = request.getParameter("pwd");
        Operateur newOp = Operateur.getByMail(con, mail);
        // si l'operateur n'existe pas, on peut le créer ds le même fabLab.
        if (newOp == null) {
            Operateur.create(con, operateur.getFabLabNom(), nom, prenom, mdp, mail);
            out.print("Création opérateur. OK");
        }
        else {      // la personne n'existe pas
            out.print("Ce mail existe déjà !");
        }
    }
%>
