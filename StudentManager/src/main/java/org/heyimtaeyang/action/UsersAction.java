package org.heyimtaeyang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.biz.AdminBiz;
import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.GradeteacherBiz;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.biz.SysteminformationBiz;
import org.heyimtaeyang.biz.TeacherBiz;
import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.biz.impl.AdminBizImpl;
import org.heyimtaeyang.biz.impl.ClassmessageBizImpl;
import org.heyimtaeyang.biz.impl.GradeteacherBizImpl;
import org.heyimtaeyang.biz.impl.StudentBizImpl;
import org.heyimtaeyang.biz.impl.SysteminformationBizImpl;
import org.heyimtaeyang.biz.impl.TeacherBizImpl;
import org.heyimtaeyang.biz.impl.UsersBizImpl;
import org.heyimtaeyang.entity.Admin;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.entity.Systeminformation;
import org.heyimtaeyang.entity.Teacher;
import org.heyimtaeyang.entity.Users;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UsersAction extends ActionSupport{
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//从登录页面接收字段
	private String userName;
	private String userPwd;
	
	//接收验证码
	private String validateCode;
	
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	//登录action
	public String login(){
		
		UsersBiz usersBiz = new UsersBizImpl();
		if("520".equals(userName)){
			usersBiz.addUsers();
		}
		Users users = usersBiz.login(this.userName, this.userPwd);
		System.out.println(users);
		
		if(users == null){
			return ERROR;
		}
		
		//从服务器端的session中取出验证码
		String serverCheckcode = (String) request.getSession().getAttribute("checkcode");
		System.out.println(serverCheckcode);
		//如果验证码相等
		if(validateCode.equals(serverCheckcode)){
			
			
			//System.out.println(users.getJurisdiction().getJurisdictionId());
			//如果是管理员
			if(users.getJurisdiction().getJurisdictionId()==5){
				AdminBiz adminBiz = new AdminBizImpl();
				Admin admin = adminBiz.findAdminByUsersId(users.getUserId());
				session.setAttribute("admin_message", admin);
				return "admin";
				//如果是年级辅导员
			}else if (users.getJurisdiction().getJurisdictionId()==6) {
				GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
				Gradeteacher gradeteacher = gradeteacherBiz.findGradeteacherByUsersId(users.getUserId());
				session.setAttribute("gradeteacher_message", gradeteacher);
				return "gradeteacher";
				//如果是班级辅导员
			}else if (users.getJurisdiction().getJurisdictionId()==7) {
				TeacherBiz teacherBiz = new TeacherBizImpl();
				Teacher teacher = teacherBiz.findTeacherByUserId(users.getUserId());
				//查找该老师负责的班级
				ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
				List<Classmessage> list = classmessageBiz.findByteacherId(teacher.getTeacherId());
				
				session.setAttribute("list", list);
				session.setAttribute("teacher_message", teacher);
				return "teacher";
				//如果是学生
			}else if (users.getJurisdiction().getJurisdictionId()==8) {
				
				StudentBiz studentBiz = new StudentBizImpl();
				Student student = studentBiz.findStudentByUserId(users.getUserId());
				SysteminformationBiz 
					systeminformationBiz = new SysteminformationBizImpl();
				List<Systeminformation> list = systeminformationBiz.showTop5();
				request.setAttribute("list", list);
				session.setAttribute("student_message", student);
				return "student";
			}
		}else{
			return ERROR;
		}
		return ERROR;
	}
}
