<%-- 
    Document    : u_accueil.jsp
    Description : page accueil d'un utilisateur
    Created on  : Mai 2019
    Author      : Tessier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.*"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Accueil User</title> 
        <%@ include file="includes/header.jspf" %>
    </head>
    <body>
    <%
        Connection con = (Connection) session.getAttribute("con");
        if (con == null) {
            con = ConnexionMySQL.newConnexion();
            session.setAttribute("con", con);
        }
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        // on se protège d'un accès illicite à cette page
        if (utilisateur == null) { 
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    %>
        <div data-role="page" id="page1">
            <div class="header" data-role="header" data-theme="b" data-position="fixed">
                <h1><%out.print(utilisateur.getNom() + " " + utilisateur.getPrenom());%></h1>
                <a href="index.jsp" class="ui-btn-right">Déconnexion</a>
            </div>
            <div role="main" class="ui-content"><br/><br/><br/>
            <script type="text/javascript" src="js/imp3D.js"></script>
    <script type="text/javascript">
    <%        
        ArrayList<Job> jobs = Job.getListeDeMesJobs(con, utilisateur.getCode());
        out.print("jobs  = [");
        int i = 0;
        for (Job jb : jobs) {
            if (i > 0)
                out.println(",");
            out.println("{");
            out.println("nom: '" + jb.getNom() + "',");
            out.println("utilisateur: '" + jb.getUserCode() + "',");
            out.println("dateRealisation: '" + jb.getDateRealisation() + "',");
            out.println("etat: '" + jb.getEtat() + "',");
            out.println("dureeConsommee: " + jb.getDureeConsommee() + ",");
            out.println("resteAFaire: " + jb.getResteAFaire() + ",");
            out.println("supportConsomme: " + jb.getSupportConsomme() + ",");
            out.println("matiereConsommee: " + jb.getMatiereConsommee() + ",");
            out.println("supportEstime: " + jb.getSupportEstime() + ",");
            out.println("matiereEstimee: " + jb.getMatiereEstimee() + ",");
            out.println("prix: " + jb.getPrix());
            out.println("}");
            i++;
        }
        out.println("];");
    %>
    </script>
                <center>
                <h2>Liste des Jobs</h2>
                <table data-role="table" id="listejobs" class="ui-responsive table">
                    <thead>
                       <h3>Job</h3>
                       <tr>
                         <th>Job</th>
                         <th>Utilisateur</th>
                         <th>Date</th>
                         <th>Etat</th>
                         <th></th>
                       </tr>
                    </thead>
                    <tbody>
    <%
        i = 0;
        for (Job job : jobs) {
            out.print("<tr id='j" + i + "'>");
            out.print("<th>" + job.getNom() + "</th>");
            Utilisateur user = Utilisateur.getByCode(con, job.getUserCode());
            out.print("<th>" + user.getNom() + " " + user.getPrenom() + "</th>");
            out.print("<th >" + job.getDateRealisation()+ "</th>");
            out.print("<th >" + job.getEtat()+ "</th>");
            out.print("<th>");
            out.print("<div class='ui-grid-a'>");
            out.print("<div class='ui-block-a'>");
            out.print("<a href='#popupJobRead' nom='jobRead' num='" + i + "' data-rel='popup' "); 
            out.print("data-position-to='window' class='ui-btn ui-btn-b ui-icon-eye ui-corner-all ui-btn-icon-notext'>Détails</a></div>");
            out.print("<div class='ui-block-b'>");
            out.print("<a href='#popupJobDelete' nom='jobDelete' num='" + i + "' data-rel='popup' "); 
            out.print("data-position-to='window' class='ui-btn ui-btn-b ui-icon-delete ui-corner-all ui-btn-icon-notext'>Supprimer</a></div>");
            out.print("</th>");
            out.print("</tr>");
            i++;
        }
    %>
                    </tbody>
                </table>
                </center>
                </div>
               
            <div id="popupJobRead" data-role="popup" class="ui-corner-all ui-alt-icon"
                                data-corners="true" data-position-to="window">
                <div class="mesPopups" align="center">
                    <h3>Job :</h3>
                    <label id='jrNom'></label>
                    <label id='jrDateRealisation'></label>
                    <label id='jrEtat'></label>
                    <label id='jrDureeConsommee'></label>
                    <label id='jrResteAFaire'></label>
                    <label id='jrSupportConsomme'></label>
                    <label id='jrMatiereConsommee'></label>
                    <label id='jrSupportEstime'></label>
                    <label id='jrMatiereEstimee'></label>
                    <label id='jrPrix'></label>
                </div>
            </div>
               
            <div id="popupJobDelete" data-role="popup" class="ui-corner-all ui-alt-icon"
                 style="max-width:400px;" data-corners="true" data-position-to="window">
                <div  class="mesPopups" align="center">
                    <h3>Confirmez-vous la suppression définitive du suivi de ce job ?</h3>
                    <label id='jdNom'></label>
                    <label id='jdDateRealisation'></label>
                    <label id='jdEtat'></label>
                    <p hidden id="jdNum"></p><br>
                    <button id="btnJobDelete" class="ui-btn ui-btn-b ui-corner-all ">Oui</button>
                </div>
            </div>
            
            <!-- popup message en mode modal-->
            <div id="popupSendCmd" data-role="popup" data-theme="a" data-overlay-theme="b"
                           class="ui-corner-all ui-alt-icon" data-corners="true" 
                           data-position-to="window" data-dismissible="false">
                <div class="mesPopups" align="center">
                    <br/>
                    <h3 id="popupTextSendCmd">Attendez !</h3>
                    <div class="progressBar"><div></div></div>
                    <button id="btnCmdClose" class="ui-btn ui-btn-b ui-corner-all ">Ok</button>
                    <br/>
                </div>
            </div>
            
        </div>
    </body>
</html>