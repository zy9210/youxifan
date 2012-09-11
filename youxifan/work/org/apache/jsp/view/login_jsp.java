package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.youxifan.pojo.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/include/head.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>登陆</title>\r\n");
      out.write("<script language=\"javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(contextPath);
      out.write("/script/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\"\r\n");
      out.write("\thref=\"");
      out.print(contextPath);
      out.write("/css/common.css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div style=\"width: 300px; margin:200px auto\">\r\n");
      out.write("<form method=\"post\" action=\"");
      out.print(contextPath);
      out.write("/s/user/login\">\r\n");
      out.write("<div style=\"color: red\">&nbsp;");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("<table style=\"text-align: center;\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">邮箱</td>\r\n");
      out.write("\t\t<td align=\"left\"><input class=\" r3px \" id=\"email\" name=\"email\"\r\n");
      out.write("\t\t\ttype=\"text\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">密码</td>\r\n");
      out.write("\t\t<td align=\"left\"><input class=\" r3px \" id=\"psw\" name=\"psw\"\r\n");
      out.write("\t\t\ttype=\"password\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">验证码</td>\r\n");
      out.write("\t\t<td align=\"left\"><input class=\" r3px \" id=\"validcode\"\r\n");
      out.write("\t\t\tname=\"validcode\" type=\"text\" /> <img\r\n");
      out.write("\t\t\tstyle=\"cursor: hand; border: none;\" id=\"imgvalidcode\"\r\n");
      out.write("\t\t\tname=\"imgvalidcode\" src=\"");
      out.print(contextPath);
      out.write("/ImageValidServlet\"\r\n");
      out.write("\t\t\talign=\"absmiddle\"\r\n");
      out.write("\t\t\tonclick=\"this.src='");
      out.print(contextPath);
      out.write("/ImageValidServlet?i='+Math.random();\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colSpan=\"2\" align=\"center\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"登陆\" /> \r\n");
      out.write("\t\t<input type=\"button\" onclick=\"javascript:window.location.href='");
      out.print(contextPath);
      out.write("/view/register.jsp';\" value=\"注册\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table> \r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /view/login.jsp(20,30) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
