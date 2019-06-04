<%-- 
    Document   : ajax_userDelete.jsp
    Description: page de la suppression dans la BD d'un utilisateur
                  Uniquement si cet utilisateur ne gère aucun job !
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
        String mail = request.getParameter("mail").substring(6);
        Utilisateur utilisateur = Utilisateur.getByMail(con, mail);
        // la personne existe ?
        if (utilisateur != null) {
            // on regarde s'il n'a pas de jobs
            String code = utilisateur.getCode();
            if (Job.nbJobsParUserCode(con, code) == 0) {
                utilisateur.delete(con);
                out.print("Suppression OK");
            }
            else {
                out.print("Supprimer d'abord la gestion de ses jobs !");
            }
        }
        else {      // la personne n'existe pas
            out.print("Suppression impossible !");
        }
    }
%>
