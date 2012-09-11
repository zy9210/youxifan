package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.youxifan.pojo.*;
import org.apache.commons.lang3.StringUtils;

public final class ask_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/include/head.jsp");
    _jspx_dependants.add("/include/contentHeader.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String contextPath = (String)request.getContextPath();
pageContext.setAttribute("contextPath",contextPath);

      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html> \r\n");
      out.write("<head> \r\n");
      out.write("    <title>ask - youxifan</title> \r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://cdn.sstatic.net/js/stub.js?v=c014461b9109\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(contextPath );
      out.write("/css/all.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"questions-page\">\r\n");
      out.write("    <noscript><div id=\"noscript-padding\"></div></noscript>\r\n");
      out.write("    <div id=\"notify-container\"></div>\r\n");
      out.write("    <div id=\"overlay-header\"></div>\r\n");
      out.write("    <div id=\"custom-header\"></div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div id=\"header\">\r\n");
      out.write("            <div id=\"topbar\">  \r\n");
      out.write("            </div>  \r\n");
      out.write("            <div id=\"hmenus\">\r\n");
      out.write("                <div class=\"nav mainnavs\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li class=\"youarehere\"><a id=\"nav-questions\" href=\"");
      out.print(contextPath );
      out.write("/s/doc\">问题</a></li>\r\n");
      out.write("                        <li><a id=\"nav-tags\" href=\"/tags\">Tags</a></li>\r\n");
      out.write("                        <li><a id=\"nav-users\" href=\"/users\">Users</a></li>\r\n");
      out.write("                        <li><a id=\"nav-badges\" href=\"/badges\">Badges</a></li>\r\n");
      out.write("                        <li><a id=\"nav-unanswered\" href=\"/unanswered\">Unanswered</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t        <div id=\"mainbar\" class=\"ask-mainbar\">  \r\n");
      out.write("\t        \t\r\n");
      out.write("\t        \t<div class=\"subheader\">\r\n");
      out.write("\t\t\t\t\t<h1>提问</h1>\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t    \t\t<form id=\"post-form\" class=\"post-form\" action=\"");
      out.print(contextPath );
      out.write("/s/doc\" method=\"post\">\r\n");
      out.write("\t        \t\t<input type=\"hidden\" name=\"doctype\" value=\"1\"  />\r\n");
      out.write("\t        \t\t<label  >标题</label><br/>\r\n");
      out.write("\t        \t\t<input id=\"title\" name=\"title\" type=\"text\" maxlength=\"300\" tabindex=\"100\" class=\"ask-title-field\" value=\"\"><br/>\r\n");
      out.write("\t        \t\t<label  >内容</label><br/>\r\n");
      out.write("\t        \t\t<textarea id=\"wmd-input\" class=\"wmd-input\" name=\"post-text\" cols=\"92\" rows=\"15\" tabindex=\"101\">\r\n");
      out.write("\t\t\t\t\t</textarea>\r\n");
      out.write("\t        \t\t\r\n");
      out.write("\t        \t\t\r\n");
      out.write("\t        \t\t<div class=\"form-item\">\r\n");
      out.write("\t        \t\t\t<label>Tags</label>  \r\n");
      out.write("\t        \t\t\t<input id=\"tagnames\" name=\"tagnames\" type=\"text\" size=\"60\" value=\"\" tabindex=\"103\">\r\n");
      out.write("\t        \t\t\t<span class=\"edit-field-overlay\">at least one tag such as (c++ sql-server c), max 5 tags</span>\r\n");
      out.write("\t        \t\t</div>\r\n");
      out.write("\t        \t\t\r\n");
      out.write("\t        \t\t<div class=\"form-submit cbt\">\r\n");
      out.write("\t        \t\t<input id=\"submit-button\" type=\"submit\" value=\"提交\" tabindex=\"120\">\r\n");
      out.write("\t        \t\t</div>\r\n");
      out.write("\t        \t</form>\r\n");
      out.write("\t        </div> \r\n");
      out.write("\t        \r\n");
      out.write("\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<div id=\"sidebar\" class=\"ask-sidebar\">\r\n");
      out.write("\t\t\t\t<div class=\"module\" id=\"questions-count\">\r\n");
      out.write("\t\t\t\t\t<div class=\"summarycount al\">305</div>\r\n");
      out.write("\t\t\t\t\t<p>questions</p>\r\n");
      out.write("\t\t\t\t</div>   \r\n");
      out.write("\t\t\t\t<div class=\"everyonelovesstackoverflow\" id=\"adzerk2\">\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"module\" id=\"related-tags\">\r\n");
      out.write("\t\t\t\t\t<h4 id=\"h-related-tags\">Related Tags</h4>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions/tagged/android\" class=\"post-tag\" title=\"show questions tagged 'android'\" rel=\"tag\"><img src=\"http://cdn.sstatic.net/img/hosted/tKsDb.png\" height=\"16\" width=\"18\" alt=\"\" class=\"sponsor-tag-img\">android</a><span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">42</span></span>            <br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions/tagged/c%23\" class=\"post-tag\" title=\"show questions tagged 'c#'\" rel=\"tag\">c#</a><span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">27</span></span>            <br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions/tagged/javascript\" class=\"post-tag\" title=\"show questions tagged 'javascript'\" rel=\"tag\">javascript</a><span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">25</span></span>            <br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions/tagged/java\" class=\"post-tag\" title=\"show questions tagged 'java'\" rel=\"tag\">java</a><span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">24</span></span>            <br> \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"footer\">\r\n");
      out.write("        <div class=\"footerwrap\">\r\n");
      out.write("            <div id=\"footer-menu\">\r\n");
      out.write("                <a href=\"/about\">about</a> |\r\n");
      out.write("                <a href=\"/faq\">faq</a> | <a href=\"http://blog.stackexchange.com?blt=1\">blog</a> |\r\n");
      out.write("                    <a href=\"http://chat.stackoverflow.com\">chat</a> |\r\n");
      out.write("                <a href=\"http://data.stackexchange.com\">data</a> |\r\n");
      out.write("                <a href=\"http://blog.stackoverflow.com/category/podcasts/\">podcast</a> |\r\n");
      out.write("                <a href=\"http://shop.stackexchange.com/\">shop</a> |\r\n");
      out.write("                <a href=\"http://stackexchange.com/legal\">legal</a>\r\n");
      out.write("                <div id=\"footer-sites\">\r\n");
      out.write("                    \r\n");
      out.write("                        <span style=\"color:#FE7A15;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://stackoverflow.com\">stackoverflow.com</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#FE7A15;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://stackapps.com\">api/apps</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#FE7A15;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://careers.stackoverflow.com\">careers</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#E8272C;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://serverfault.com\">serverfault.com</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#00AFEF;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://superuser.com\">superuser.com</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#969696;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://meta.stackoverflow.com\">meta</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#46937D;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://area51.stackexchange.com\">area&nbsp;51</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#C0D0DC;font-size:140%\">&#9632;</span>&nbsp;<a href=\"http://webapps.stackexchange.com\">webapps</a>&nbsp; \r\n");
      out.write("                        <span style=\"color:#000000;font-size:140%\">&#9632;</span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"footer-flair\">\r\n");
      out.write("                <a class=\"peer1\" href=\"http://www.peer1.com/stackoverflow\"></a>  \r\n");
      out.write("                <a href=\"http://creativecommons.org/licenses/by-sa/3.0/\" class=\"cc-wiki-link\"></a>\r\n");
      out.write("                <div id=\"svnrev\">rev 2012.3.7.1488</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"copyright\">\r\n");
      out.write("                site design / logo &copy; 2012 stack exchange inc; \r\n");
      out.write("                user contributions licensed under <a href=\"http://creativecommons.org/licenses/by-sa/3.0/\" rel=\"license\">cc-wiki</a> with <a href=\"http://blog.stackoverflow.com/2009/06/attribution-required/\" rel=\"license\">attribution required</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
