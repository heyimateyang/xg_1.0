package org.heyimtaeyang.until;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.InputStream;  
import java.util.Enumeration;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Properties;  
import java.util.Set;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author liufeng 2009-08-18
 *
 */
public class PropertiesUtil implements Filter {
 
 private String[] characterParams = null;
 private boolean OK=true;
 
 public void destroy() {
  // TODO Auto-generated method stub
 }
 /**
  * 此程序块主要用来解决参数带非法字符等过滤功能
  */
 public void doFilter(ServletRequest request, ServletResponse response,
   FilterChain arg2) throws IOException, ServletException {
 
  HttpServletRequest servletrequest = (HttpServletRequest) request;
  HttpServletResponse servletresponse = (HttpServletResponse) response; 
  boolean status = false;  
   java.util.Enumeration params = request.getParameterNames();
   String param="";
   String paramValue = "";
   servletresponse.setContentType("text/html");
   servletresponse.setCharacterEncoding("utf-8");
   while (params.hasMoreElements()) {
    param = (String) params.nextElement();
    String[] values = request.getParameterValues(param);
    paramValue = "";
    if(OK){//过滤字符串为0个时 不对字符过滤
    for (int i = 0; i < values.length; i++)
      paramValue=paramValue+values[i];
    for(int i=0;i<characterParams.length;i++)
     if (paramValue.indexOf(characterParams[i]) >= 0) {
      status = true;
      break;
     }
    if(status)break;
    }
   }
//   System.out.println(param+"="+paramValue+";");
   if (status) {
    PrintWriter out = servletresponse.getWriter();
    out
      .print("<script language='javascript'>alert(\"您提交的相关表单数据字符含有非法字符。如：\\\"'\\\".\");location.href('"
        + servletrequest.getRequestURL()
        + "');</script>");
   }else
   arg2.doFilter(request, response);
 
 }
 public void init(FilterConfig config) throws ServletException {
  if(config.getInitParameter("characterParams").length()<1)
   OK=false;
  else
  this.characterParams = config.getInitParameter("characterParams").split(",");
 }
}
 