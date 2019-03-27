package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.persistence.ConnexionMySQL;
import java.sql.Connection;
import com.persistence.User;

public final class u_005faccueil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/includes/header.jspf");
    _jspx_dependants.add("/includes/footer.jspf");
  }

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Accueil</title> \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1, maximum-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\"/>\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\"/>\r\n");
      out.write("<link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon-57x57.png\"/>\r\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"images/apple-touch-icon-72x72.png\"/>\r\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"images/apple-touch-icon-114x114.png\"/>\r\n");
      out.write("<link rel=\"icon\" href=\"images/apple-touch-icon-57x57.png\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"js/jquery.mobile/jquery.mobile-1.4.5.min.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/themes/jquery.mobile.icons.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/imp3DTheme.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/imp3D.css?");
 out.print(System.currentTimeMillis()); 
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.mobile/jquery.mobile-1.4.5.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        ");
 
            Connection con = (Connection) session.getAttribute("con");
            if (con == null)
                con = ConnexionMySQL.newConnexion();
            session.setAttribute("con", con);
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <div data-role=\"page\" id=\"page1\">\r\n");
      out.write("            \r\n");
      out.write("            <div role=\"main\" class=\"ui-content\">\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer\" data-role=\"footer\" data-theme=\"a\" data-tap-toggle=\"false\"\r\n");
      out.write("            data-id=\"main-footer\" data-position=\"fixed\" data-fullscreen=\"true\">\r\n");
      out.write("    ");
 
        User user1 = (User) session.getAttribute("user");
        // y a t'il eu connexion ?
        if (user1 != null) {
            if (user1.getRole().equals("responsable")) {
                out.println("<div data-role='navbar' data-grid='d'>");
                out.println("<ul>");
                out.println("<li><a href='imp3DControl.jsp?action=accueil' data-ajax='false' id='navbarhome' data-icon='home'>Accueil</a></li>");
                out.println("<li><a href='imp3DControl.jsp?action=localisation' data-ajax='false' id='navbarSuivi' data-icon='location'>Localisation</a></li>");
                out.println("<li><a href='imp3DControl.jsp?action=infos' data-ajax='false' id='navbarInfos' data-icon='info'>Infos</a></li>");
                out.println("<li><a href='imp3DControl.jsp?action=statistiques' data-ajax='false' id='navbarStatistiques' data-icon='bars'>Statistiques</a></li>");
                out.println("<li><a href='imp3DControl.jsp?action=gestion' data-ajax='false' id='navbarGestion' data-icon='edit'>Gestion</a></li>");
                out.println("</ul>");
                out.println("</div>");
            }
            else {        // 4 menus
                out.println("<div data-role='navbar' data-grid='c'>"); 
                out.println("<ul>");
                out.println("<li><a href='imp3DControl.jsp?action=accueil' data-ajax='false' id='navbarhome' data-icon='home'>Accueil</a></li>");
                out.println("<li><a href='imp3DControl.jsp?action=localisation' data-ajax='false' id='navbarSuivi' data-icon='location'>Localisation</a></li>");
                out.println("<li><a href='imp3DControl.jsp?action=infos' data-ajax='false' id='navbarInfos' data-icon='info'>Infos</a></li>");
                out.println("<li><a href='imp3DControl.jsp?action=maintenance' data-ajax='false' id='navbarMaintenance' data-icon='gear'>Maintenance</a></li>");
                out.println("</ul>");
                out.println("</div>");
            }
        }
    
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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