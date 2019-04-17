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
        String strtemperature = request.getParameter("TP");//Température du fablab
        double temperature = Double.parseDouble(strtemperature);
        String strhumidite = request.getParameter("HY");//Hygrométrie du fablab
        double humidite =Double.parseDouble(strhumidite);
        fablabtest.saveTempHygro(temperature, humidite);//ajouter les données à la base de données
    }
    if (callBackType.equals("etat_cartouches")) {
        String idtypema = request.getParameter("MT");//Identifiant du type de la cartouche de matière
        String strdateremplacement = request.getParameter("RM");//Date de remplacement de la cartouche de matière sur la machine
        Timestamp dateremplacement = Utils.stringToTimestamp(strdateremplacement);//Convertion string vers timestamp
        String strdatefabrmat = request.getParameter("DM");//Date de fabrication de la cartouche de matière
        Timestamp datefabrmat = Utils.stringToTimestamp(strdatefabrmat);//Conversion de String vers timestamp
        String numseriemat = request.getParameter("SM");//Numéro de serie de la cartouche de matière
        String strquantitemat = request.getParameter("QM");//Quantité de matière restante sur la machine 
        Float quantitematiere = Float.parseFloat(strquantitemat);//Conversion du String au Float
        String idtypesupp = request.getParameter("SP");//Identifiant du type de la cartouche de support
        String strdateremp = request.getParameter("RS");//Date de remplacement de la cartouche de support sur la machine
        Timestamp dateremp = Utils.stringToTimestamp(strdateremp);//Conversion de String vers timestamp
        String strdatefabrsupp = request.getParameter("DS");//Date de fabricatrion  de la cartouche de support
        Timestamp datefabrsupp = Utils.stringToTimestamp(strdatefabrsupp);//Conversion de String vers timestamp
        String numseriesupp = request.getParameter("SS");//Numéro de série de la cartouche de support
        String strsupprest = request.getParameter("QS");//Quantité de support restante sur la cartouche
        Float supprest = Float.parseFloat(strsupprest);//conversion du String au Float
        fablabtest.saveCartouches(idtypema,dateremplacement,datefabrmat,numseriemat,quantitematiere,idtypesupp,dateremp,datefabrsupp,numseriesupp,supprest); //ajouter les données à la base de données
    }
    if (callBackType.equals("etat_job")) {
        String ndj = request.getParameter("JB");//Nom du job
        String iduser = request.getParameter("ID");//Id de l'utilisateur
        String strtcons = request.getParameter("TC");//Temps consommé
        double tcons = Double.parseDouble(strtcons);//Conversion string vers double
        String strtrest = request.getParameter("TR");//Estimation du travail restant
        double trest = Double.parseDouble(strtrest);//Conversion string vers double
        String status = request.getParameter("ST");//Status du travail
        String strsuppnec = request.getParameter("ES");//Estimation de la quantité de support necessaire pour le job,Quantitée estimée
        int suppnec = Integer.parseInt(strsuppnec);//Conversion string vers int
        String strquannec = request.getParameter("EM");//Estimation de la quantité de matière nécessaire pour le job,Quantitée estimée
        int quannec = Integer.parseInt(strquannec);//Conversion string vers int
        String strquansucon = request.getParameter("SC");//Quantité de support déja consommé
        int quansucon = Integer.parseInt(strquansucon);//Conversion string vers int
        String strquanmatcon = request.getParameter("MC");//Quantité de matiere déja consommé
        int quanmatcon = Integer.parseInt(strquanmatcon);//Conversion string vers int
        fablabtest.saveJob(ndj,iduser,tcons,trest,status,suppnec,quannec,quansucon,quanmatcon); //ajouter les données à la base de données
    }

    // etc ...
%>