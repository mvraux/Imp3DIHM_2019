<%-- 
    Document    : index.jsp
    Description : page accueil anonyme du site avant connexion
    Created on  : Février 2019
    Author      : Tessier
--%>

<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Acceuil</title> 
        <%@ include file="/includes/header.jspf" %>
    </head>
    <body>
        <div data-role="page" id="page1">
            <div class="header" data-role="header" data-theme="b" data-position="fixed">
                <h1>Accueil</h1>
                <p></p>
            </div>
            
            <div role="main" class="ui-content"><br/><br/><br/>
                <center>
                    <h2>Suivi d'impression 3D au FabLab<br/>
                        du Lycée international Victor Hugo de Colomiers</h2>
                    <br/><br/>
                    <div class="logo"><img src="images/imp3D.png" /></div>  
                    <br/>
                    <div>
                        <%
                            String message = request.getParameter("message");
                            if (message != null) {
                                if (message.equalsIgnoreCase("pbLogin")) {
                                    out.print("Vérifiez l'identifiant ou le mot de passe");
                                }
                            }
                        %>
                    </div>
                    <form id="formLogin" class="form" method="post" action="login_req.jsp">
                        <div data-role="fieldcontain">
                            <label for="mail">Adresse mail :</label>
                            <input type="text" name="mail" id="mail"/>
                        </div>
                        <div data-role="fieldcontain">
                            <label for="mdp">Mot de passe :</label>
                            <input type="password" name="mdp" id="mdp"/>
                        </div>
                        <input name="action" id="login" type="hidden" data-theme="b" value="login_req"/><br/>
                        <button type="submit" id="submitOK" name="submitOK">OK</button>
                    </form>
                    <p class="mini">V0.3 - Mai 2019<br/>Développement : BTS SNIR Lycée V.Hugo Colomiers</p>
                </center>
            </div>
        </div>
    </body>
</html>

