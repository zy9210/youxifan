package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.youxifan.pojo.*;

public final class doc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/view/../include/head.jsp");
    _jspx_dependants.add("/view/../include/contentHeader.jsp");
    _jspx_dependants.add("/view/../include/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Bounty Questions - Stack Overflow</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(contextPath );
      out.write("/css/all.css\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"http://cdn.sstatic.net/stackoverflow/img/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"question-page\">\r\n");
      out.write("\t\r\n");
      out.write("\t<noscript>\r\n");
      out.write("\t<div id=\"noscript-padding\"></div>\r\n");
      out.write("\t</noscript> \r\n");
      out.write("\t<div id=\"notify-container\"></div> \r\n");
      out.write("\t<div id=\"overlay-header\"></div> \r\n");
      out.write("\t<div id=\"custom-header\"></div>\r\n");
      out.write(" \r\n");
      out.write("\t<div class=\"container\">\r\n");
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
      out.write("\t\t<div id=\"content\">   \r\n");
      out.write("\t\t\t<div id=\"mainbar\">    \r\n");
      out.write("\t\t\t\t<div class=\"subheader\">\r\n");
      out.write("\t\t\t\t\t<h1  style=\"float:left;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h1>\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"question\">  \r\n");
      out.write("\t\t\t\t\t<div class=\"question-content\" id=\"question-content-{doc.docid}\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"votecell\">   \r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"vote-up-off\" title=\"This question shows research effort; it is useful and clear (click again to undo)\">up\r\n");
      out.write("\t\t\t\t\t\t\tvote</a> \r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"vote-count-post\">0</span> \r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"vote-down-off\" title=\"This question does not show any research effort; it is unclear or not useful (click again to undo)\">down\r\n");
      out.write("\t\t\t\t\t\t\tvote</a> \r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"star-off\" href=\"#\" title=\"This is a favorite question (click again to undo)\">favorite</a>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"favoritecount\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"vote-count-post\">3</span> \r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"question-details\"  >        \r\n");
      out.write("                            <div class=\"post-text\">\r\n");
      out.write("                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.content}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</p> \r\n");
      out.write("                            </div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tags t-android t-webview t-textview\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/questions/tagged/android\" class=\"post-tag\" title=\"show questions tagged 'android'\" rel=\"tag\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src=\"http://cdn.sstatic.net/img/hosted/tKsDb.png\" height=\"16\" width=\"18\" alt=\"\" class=\"sponsor-tag-img\">android</a> \r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/questions/tagged/webview\" class=\"post-tag\" title=\"show questions tagged 'webview'\" rel=\"tag\">webview</a> \r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/questions/tagged/textview\" class=\"post-tag\" title=\"show questions tagged 'textview'\" rel=\"tag\">textview</a> \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"started fr\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"user-info\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-gravatar32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/users/565319/richard\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.creater.imageurl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" alt=\"\" width=\"32\" height=\"32\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/users/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.creater.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.creater.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">296</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span title=\"1 silver badge\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge2\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">1</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span title=\"13 bronze badges\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge3\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">13</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"user-action-time\">asked <span title=\"\" class=\"relativetime\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.createdate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span></div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>  \r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>  <!--question -->\r\n");
      out.write("                \r\n");
      out.write("\t\t\t\t<div id=\"answers\"> \r\n");
      out.write("                    <div id=\"answers-header\"> \r\n");
      out.write("                        <div class=\"subheader answers-subheader\"> \r\n");
      out.write("                            <h2>1 Answer</h2> \r\n");
      out.write("                            <div id=\"tabs\">\r\n");
      out.write("                                <a class=\"youarehere\" href=\"#\" title=\"Answers with the latest activity first\">active</a> \r\n");
      out.write("                                <a href=\"#\" title=\"Answers in the order they were provided\">oldest</a> \r\n");
      out.write("                                <a href=\"#\" title=\"Answers with the highest score first\">votes</a>\r\n");
      out.write("                            </div> \r\n");
      out.write("                    \t</div> \r\n");
      out.write("                    </div> \r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("   \r\n");
      out.write("                    <div id=\"answer-9890067\" class=\"answer\" data-answerid=\"9890067\">\r\n");
      out.write("                    \t<div class=\"votecell\"> \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"vote\">\r\n");
      out.write("                                <input type=\"hidden\" value=\"9890067\"> \r\n");
      out.write("                                <a class=\"vote-up-off\" title=\"This answer is useful (click again to undo)\">up vote</a> \r\n");
      out.write("                                <span class=\"vote-count-post\">0</span> \r\n");
      out.write("                                <a class=\"vote-down-off\" title=\"This answer is not useful (click again to undo)\">down vote</a> \r\n");
      out.write("                            </div> \r\n");
      out.write("                        </div>\r\n");
      out.write("                    \t<div class=\"answer-details\"  >        \r\n");
      out.write("                            <div class=\"post-text\">\r\n");
      out.write("                                <p>The keyword OUTER is optional, but in my opinion it should be\r\n");
      out.write("                                mandatory. Until such time as it is (and of course thereafter, too),   my advice is always to write it, to remind yourself that it's an outer join.</p> \r\n");
      out.write("                            </div> \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"started fr\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"user-info\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-gravatar32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/users/565319/richard\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.creater.imageurl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" alt=\"\" width=\"32\" height=\"32\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/users/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.creater.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.creater.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">296</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span title=\"1 silver badge\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge2\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">1</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span title=\"13 bronze badges\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge3\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">13</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"user-action-time\">answered <span title=\"2012-03-27 13:02:13Z\" class=\"relativetime\">17 secs ago</span></div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>  \r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("                    </div> \r\n");
      out.write("                    \r\n");
      out.write("                </div><!--answers -->\r\n");
      out.write("                <div id=\"youranswer\">\r\n");
      out.write("                \t<form id=\"post-form\" action=\"/questions/9890031/answer/submit\" method=\"post\" class=\"post-form\">\r\n");
      out.write("                        <input id=\"fkey\" name=\"fkey\" type=\"hidden\" value=\"48d6caf95afb4bfce2f35ded5fec4df4\"> \r\n");
      out.write("                        \r\n");
      out.write("                        <h2 class=\"space\">添加答案</h2>\r\n");
      out.write("                        <textarea id=\"wmd-input\" class=\"wmd-input\" name=\"post-text\" cols=\"92\"\r\n");
      out.write("        rows=\"15\" tabindex=\"101\"></textarea>\r\n");
      out.write("                        <div class=\"form-submit cbt\">\r\n");
      out.write("                            <input id=\"submit-button\" type=\"button\" value=\"提交你的答案\" onclick =\"postanswer()\" tabindex=\"110\"> \r\n");
      out.write("                        </div> \r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("    \t\t\t</div><!--youranswer -->\r\n");
      out.write("\t\t\t</div>  <!--mainbar -->\r\n");
      out.write("            \r\n");
      out.write("\t\t\t<div id=\"sidebar\"> \r\n");
      out.write("\t\t\t\t<div class=\"module\"> \r\n");
      out.write("\t\t\t\t\t<p class=\"label-key\">tagged</p> \r\n");
      out.write("\t\t\t\t\t<div class=\"tagged\">\r\n");
      out.write("                    \t<a href=\"/questions/tagged/sql\" class=\"post-tag\" title=\"show questions tagged 'sql'\" rel=\"tag\">sql</a>&nbsp;\r\n");
      out.write("                        <span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">74649</span></span><br>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/questions/tagged/database\" class=\"post-tag\" title=\"show questions tagged 'database'\" rel=\"tag\">database</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">32724</span></span><br>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/questions/tagged/table\" class=\"post-tag\" title=\"show questions tagged 'table'\" rel=\"tag\">table</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">7627</span></span><br>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"module\">\r\n");
      out.write("                \t<h4 id=\"h-related\">Related</h4> \r\n");
      out.write("\t\t\t\t\t<div class=\"related\"> \r\n");
      out.write("\t\t\t\t\t\t<div class=\"spacer\">\r\n");
      out.write("                        \t<a href=\"/questions/78468/\" class=\"question-hyperlink\">Linq to Entity</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"spacer\">\r\n");
      out.write("                            <a href=\"/questions/896204\" class=\"question-hyperlink\">How to implement outer join expression tree?</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div> <!--sidebar -->\r\n");
      out.write("        \r\n");
      out.write("        </div> <!--content -->\r\n");
      out.write("    </div> <!--container -->\r\n");
      out.write("    \r\n");
      out.write("\t");
      out.write("\t<div id=\"footer\">\r\n");
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
      out.write("    </div>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function postanswer(){\r\n");
      out.write("\t$.ajax( {\r\n");
      out.write("\t\ttype : \"POST\",\r\n");
      out.write("\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/s/doc/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.docid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/answer\",\r\n");
      out.write("\t\tdata : {\"post-text\":$(\"#wmd-input\").val(),\"doctype\":\"3\"},\r\n");
      out.write("\t\tdataType: \"json\",\r\n");
      out.write("\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\tif(data.success == \"true\"){\r\n");
      out.write("\t\t\t\talert(\"添加成功！\");\r\n");
      out.write("\t\t\t\talert($(\"#wmd-input\").html());\r\n");
      out.write("\t\t\t\t$(\"#answers\").append(\"<div>\"+$(\"#wmd-input\").val()+\"</div>\");\r\n");
      out.write("\t\t\t\t$(\"#wmd-input\").val(\"\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\talert(data.msg);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror :function(){\r\n");
      out.write("\t\t\talert(\"网络连接出错！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /view/doc.jsp(96,0) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/view/doc.jsp(96,0) '${doc.answers}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${doc.answers}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /view/doc.jsp(96,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("answer");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("                   \r\n");
          out.write("\t\t\t\t\t<div id=\"answer-9890067\" class=\"answer\" data-answerid=\"9890067\">\r\n");
          out.write("                    \t<div class=\"votecell\"> \r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"vote\">\r\n");
          out.write("                                <input type=\"hidden\" value=\"9890067\"> \r\n");
          out.write("                                <a class=\"vote-up-off\" title=\"This answer is useful (click again to undo)\">up vote</a> \r\n");
          out.write("                                <span class=\"vote-count-post\">0</span> \r\n");
          out.write("                                <a class=\"vote-down-off\" title=\"This answer is not useful (click again to undo)\">down vote</a> \r\n");
          out.write("                            </div> \r\n");
          out.write("                        </div>\r\n");
          out.write("                    \t<div class=\"answer-details\"  >        \r\n");
          out.write("                            <div class=\"post-text\">\r\n");
          out.write("                                <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${answer.content}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</p> \r\n");
          out.write("                            </div> \r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"started fr\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"user-info\"> \r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-gravatar32\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/users/565319/richard\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('/');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${answer.creater.imageurl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" alt=\"\" width=\"32\" height=\"32\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-details\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/users/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${answer.creater.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${answer.creater.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a><br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">296</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<span title=\"1 silver badge\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge2\"></span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">1</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<span title=\"13 bronze badges\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge3\"></span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">13</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"user-action-time\">answered <span title=\"2012-03-27 13:02:13Z\" class=\"relativetime\">17 secs ago</span></div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>  \r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("                    </div>  \r\n");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
