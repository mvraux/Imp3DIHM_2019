<%-- 
    Document    : 0_accueil.jsp
    Description : page accueil de l'opérateur de maintenance
    Created on  : Mars 2019
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Accueil</title> 
        <%@ include file="/includes/header.jspf" %>
    </head>
    <body>
        <% 
            Connection con = (Connection) session.getAttribute("con");
            if (con == null)
                con = ConnexionMySQL.newConnexion();
            session.setAttribute("con", con);
        %>
        
        <div data-role="page" id="page1">
            
            <div role="main" class="ui-content">
            </div>
            <%@include file="/includes/footer.jspf" %>
        </div>
    </body>
</html>