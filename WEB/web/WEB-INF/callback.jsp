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
        fablabtest.saveTempHygro(temperature, humidite);//ajouter les donn�es � la base de donn�es
    }
    if (callBackType.equals("etat_cartouches")) {
        String idtypema = request.getParameter("MT");//Identifiant du type de la cartouche de mati�re
        String strdateremplacement = request.getParameter("RM");//Date de remplacement de la cartouche de mati�re sur la machine
        Timestamp dateremplacement = Utils.stringToTimestamp(strdateremplacement);//Convertion string vers timestamp
        String strdatefabrmat = request.getParameter("DM");//Date de fabrication de la cartouche de mati�re
        Timestamp datefabrmat = Utils.stringToTimestamp(strdatefabrmat);//Conversion de String vers timestamp
        String numseriemat = request.getParameter("SM");//Num�ro de serie de la cartouche de mati�re
        String strquantitemat = request.getParameter("QM");//Quantit� de mati�re restante sur la machine 
        Float quantitematiere = Float.parseFloat(strquantitemat);//Conversion du String au Float
        String idtypesupp = request.getParameter("SP");//Identifiant du type de la cartouche de support
        String strdateremp = request.getParameter("RS");//Date de remplacement de la cartouche de support sur la machine
        Timestamp dateremp = Utils.stringToTimestamp(strdateremp);//Conversion de String vers timestamp
        String strdatefabrsupp = request.getParameter("DS");//Date de fabricatrion  de la cartouche de support
        Timestamp datefabrsupp = Utils.stringToTimestamp(strdatefabrsupp);//Conversion de String vers timestamp
        String numseriesupp = request.getParameter("SS");//Num�ro de s�rie de la cartouche de support
        String strsupprest = request.getParameter("QS");//Quantit� de support restante sur la cartouche
        Float supprest = Float.parseFloat(strsupprest);//conversion du String au Float
        fablabtest.saveCartouches(idtypema,dateremplacement,datefabrmat,numseriemat,quantitematiere,idtypesupp,dateremp,datefabrsupp,numseriesupp,supprest); //ajouter les donn�es � la base de donn�es
    }
    if (callBackType.equals("etat_job")) {
        String ndj = request.getParameter("JB");//Nom du job
        String iduser = request.getParameter("ID");//Id de l'utilisateur
        String strtcons = request.getParameter("TC");//Temps consomm�
        double tcons = Double.parseDouble(strtcons);//Conversion string vers double
        String strtrest = request.getParameter("TR");//Estimation du travail restant
        double trest = Double.parseDouble(strtrest);//Conversion string vers double
        String status = request.getParameter("ST");//Status du travail
        String strsuppnec = request.getParameter("ES");//Estimation de la quantit� de support necessaire pour le job,Quantit�e estim�e
        int suppnec = Integer.parseInt(strsuppnec);//Conversion string vers int
        String strquannec = request.getParameter("EM");//Estimation de la quantit� de mati�re n�cessaire pour le job,Quantit�e estim�e
        int quannec = Integer.parseInt(strquannec);//Conversion string vers int
        String strquansucon = request.getParameter("SC");//Quantit� de support d�ja consomm�
        int quansucon = Integer.parseInt(strquansucon);//Conversion string vers int
        String strquanmatcon = request.getParameter("MC");//Quantit� de matiere d�ja consomm�
        int quanmatcon = Integer.parseInt(strquanmatcon);//Conversion string vers int
        fablabtest.saveJob(ndj,iduser,tcons,trest,status,suppnec,quannec,quansucon,quanmatcon); //ajouter les donn�es � la base de donn�es
    }

    // etc ...
%>