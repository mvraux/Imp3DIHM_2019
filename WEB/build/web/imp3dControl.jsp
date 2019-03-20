<%-- 
    Document     : imp3D.jsp 
    Description  : Contrôleur du site (modèle MVC)
        Toute les requêtes utilisateur passe par ce contrôleur avec en 
            paramètre l'action à réaliser.
        Le contrôle se fait suivant l'état du user : responsable ou maintenance
        Il donne accès aux pages contenues dans le répertoire WEB-INF
            répertoire non accessible du Web pour des raisons de sécurité.
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
    
    // URL tapé à la main ! Impossible normalement.
    if (action == null) {
       request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    // --------------------------------------------------------------------
    //               Traitement des callbacks
    // --------------------------------------------------------------------
    else if (callBackType != null) {
         request.getRequestDispatcher("WEB-INF/callback.jsp").forward(request, response);
    }                  
    else if (user == null) {    // user non connecté
        if (action.equals("login_req")) {
            request.getRequestDispatcher("WEB-INF/login_req.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } else {    // user connecté
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
