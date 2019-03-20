<%-- 
    Document   : cbTempHygro.jsp
    Created on : 9 Mars 2019
    Author     : snir2
--%>

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
    // etc ...
%>