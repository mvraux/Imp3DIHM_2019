<%@page import="java.sql.Connection"%>
<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>

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
        String temperature = request.getParameter("TP");//Temp�rature du fablab
        String humidite = request.getParameter("HY");//Hygrom�trie du fablab
        //fablab.(temperature,humidite) //ajouter les donn�es � la base de donn�es
    }
    if (callBackType.equals("etat_cartouches")) {
        String idtypema = request.getParameter("MT");//Identifiant du type de la cartouche de mati�re
        String dateremplacement = request.getParameter("RM");//Date de remplacement de la cartouche de mati�re sur la machine
        String datefabrmat = request.getParameter("DM");//Date de fabrication de la cartouche de mati�re
        String numseriemat = request.getParameter("SM");//Num�ro de serie de la cartouche de mati�re
        String strquantitemat = request.getParameter("QM");//Quantit� de mati�re restante sur la machine 
        Float quantitematiere = Float.parseFloat(strquantitemat);//Conversion du String au Float
        String idtypesupp = request.getParameter("SP");//Identifiant du type de la cartouche de support
        String dateremp = request.getParameter("RS");//Date de remplacement de la cartouche de support sur la machine
        String datefabrsupp = request.getParameter("DS");//Date de fabricatrion  de la cartouche de support
        String numseriesupp = request.getParameter("SS");//Num�ro de s�rie de la cartouche de support
        String strsupprest = request.getParameter("QS");//Quantit� de support restante sur la cartouche
        Float supprest = Float.parseFloat(strsupprest);//conversion du String au Float
        //fablab.(idtypema,dateremplacement,datefabrmat,numseriemat,quantitematiere,idtypesupp,dateremp,datefabrsupp,numseriesupp,supprest); //ajouter les donn�es � la base de donn�es

    }
    if (callBackType.equals("etat_job")) {
        String ndj = request.getParameter("JB");//Nom du job
        String iduser = request.getParameter("ID");//Id de l'utilisateur
        String strtcons = request.getParameter("TC");//Temps consomm�
        double tcons = Double.parseDouble(strtcons);//Conversion string vers double
        String strtrest = request.getParameter("TR");//Estimation du travail restant
        double trest = Double.parseDouble(strtrest);//Conversion string vers double
        String status = request.getParameter("ST");//Status du travail
        String strsuppnec = request.getParameter("ES");//Estimation de la quantit� de support necessaire pour le job
        double suppnec = Double.parseDouble(strsuppnec);//Conversion string vers double
        String strquannec = request.getParameter("EM");//Estimation de la quantit� de mati�re n�cessaire pour le job
        double quannec = Double.parseDouble(strquannec);//Conversion string vers double
        String strquansucon = request.getParameter("SC");//Quantit� de support d�ja consomm�
        double quansucon = Double.parseDouble(strquansucon);//Conversion string vers double
        String strquanmatcon = request.getParameter("MC");//Quantit� de matiere d�ja consomm�
        double quanmatcon = Double.parseDouble(strquanmatcon);//Conversion string vers double
       //fablab.(ndj,iduser,tcons,trest,status,suppnec,quannec,quansucon,quanmatcon) //ajouter les donn�es � la base de donn�es
    }

    // etc ...
%>