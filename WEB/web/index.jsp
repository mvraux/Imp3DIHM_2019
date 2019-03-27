<%-- 
    Document    : index.jsp
    Description : page accueil anonyme
    Created on  : Février 2019

227c4932-7e86-47ad-9b99-df95a4cb5227
--%>

<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://smtpjs.com/v3/smtp.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <title>Accueil</title> 
        <%@ include file="/includes/header.jspf" %>
    </head>
    <body>
        <div data-role="page" id="page1">
            <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                 data-theme="a" data-position="fixed" data-fullscreen="true">
                <h1>Accueil</h1>
            </div>
            
            <div role="main" class="ui-content">
                <center>
                    <br/><br/><br/>
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
                                    out.print("Vérifiez le mot de passe");
                                }
                            }
                        %>
                    </div>
                    <form id="formLogin" class="form" method="post" action="imp3DControl.jsp">
                        <div data-role="fieldcontain">
                            <label for="mdp">Pseudo:</label>
                            <input type="text" name="id" id="id"/>
                        </div>
                        <div data-role="fieldcontain">
                            <label for="mdp">Mot de passe:</label>
                            <input type="password" name="mdp" id="mdp"/>
                        </div>
                        <input name="action" id="login" type="hidden" value="login_req"/><br/>
                        <button type="submit" id="submitOK" name="submitOK">OK</button>
                    </form>
                    <p class="mini">V0.1 - Février 2019<br/>Développement : BTS SNIR Lycée V.Hugo Colomiers</p>
                </center>
            </div>
        </div>
    </body>
</html>

