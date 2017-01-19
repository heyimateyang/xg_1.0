package org.heyimtaeyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.heyimtaeyang.biz.CollegeBiz;
import org.heyimtaeyang.biz.impl.CollegeBizImpl;

@SuppressWarnings("serial")
public class CheckCollegeName extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckCollegeName() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType( "text/xml;charset=UTF-8" );   //设置响应格式为test/xml防止乱码
		//String College_Name = request.getParameter("collegeName");
		String College_Name = new String (request.getParameter("collegeName").getBytes("ISO-8859-1"),"UTF-8");

		PrintWriter out = response.getWriter();
		out.println( "<?xml version=\"1.0\" encoding=\"utf-8\"?>" );
		out.println( "<collegeName>" );
		
		College_Name = java.net.URLDecoder.decode(College_Name,"UTF-8");	//根据UTF-8将字符串解码
		CollegeBiz collegeBiz = new CollegeBizImpl();
		boolean rs = collegeBiz.findCollegeName(College_Name);
		
		if(!rs) {
			out.println("<noIterance id=\"ok\"/>");
		}else{
			out.println("<iterance>"+College_Name+"</iterance>");
		}
		out.println( "</collegeName>" );
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
