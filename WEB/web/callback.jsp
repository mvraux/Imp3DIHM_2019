<%-- 
    Document    : callback.jsp
    Description : page de gestion des 3 �v�nements en provenance de l'imprimante
    Created on  : F�vrier 2019
    Author      : Fabre
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>
<%@page import="java.sql.Timestamp"%>

<%--

--%>

<%
    Connection con = (Connection) session.getAttribute("con");
    if (con == null) {
        con = ConnexionMySQL.newConnexion();
        session.setAttribute("con", con);
    }
    String callBackType = request.getParameter("callBackType");
    if (callBackType.equals("temp_hygro")) {
        String strtemperature = request.getParameter("TP");//Temp�rature du fablab
        double temperature = Double.parseDouble(strtemperature);
        String strhumidite = request.getParameter("HY");//Hygrom�trie du fablab
        double humidite =Double.parseDouble(strhumidite);
        //ajouter les donn�es � la base de donn�es
        Ambiance nouveau = Ambiance.create(con, "FabLab_Victor_Hugo",temperature, humidite, Utils.getDateDuJour());
    }
    if (callBackType.equals("etat_cartouches")) {
        String idTypeMat = request.getParameter("MT");//Identifiant du type de la cartouche de mati�re
        String strDateRempMat = request.getParameter("RM");//Date de remplacement de la cartouche de mati�re sur la machine
        Timestamp dateRempMat = Utils.stringToTimestamp(strDateRempMat);//Convertion string vers timestamp
        String strDateFabMat = request.getParameter("DM");//Date de fabrication de la cartouche de mati�re
        Timestamp dateFabMat = Utils.stringToTimestamp(strDateFabMat);//Conversion de String vers timestamp
        String numSerieMat = request.getParameter("SM");//Num�ro de serie de la cartouche de mati�re
        String strQuantiteMat = request.getParameter("QM");//Quantit� de mati�re restante sur la machine 
        Float quantiteMat = Float.parseFloat(strQuantiteMat);//Conversion du String au Float
        
        String idTypeSup = request.getParameter("SP");//Identifiant du type de la cartouche de support
        String strDateRempSup = request.getParameter("RS");//Date de remplacement de la cartouche de support sur la machine
        Timestamp dateRempSup = Utils.stringToTimestamp(strDateRempSup);//Conversion de String vers timestamp
        String strDateFabSup = request.getParameter("DS");//Date de fabricatrion  de la cartouche de support
        Timestamp dateFabSup = Utils.stringToTimestamp(strDateFabSup);//Conversion de String vers timestamp
        String numSerieSup = request.getParameter("SS");//Num�ro de s�rie de la cartouche de support
        String strQuantiteSup = request.getParameter("QS");//Quantit� de support restante sur la cartouche
        Float quantiteSup = Float.parseFloat(strQuantiteSup);//conversion du String au Float
        // Cartouche de mati�re pour la pi�ce
        // Si c'est la cartouche de mati�re en cours, on la met � jour
        // si ce n'est pas la m�me, on remplace les infos
        Cartouche cartoucheMat = Cartouche.getByNumero(con, numSerieMat);
        if (cartoucheMat == null) {
            cartoucheMat.setIndentifiantType(idTypeMat);
            cartoucheMat.setQuantiteRestante(quantiteMat);
            cartoucheMat.setDateFabrication(dateFabMat);
            cartoucheMat.setDateRemplacement(dateRempMat);
            cartoucheMat.setNumeroDeSerie(numSerieMat);
            cartoucheMat.setCoutaucm3(100);
            cartoucheMat.save(con);
        }
        else {
            cartoucheMat.setQuantiteRestante(quantiteMat);
            cartoucheMat.save(con);
        }
        // Cartouche support (m�me chose que pour l'autre cartouche
        Cartouche cartoucheSup = Cartouche.getByNumero(con, numSerieSup);
        if (cartoucheSup == null) {
            cartoucheSup.setIndentifiantType(idTypeSup);
            cartoucheSup.setQuantiteRestante(quantiteSup);
            cartoucheSup.setDateFabrication(dateFabSup);
            cartoucheSup.setDateRemplacement(dateRempSup);
            cartoucheSup.setNumeroDeSerie(numSerieSup);
            cartoucheSup.setCoutaucm3(30);
            cartoucheSup.save(con);
        }
        else {
            cartoucheSup.setQuantiteRestante(quantiteSup);
            cartoucheSup.save(con);
        }
    }
    if (callBackType.equals("etat_job")) {
        String ndj = request.getParameter("JB");//Nom du job
        String idUser = request.getParameter("ID");//Id de l'utilisateur
        String strtCons = request.getParameter("TC");//Temps consomm�
        int tCons = Integer.parseInt(strtCons);//Conversion string vers int
        String strtRest = request.getParameter("TR");//Estimation du travail restant
        int tRest = Integer.parseInt(strtRest);//Conversion string vers int
        String status = request.getParameter("ST");//Status du travail
        String strSuppNec = request.getParameter("ES");//Estimation de la quantit� de support necessaire pour le job,Quantit�e estim�e
        double suppNec = Double.parseDouble(strSuppNec);//Conversion string vers double
        String strQuanNec = request.getParameter("EM");//Estimation de la quantit� de mati�re n�cessaire pour le job,Quantit�e estim�e
        double quanNec = Double.parseDouble(strQuanNec);//Conversion string vers double
        String strQuanSuCon = request.getParameter("SC");//Quantit� de support d�ja consomm�
        double quanSuCon = Double.parseDouble(strQuanSuCon);//Conversion string vers double
        String strQuanMatCon = request.getParameter("MC");//Quantit� de matiere d�ja consomm�
        double quanMatCon = Double.parseDouble(strQuanMatCon);//Conversion string vers double
        // si job en cours on le met � jour
        // si nouveau job on le cr�e
        Job job = Job.getByNom(con, ndj);
        if (job == null) {
            // avant il faut changer l'�tat du job en cours
            Job jobEnCours = Job.getJobEnCours(con);
            if (tRest == 0) {
                jobEnCours.setEtat("FINI");
                jobEnCours.save(con);
            }
            // userCode, nom, dateRealisation, etat, dureeConsommee, resteAFaire, 
            // supportConsomme, matiereConsommee, supportEstime, matiereEstimee, 
            // prix, imprimante3dNom).create(con, "FabLab_Victor_Hugo", dateRemplacement, 
            Job.create(con,idUser,ndj,Utils.getDateDuJour(),"EN_COURS",tCons,tRest,
                quanSuCon,quanMatCon,suppNec,quanNec,0,"FabLab_Victor_Hugo");
        }
        else {
            job.setDureeConsommee(tCons);
            job.setResteAFaire(tRest);
            job.setSupportEstime(suppNec);
            job.setMatiereEstimee(quanNec);
            job.setSupportConsomme(quanSuCon);
            job.setMatiereConsommee(quanMatCon);
            job.save(con);
        }
        
    }

    // etc ...
%>