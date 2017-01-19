package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QuitAction extends ActionSupport{
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//Admin安全退出action
	public String quitSession(){
		session.removeAttribute("admin_message");
		return "login_index";
	}
	
	//Student安全退出action
	public String StudentquitSession(){
		session.removeAttribute("student_message");
		return "login_index";
	}
	
	//辅导员安全退出action
	public String GradeTeacherquitSession(){
		session.removeAttribute("gradeteacher_message");
		return "login_index";
	}
	//辅导员助理安全退出action
	public String TeacherquitSession(){
		session.removeAttribute("teacher_message");
		return "login_index";
	}

}
