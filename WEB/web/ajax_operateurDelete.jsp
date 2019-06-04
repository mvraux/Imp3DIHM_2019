<%-- 
    Document   : ajax_operateurDelete.jsp
    Description: page de la suppression dans la BD d'un operateur
                  sauf le 1er !
    Created on : Mai 2019
    Author     : fabre
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
        // le texte commence par "mail: "
        String mail = request.getParameter("mail").substring(6);
        Operateur lui = Operateur.getByMail(con, mail);
        // l'operateur existe ?
        if (lui != null) {
            lui.delete(con);
            out.print("Suppression OK");
        }
        else {      // la personne n'existe pas
            out.print("Suppression impossible !");
        }
    }
%>
