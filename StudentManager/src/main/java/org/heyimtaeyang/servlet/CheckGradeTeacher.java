package org.heyimtaeyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.heyimtaeyang.biz.GradeteacherBiz;
import org.heyimtaeyang.biz.impl.GradeteacherBizImpl;

@SuppressWarnings("serial")
public class CheckGradeTeacher extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckGradeTeacher() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		
		String gradeId = request.getParameter("gradeId");      //获取年级id
		int grade_id = Integer.parseInt(gradeId);              //转换类型
		
		String collegeId = request.getParameter("collegeId");  //获取学院id
		int college_Id = Integer.parseInt(collegeId);          //转换类型
		
		PrintWriter out = response.getWriter();
		out.println( "<?xml version=\"1.0\" encoding=\"utf-8\"?>" );
		out.println( "<gradeName>" );
		
		
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		boolean rs = gradeteacherBiz.findGradeTeacherByGradeandCollege(grade_id, college_Id);
		if(!rs) {
			out.println("<noIterance id=\"ok\"/>");
		}else{
			out.println("<iterance>"+grade_id+"</iterance>");
		}
		out.println( "</gradeName>" );
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
