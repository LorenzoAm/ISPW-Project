/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2021-02-08 16:22:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WebContent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.beans.LoginBean;
import logic.controllers.LoginController;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("logic.controllers.LoginController");
    _jspx_imports_classes.add("logic.beans.LoginBean");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n");
      logic.beans.LoginBean loginBean = null;
      loginBean = (logic.beans.LoginBean) _jspx_page_context.getAttribute("loginBean", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (loginBean == null){
        try {
          loginBean = (logic.beans.LoginBean) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "logic.beans.LoginBean");
        } catch (java.lang.ClassNotFoundException exc) {
          throw new InstantiationException(exc.getMessage());
        } catch (java.lang.Exception exc) {
          throw new javax.servlet.ServletException("Cannot create bean of class " + "logic.beans.LoginBean", exc);
        }
        _jspx_page_context.setAttribute("loginBean", loginBean, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("loginBean"), request);
      out.write("\r\n\r\n\r\n<!DOCTYPE html>\r\n<html lang=\"it\">\r\n<head>\r\n<meta charset=\"ISO-8859-1\">\r\n<title>Login</title>\r\n</head>\r\n<body>\r\n\t\r\n\t");

		if(request.getParameter("login")!=null)
		{
			LoginBean bean = new LoginBean(request.getParameter("email"),request.getParameter("password"));
			if(bean.check())
			{
				LoginController.getInstance().login(bean);
				
      out.write("\r\n\t\t\t\t\t");
      if (true) {
        _jspx_page_context.forward("loginCheck.jsp");
        return;
      }
      out.write("\r\n\t\t\t\t\t\r\n\t\t\t\t");

			}
			else
			{
				
      out.write("\r\n\t\t\t\t <p>Wrong email or password </p>\r\n\t\t\t\t");

			}
			
		}
	
      out.write("\r\n\t<div>\r\n\t\t<h1 id = \"title\" >SkateSpot</h1>\r\n\t\t<a href=\"index.jsp\">\r\n\t\t\t<img src=\"images/home_icon.png\" alt=\"Home\"/>\r\n\t\t</a>\r\n\t</div>\r\n\t\r\n\t<div>\r\n\t\t<h1>Enter your data</h1> <br>\r\n\t\t<form action=\"\" method=\"get\">\r\n  \t\t\t<label >Email: </label>\r\n  \t\t\t<input type=\"text\" id=\"email\" name=\"email\" required><br><br>\r\n  \t\t\t<label>Password: </label>\r\n  \t\t\t<input type=\"password\" id=\"password\" name=\"password\" required>\r\n  \t\t\t<br><br><br>\r\n  \t\t\t<input type=\"submit\" value=\"Sign in\" name=\"login\"/>\r\n  \t\t\t<input type=\"reset\" value=\"Reset all\" name=\"reset\"/>\r\n\t\t</form>\r\n\t</div>\r\n\t\r\n\r\n</body>\r\n</html>");
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
