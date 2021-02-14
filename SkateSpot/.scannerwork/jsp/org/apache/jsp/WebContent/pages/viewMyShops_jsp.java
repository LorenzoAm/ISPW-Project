/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2021-02-14 18:51:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WebContent.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import logic.controllers.ViewMyShopsController;
import logic.entities.Shop;

public final class viewMyShops_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("logic.controllers.ViewMyShopsController");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.time.LocalDate");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("logic.entities.Shop");
    _jspx_imports_classes.add("java.time.ZoneId");
    _jspx_imports_classes.add("java.util.ArrayList");
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

      out.write("\r\n    \r\n\r\n\r\n\r\n    \r\n\r\n\r\n    \r\n    \r\n<!DOCTYPE html>\r\n<html lang=\"it\">\r\n<head>\r\n<meta charset=\"ISO-8859-1\">\r\n<title>View My Shops</title>\r\n</head>\r\n<body>\r\n\r\n");

	ArrayList<Shop> shops;
	shops=ViewMyShopsController.getInstance().getList();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	int dim=shops.size();
	//utilizzo array paralleli per memorizzare lel informazioni e accedervi dal client
	String[] nomi= new String[dim];
	String[] indirizzi= new String[dim];
	String[] zone= new String[dim];
	String[] municipi= new String[dim];
	String[] descrizioni= new String[dim];
	String[] username= new String[dim];
	String[] date= new String[dim];
	for(int i=0;i<dim;i++)
	{
		nomi[i]=shops.get(i).getNome();
		indirizzi[i]=shops.get(i).getIndirizzo();
		zone[i]=shops.get(i).getZona();
		municipi[i]=shops.get(i).getComune();
		descrizioni[i]=shops.get(i).getComune();
		username[i]=shops.get(i).getUsername();
		date[i]=sdf.format(shops.get(i).getData());		
	}
	int i=0;
	

      out.write("\r\n\r\n<script type=\"text/javascript\">\r\n\tvar i=0;\r\n\tvar first=1;\r\n\t\r\n\tvar nomiJ= new Array();\r\n\t\r\n\tvar numeriJ=new Array();\r\n\t\r\n\tvar indirizziJ=new Array();\r\n\t\r\n\tvar zoneJ=new Array();\r\n\t\r\n\tvar municipiJ=new Array();\r\n\t\r\n\tvar descrizioniJ=new Array();\r\n\t\r\n\tvar usernameJ=new Array();\r\n\t\r\n\tvar dateJ=new Array();\r\n\t\r\n\t");
for(int j=0; j<dim; j++){
      out.write("\r\n\tnomiJ[");
      out.print(j);
      out.write("] = \"");
      out.print(nomi[j]);
      out.write("\";\r\n\tindirizziJ[");
      out.print(j);
      out.write("] = \"");
      out.print(indirizzi[j]);
      out.write("\";\r\n\tzoneJ[");
      out.print(j);
      out.write("] = \"");
      out.print(zone[j]);
      out.write("\";\r\n\tmunicipiJ[");
      out.print(j);
      out.write("] = \"");
      out.print(municipi[j]);
      out.write("\";\r\n\tdescrizioniJ[");
      out.print(j);
      out.write("] = \"");
      out.print(descrizioni[j]);
      out.write("\";\r\n\tusernameJ[");
      out.print(j);
      out.write("] = \"");
      out.print(username[j]);
      out.write("\";\r\n\tdateJ[");
      out.print(j);
      out.write("] = \"");
      out.print(date[j]);
      out.write("\";\r\n\t");
}
      out.write("\r\n\t\r\n\tfunction previous()\r\n\t{\r\n\t\tif(first==1)\r\n\t\t{\r\n\t\t\tsetLabels();\r\n\t\t\tfirst=0;\r\n\t\t}\r\n\t\telse\r\n\t\t{\r\n\t\t\ti--;\r\n\t\t\tif(i<0)\r\n\t\t\t{\r\n\t\t\t\ti=");
      out.print(dim);
      out.write("-1;\r\n\t\t\t\tsetLabels();\r\n\t\t\t}\r\n\t\t\telse\r\n\t\t\t{\r\n\t\t\t\tsetLabels();\r\n\t\t\t}\t\r\n\t\t}\r\n\t}\r\n\tfunction next()\r\n\t{\r\n\t\tif(first==1)\r\n\t\t{\r\n\t\t\tsetLabels();\r\n\t\t\tfirst=0;\r\n\t\t}\r\n\t\telse\r\n\t\t{\r\n\t\t\ti++;\r\n\t\t\tif(i==");
      out.print(dim);
      out.write(")\r\n\t\t\t{\r\n\t\t\t\ti=0;\r\n\t\t\t\tsetLabels();\r\n\t\t\t}\r\n\t\t\telse\r\n\t\t\t{\r\n\t\t\t\tsetLabels();\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n\tfunction setLabels()\r\n\t{\r\n\t\tvar nome = document.getElementById(\"name\");\r\n\t\tnome.innerHTML=nomiJ[i];\r\n\t\t\r\n\t\tvar indirizzo = document.getElementById(\"address\");\r\n\t\tindirizzo.innerHTML=indirizziJ[i];\r\n\t\t\r\n\t\tvar zona = document.getElementById(\"area\");\r\n\t\tzona.innerHTML=zoneJ[i];\r\n\t\t\r\n\t\tvar municipio = document.getElementById(\"municipality\");\r\n\t\tmunicipio.innerHTML=municipiJ[i];\r\n\t\t\r\n\t\tvar descrizione = document.getElementById(\"description\");\r\n\t\tdescrizione.innerHTML=descrizioniJ[i];\r\n\t\t\r\n\t\tvar username = document.getElementById(\"owner\");\r\n\t\tusername.innerHTML=usernameJ[i];\r\n\t\t\r\n\t\tvar data = document.getElementById(\"date\");\r\n\t\tdata.innerHTML=dateJ[i];\r\n\t}\r\n</script>\r\n\r\n\t<div>\r\n\t\t<h1 id = \"title\" >SkateSpot</h1>\r\n\t\t<a href=\"premiumArea.jsp\">\r\n\t\t\t<img src=\"../images/back_icon.png\" alt=\"BACK\"/>\r\n\t\t</a>\r\n\t</div>\r\n\t\r\n\t<div>\r\n\t\t<h1>Shop details</h1> <br><br>\r\n\t\t<label>Shop name : </label>\r\n\t\t<label id=\"name\"> Name </label> <br><br>\r\n");
      out.write("\t\t<label>Address : </label>\r\n\t\t<label id=\"address\"> Address </label> <br><br>\r\n\t\t<label>Area : </label>\r\n\t\t<label id=\"area\"> Area </label> <br><br>\r\n\t\t<label>Municipality : </label>\r\n\t\t<label id=\"municipality\"> Municipality </label> <br><br>\r\n\t\t<label>Description : </label>\r\n\t\t<label id=\"description\"> Description </label> <br><br>\r\n\t\t<label> Added by :</label>\r\n\t\t<label id=\"owner\"> Owner </label><br><br>\r\n\t\t<label> On :</label>\r\n\t\t<label id=\"date\"> Date </label><br><br><br>\r\n\t\t<input type=\"submit\" value=\"PREVIOUS\" onClick=\"previous()\"/>\r\n\t\t<input type=\"submit\" value=\"NEXT\" onClick=\"next()\"/>\r\n\t\t\r\n\t</div>\t\t\r\n\r\n</body>\r\n</html>");
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
