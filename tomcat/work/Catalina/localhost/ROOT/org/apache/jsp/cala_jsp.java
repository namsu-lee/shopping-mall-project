/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.51
 * Generated at: 2020-03-16 07:31:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cala_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\r');
      out.write('\n');

String mBtnPlus  = request.getParameter("plus");
String mBtnMinus = request.getParameter("minus");
String mBtnMulti = request.getParameter("multi");
String mBtnDiv   = request.getParameter("div");
String mOperate  = "+";
if(mBtnPlus != null && mBtnPlus.equals("+"))
{
	mOperate  = "+";
}
if(mBtnMinus != null && mBtnMinus.equals("-"))
{
	mOperate  = "-";
}
if(mBtnMulti != null && mBtnMulti.equals("*"))
{
	mOperate  = "*";
}
if(mBtnDiv != null && mBtnDiv.equals("/"))
{
	mOperate  = "/";
}

      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<form id=\"calculater\" name=\"calculater\" action=\"cala.jsp\">\r\n");
      out.write("<table width=\"600px\" border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t<strong>계산기 프로그램</strong>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">입력값</td>\r\n");
      out.write("\t\t<td><input style=\"width:100%\" type=\"text\" id=\"x\" name=\"x\" value=\"0\"></td>\r\n");
      out.write("\t\t<td></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"150\" align=\"right\">입력값</td>\r\n");
      out.write("\t\t<td width=\"200\"><input style=\"width:100%\" type=\"text\" id=\"y\" name=\"y\" value=\"0\"></td>\r\n");
      out.write("\t\t<td align=\"left\" width=\"110\">\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"plus\" name=\"plus\" value=\"+\" style=\"width:50\">\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"minus\" name=\"minus\" value=\"-\" style=\"width:50\">\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"multi\" name=\"multi\" value=\"*\" style=\"width:50\">\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"div\" name=\"div\" value=\"/\" style=\"width:50\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">연산자</td>\r\n");
      out.write("\t\t<td><input type=\"text\" id=\"op\" name=\"op\" value=\"");
      out.print( mOperate );
      out.write("\" size=\"2\" readonly></td>\r\n");
      out.write("\t\t<td></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">계산값</td>\r\n");
      out.write("\t\t<td><input type=\"text\" style=\"width:100%\" id=\"z\" name=\"z\" value=\"0\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"cal\" name=\"cal\" value=\"계산하기\">\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"clear\" name=\"clear\" value=\"초기화\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
