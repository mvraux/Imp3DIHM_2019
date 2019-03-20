<%-- 
    Document     : imp3D.jsp 
    Description  : Contr�leur du site (mod�le MVC)
        Toute les requ�tes utilisateur passe par ce contr�leur avec en 
            param�tre l'action � r�aliser.
        Le contr�le se fait suivant l'�tat du user : responsable ou maintenance
        Il donne acc�s aux pages contenues dans le r�pertoire WEB-INF
            r�pertoire non accessible du Web pour des raisons de s�curit�.
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.*"%>
<%@page import="com.metier.*"%>

<%
    Connection con = (Connection) session.getAttribute("con");
    if (con == null) {
        con = ConnexionMySQL.newConnexion();
    }
    session.setAttribute("con", con);

    // traitement des actions possibles
    String action = request.getParameter("action");
    User user = (User) session.getAttribute("user");
    String callBackType = request.getParameter("callBackType");
    
    // URL tap� � la main ! Impossible normalement.
    if (action == null) {
       request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    // --------------------------------------------------------------------
    //               Traitement des callbacks
    // --------------------------------------------------------------------
    else if (callBackType != null) {
         request.getRequestDispatcher("WEB-INF/callback.jsp").forward(request, response);
    }                  
    else if (user == null) {    // user non connect�
        if (action.equals("login_req")) {
            request.getRequestDispatcher("WEB-INF/login_req.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } else {    // user connect�
        if (user.getRole().equals("operateur")) {
            if (action == null) {           // rafraichissement de la page courante
                request.getRequestDispatcher("WEB-INF/o_accueil.jsp").forward(request, response);
            }
            else if (action.equals("accueil")) {
                request.getRequestDispatcher("WEB-INF/o_accueil.jsp").forward(request, response);
            }
            else {  // rafraichissement de la page
                request.getRequestDispatcher("WEB-INF/o_accueil.jsp").forward(request, response);
            }
        }
        else {
            if (action == null) {           // rafraichissement de la page courante
                request.getRequestDispatcher("WEB-INF/u_accueil.jsp").forward(request, response);
            }
            else if (action.equals("accueil")) {
                request.getRequestDispatcher("WEB-INF/u_accueil.jsp").forward(request, response);
            } 
            else {  // rafraichissement de la page
                request.getRequestDispatcher("WEB-INF/u_accueil.jsp").forward(request, response);
            }
        }
    }
%>
