<%-- 
    Document    : o_accueil.jsp
    Description : page accueil de l'opérateur de maintenance
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
        <title>Accueil Opérateur</title> 
        <%@ include file="includes/header.jspf" %>
    </head>
    <body>
    <%
        Connection con = (Connection) session.getAttribute("con");
        if (con == null) {
            con = ConnexionMySQL.newConnexion();
            session.setAttribute("con", con);
        }
        Operateur operateur = (Operateur) session.getAttribute("operateur");
        // on se protège d'un accès illicite à cette page
        if (operateur == null) { 
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    %>
        <div data-role="page" id="page1">
            <script type="text/javascript" src="js/imp3D.js"></script>
            <div class="header" data-role="header" data-theme="b" data-position="fixed">
                <h1><%out.print(operateur.getNom() + " " + operateur.getPrenom());%></h1>
                <a href="index.jsp" class="ui-btn-right">Déconnexion</a>
            </div>
            <div role="main" class="ui-content"><br/><br/><br/>
    <script type="text/javascript">
    <%
        
        ArrayList<Operateur> operateurs = Operateur.getListeDesOperateurs(con);
        out.print("operateurs  = [");
        int i = 0;
        for (Operateur op : operateurs) {
            if (i > 0)
                out.print(",");
            out.print("{");
            out.print("nom: '" + op.getNom() + "',");
            out.print("prenom: '" + op.getPrenom() + "',");
            out.print("mail: '" + op.getMail() + "'");
            out.print("}");
            i++;
        }
        out.print("];");
        
        ArrayList<Utilisateur> utilisateurs = Utilisateur.getListeDesUtilisateurs(con);
        
        // On fabrique un source javascript qui fera parti de la page envoyée
        // On init les variables JS utilisateurs, opérateurs et jobs avec 
        // les données de la BD
        out.print("utilisateurs  = [");
        i = 0;
        for (Utilisateur user : utilisateurs) {
            if (i > 0)
                out.print(",");
            out.print("{");
            out.print("nom: '" + user.getNom() + "',");
            out.print("prenom: '" + user.getPrenom() + "',");
            out.print("code: '" + user.getCode() + "',");
            out.print("mail: '" + user.getMail() + "',");
            if (user.isMailValide())
                out.print("mailValide: 'Oui',");
            else
                out.print("mailValide: 'Non',");
            out.print("etablissement: '" + user.getEtablissement() + "',");
            out.print("dateInscription: '" + user.getDateInscription() + "',");
            out.print("nbJobsRealises: " + user.getNbJobsRealises() + ",");
            out.print("nbEchecs: " + user.getNbEchecs());
            out.print("}");
            i++;
        }
        out.print("];");
        
        ArrayList<Job> jobs = Job.getListeDesJobs(con);
        out.print("jobs  = [");
        i = 0;
        for (Job jb : jobs) {
            if (i > 0)
                out.print(",");
            out.print("{");
            out.print("nom: '" + jb.getNom() + "',");
            out.print("utilisateur: '" + jb.getUserCode() + "',");
            out.print("dateRealisation: '" + jb.getDateRealisation() + "',");
            out.print("etat: '" + jb.getEtat() + "',");
            out.print("dureeConsommee: " + jb.getDureeConsommee() + ",");
            out.print("resteAFaire: " + jb.getResteAFaire() + ",");
            out.print("supportConsomme: " + jb.getSupportConsomme() + ",");
            out.print("matiereConsommee: " + jb.getMatiereConsommee() + ",");
            out.print("supportEstime: " + jb.getSupportEstime() + ",");
            out.print("matiereEstimee: " + jb.getMatiereEstimee() + ",");
            out.print("prix: " + jb.getPrix());
            out.print("}");
            i++;
        }
        out.print("];");
    %>
    </script>
                <center>
                <h2>Liste des Opérateurs</h2>
                <table data-role="table" id="listOperateurs" class="ui-responsive table">
                    <thead>
                       <h3>Opérateur</h3>
                       <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Mail</th>
                        <th></th>
                       </tr>
                    </thead>
                    <tbody>
    <%
        // remplissage de la liste des operateurs dans la page courante
        i = 0;
        for (Operateur op : operateurs) {
            out.print("<tr id='o" + i + "'>");
            out.print("<th>" + op.getNom() + "</th>");
            out.print("<th>" + op.getPrenom()+ "</th>");
            out.print("<th>" + op.getMail() + "</th>");
            if (i > 0) {    // on ne peut pas supprimer le 1er
                out.print("<th>");
                out.print("<a href='#popupOperateurDelete' nom='operateurDelete' num='" + i +  "' data-rel='popup' "); 
                out.print("data-position-to='window' class='ui-btn ui-btn-b ui-icon-delete ui-corner-all ui-btn-icon-notext'>Supprimer</a>");
                out.print("</th>");
            }
            else {
                // améliore le visuel du 1er opérateur
                out.print("<tr><th></th></tr>");
            }
            out.print("</tr>");
            i++;
        }
    %>
                    </tbody>
                </table>
                <a href="#popupOperateurCreate" data-rel="popup" data-position-to="window" 
                   class="ui-btn ui-corner-all ui-shadow ui-btn-inline 
                   ui-icon-check ui-btn-icon-left ui-btn-a" 
                   data-transition="pop">Créer un opérateur</a>
                <br/><br/>
                
                <h2>Liste des Utilisateurs</h2>
                <table data-role="table" id="listeUtilisateurs" class="ui-responsive table">
                    <thead>
                        <tr> 
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Code</th>
                        <th>Mail</th>
                        <th></th>
                        </tr>
                    </thead>
                    
                    <tbody>
    <%
        // remplissage de la liste des utilisateurs dans la page courante
        i = 0;
        for (Utilisateur user : utilisateurs) {
            out.print("<tr id='u" + i + "'>");
            out.print("<th>" + user.getNom() + "</th>");
            out.print("<th>" + user.getPrenom()+ "</th>");
            out.print("<th>" + user.getCode()+ "</th>");
            out.print("<th>" + user.getMail() + "</th>");
            out.print("<th>");
            out.print("<div class='ui-grid-a'>");
            out.print("<div class='ui-block-a'>");
            out.print("<a href='#popupUserRead' nom='userRead' num='" + i + "' data-rel='popup' "); 
            out.print("data-position-to='window' class='ui-btn ui-btn-b ui-icon-eye ui-corner-all ui-btn-icon-notext'>Détails</a></div>");
            out.print("<div class='ui-block-b'>");
            out.print("<a href='#popupUserDelete' nom='userDelete' num='" + i + "' data-rel='popup' "); 
            out.print("data-position-to='window' class='ui-btn ui-btn-b ui-icon-delete ui-corner-all ui-btn-icon-notext'>Supprimer</a></div>");
            out.print("</th>");
            out.print("</tr>");
            i++;
        }
    %>      
                    </tbody>
                </table>
                <br/><br/>
                
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
            
            <div id="popupUserRead" data-role="popup" class="ui-corner-all ui-alt-icon"
                                data-corners="true" data-position-to="window">
                <div class="mesPopups" align="center">
                    <h3>Utilisateur :</h3>
                    <label id='urNom'></label>
                    <label id='urPrenom'></label>
                    <label id='urMail'></label>
                    <label id='urMailValide'></label>
                    <label id='urEtablissement:'></label>
                    <label id='urDateInscription'></label>
                    <label id='urNbJobsRealises'></label>
                    <label id='urNbEchecs'></label>
                </div>
            </div>
            
            <div id="popupUserDelete" data-role="popup" class="ui-corner-all ui-alt-icon"
                 style="max-width:400px;" data-corners="true" data-position-to="window">
                <div  class="mesPopups" align="center">
                    <h3>Confirmez-vous la suppression définitive de cet utilisateur ?</h3>
                    <label id='udNom'></label>
                    <label id='udPrenom'></label>
                    <label id='udMail'></label>
                    <p hidden id="udNum"></p><br>
                    <button id="btnUserDelete" class="ui-btn ui-btn-b ui-corner-all ">Oui</button>
                </div>
             </div>

            <div id="popupOperateurCreate" data-role="popup" class="ui-corner-all ui-alt-icon">
                <form>
                    <div class="mesPopups" align="center">
                        <h3>Entrez le nouvel opérateur</h3>
                        <label for="ocNom" class="ui-hidden-accessible">Nom :</label>
                        <input name="ocNom" id="ocNom" type="text" required value="" placeholder="Nom" data-theme="a">
                        <label for="ocPrenom" class="ui-hidden-accessible">Prénom :</label>
                        <input name="ocPrenom" id="ocPrenom" type="text" required value="" placeholder="Prénom" data-theme="a">
                        <label for="ocMail" class="ui-hidden-accessible">Mail :</label>
                        <input name="ocMail" id="ocMail" type="email" required value=" " placeholder="Mail" data-theme="a">
                        <label for="ocPwd" class="ui-hidden-accessible">Mot de passe :</label>
                        <input name="ocPwd" id="ocPwd" type="password" required value="" placeholder="password" data-theme="a">
                        <button id="ocValider" class="ui-btn ui-corner-all ui-shadow ui-btn-b ui-btn-icon-left ui-icon-check">Créer l'opérateur</button>
                    </div>
                </form>
            </div>
            
            <div id="popupOperateurDelete" data-role="popup" class="ui-corner-all ui-alt-icon"
                 style="max-width:400px;" data-corners="true" data-position-to="window">
                <div  class="mesPopups" align="center">
                    <h3>Confirmez-vous la suppression définitive de cet opérateur ?</h3>
                    <label id='odNom'></label>
                    <label id='odPrenom'></label>
                    <label id='odMail'></label>
                    <p hidden id="odNum"></p><br>
                    <button id="btnOperateurDelete" class="ui-btn ui-btn-b ui-corner-all ">Oui</button>
                </div>
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
                    <h3>Confirmez-vous la suppression du suivi de ce job ?</h3>
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
                    <div id="progressBar"><div></div></div>
                    <button id="btnCmdClose" class="ui-btn ui-btn-b ui-corner-all ">Ok</button>
                    <br/>
                </div>
            </div>
            
        </div>
    </body>
</html>