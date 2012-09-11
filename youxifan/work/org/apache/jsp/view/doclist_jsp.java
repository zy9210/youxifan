package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.youxifan.pojo.*;
import org.apache.commons.lang3.StringUtils;

public final class doclist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html> \r\n");
      out.write("<head> \r\n");
      out.write("    <title>Bounty Questions - Stack Overflow</title> \r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://cdn.sstatic.net/js/stub.js?v=c014461b9109\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(contextPath );
      out.write("/css/all.css\">\r\n");

	String sort = (String)request.getAttribute("sort");
	if(StringUtils.isEmpty(sort)){	
		sort = "newest";
	}
 

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
      out.write("        <div id=\"content\">\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"mainbar\">    \r\n");
      out.write("\t\t\t\t<div class=\"subheader\">\r\n");
      out.write("\t\t\t\t\t<div id=\"tabs\">\r\n");
      out.write("<a ");
      out.print("newest".equals(sort)?"class=\"youarehere\"":"" );
      out.write("  href=\"/questions?sort=newest\" title=\"the most recently asked questions\">最新</a>\r\n");
      out.write("<a ");
      out.print("featured".equals(sort)?"class=\"youarehere\"":"" );
      out.write(" href=\"/questions?sort=featured\" title=\"questions with open bounties\">投票</a>\r\n");
      out.write("<a ");
      out.print("unanswered".equals(sort)?"class=\"youarehere\"":"" );
      out.write(" href=\"/questions?sort=faq\" title=\"questions with the most links\">回答</a>\r\n");
      out.write("<a ");
      out.print("votes".equals(sort)?"class=\"youarehere\"":"" );
      out.write(" href=\"/questions?sort=votes\" title=\"questions with the most votes\">收藏</a>\r\n");
      out.write("<a ");
      out.print("active".equals(sort)?"class=\"youarehere\"":"" );
      out.write(" href=\"/questions?sort=active\" title=\"questions that have recent activity\">active</a>\r\n");
      out.write("<a ");
      out.print("question".equals(sort)?"class=\"youarehere\"":"" );
      out.write(" href=\"");
      out.print(contextPath);
      out.write("/view/ask.jsp\" title=\"提问\">提问</a>\r\n");
      out.write("\t\t\t\t\t</div>  \r\n");
      out.write("\t\t\t\t\t<h1 id=\"h-all-questions\">问题</h1> \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>   \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"questions\">\r\n");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /view/doclist.jsp(46,0) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/view/doclist.jsp(46,0) '${doclist}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${doclist}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /view/doclist.jsp(46,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("doc");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\r\n");
            out.write("\t\t\t\t\t<div class=\"question-summary\" id=\"question-summary-");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.docid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\">\r\n");
            out.write("\t\t\t\t\t\t<div class=\"statscontainer\">\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"statsarrow\"></div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"stats\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"vote\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"votes\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"vote-count-post\"><strong>6</strong></span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"viewcount\">votes</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"status answered\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<strong>3</strong>answers\r\n");
            out.write("\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"views\" title=\"188 views\">188 views</div>\r\n");
            out.write("\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t<div class=\"summary\">        \r\n");
            out.write("\t\t\t\t\t\t\t<h3><a href=\"");
            out.print(contextPath);
            out.write("/s/doc/id/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.docid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" class=\"question-hyperlink\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</a></h3>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"excerpt\">\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.content}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\t \r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
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
            out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">296</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<span title=\"1 silver badge\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge2\"></span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">1</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<span title=\"13 bronze badges\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge3\"></span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"badgecount\">13</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-action-time\">asked <span title=\"\" class=\"relativetime\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doc.createdate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t</div>  \r\n");
            out.write("\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t</div>\r\n");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      }
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br class=\"cbt\">\r\n");
      out.write("\t\t\t\t<div class=\"page-sizer fr\">\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?sort=featured&amp;pagesize=15\" title=\"show 15 items per page\" class=\"current page-numbers\">15</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?sort=featured&amp;pagesize=30\" title=\"show 30 items per page\" class=\"page-numbers\">30</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?sort=featured&amp;pagesize=50\" title=\"show 50 items per page\" class=\"page-numbers\">50</a>\r\n");
      out.write("\t\t\t\t\t<span class=\"page-numbers desc\">per page</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"pager fl\" >\r\n");
      out.write("\t\t\t\t\t<span class=\"page-numbers current\">1</span>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?page=2&amp;sort=featured\" title=\"go to page 2\"><span class=\"page-numbers\">2</span></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?page=3&amp;sort=featured\" title=\"go to page 3\"><span class=\"page-numbers\">3</span></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?page=4&amp;sort=featured\" title=\"go to page 4\"><span class=\"page-numbers\">4</span></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?page=5&amp;sort=featured\" title=\"go to page 5\"><span class=\"page-numbers\">5</span></a>\r\n");
      out.write("\t\t\t\t\t<span class=\"page-numbers dots\">&hellip;</span>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?page=21&amp;sort=featured\" title=\"go to page 21\"><span class=\"page-numbers\">21</span></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/questions?page=2&amp;sort=featured\" title=\"go to page 2\" rel=\"next\"><span class=\"page-numbers next\"> next</span></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"sidebar\">\r\n");
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
      out.write("    ");
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
