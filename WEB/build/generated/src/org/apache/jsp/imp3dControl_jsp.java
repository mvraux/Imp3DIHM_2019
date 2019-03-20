package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import com.persistence.*;
import com.metier.*;

public final class imp3dControl_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
