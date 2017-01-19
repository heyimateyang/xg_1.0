package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.AdminmessagePageBean;
import org.heyimtaeyang.bean.TeachermessagePageBean;
import org.heyimtaeyang.bean.TeacherreplyPageBean;
import org.heyimtaeyang.biz.AdminmessageBiz;
import org.heyimtaeyang.biz.ReplyBiz;
import org.heyimtaeyang.biz.TeachermessageBiz;
import org.heyimtaeyang.biz.impl.AdminmessageBizImpl;
import org.heyimtaeyang.biz.impl.ReplyBizImpl;
import org.heyimtaeyang.biz.impl.TeachermessageBizImpl;
import org.heyimtaeyang.entity.Adminmessage;
import org.heyimtaeyang.entity.Reply;
import org.heyimtaeyang.entity.Teachermessage;
import org.heyimtaeyang.service.AdminmessageService;
import org.heyimtaeyang.service.TeachermessageService;
import org.heyimtaeyang.service.TeacherreplyService;
import org.heyimtaeyang.service.impl.AdminmessageServiceImpl;
import org.heyimtaeyang.service.impl.TeachermessageServiceImpl;
import org.heyimtaeyang.service.impl.TeacherreplyServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminmessageAction extends ActionSupport{
	
	public AdminmessageService adminmessageService = new AdminmessageServiceImpl();
	
	private TeachermessageService teachermessageService = new TeachermessageServiceImpl();
	
	private TeacherreplyService teacherreplyService = new TeacherreplyServiceImpl();
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//页面获取字段
	private int adminId;
	private String MessageTitle;
	private String content1;
	private int studentId;
	private int systermMessageId;
	private int teacherMessageId;
	
	public int getTeacherMessageId() {
		return teacherMessageId;
	}


	public void setTeacherMessageId(int teacherMessageId) {
		this.teacherMessageId = teacherMessageId;
	}


	public int getSystermMessageId() {
		return systermMessageId;
	}


	public void setSystermMessageId(int systermMessageId) {
		this.systermMessageId = systermMessageId;
	}

	//生成get set
	private int page;
	
	
	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public String getMessageTitle() {
		return MessageTitle;
	}


	public void setMessageTitle(String messageTitle) {
		MessageTitle = messageTitle;
	}


	public String getContent1() {
		return content1;
	}


	public void setContent1(String content1) {
		this.content1 = content1;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	//无操作跳转Student
	public String SendMessageStudent(){
		request.setAttribute("adminId", adminId);
		return SUCCESS;
	}
	
	//学生添加一条新的信息
	public String addMessageStudent(){
		AdminmessageBiz 
			adminmessageBiz = new AdminmessageBizImpl();
		int id = adminmessageBiz.AddMessage(MessageTitle, content1, adminId, studentId);
		request.setAttribute("studentId", studentId);
		if(id == 1){
			return SUCCESS;
		}
		return ERROR;
	}
	
	//学生页面咨询信息分页显示
	public String StudentAdminmessagePage(){
		 AdminmessagePageBean pageBean = adminmessageService.getPageBean(10, page,this.studentId);
	     HttpServletRequest request = ServletActionContext.getRequest();
	     request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//学生页面咨询信息分页显示已处理
	public String StudentAdminmessagePages(){
		AdminmessagePageBean pageBean = adminmessageService.getPageBeans(10, page,this.studentId);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//管理员页面咨询信息分页显示(未处理的信息)
	public String AdminAdminmessagePage(){
		TeachermessagePageBean pageBean = teachermessageService.getPageBean(10, page);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//管理员页面咨询信息分页显示(已处理的信息)
	public String AdminAdminmessagePages(){
		TeacherreplyPageBean pageBean = teacherreplyService.getPageBean(10, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//管理员页面咨询信息查询显示
	public String ReplyMessage(){
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		Teachermessage teachermessage = teachermessageBiz.findByTeacherMessageId(teacherMessageId);
		request.setAttribute("teachermessage", teachermessage);
		return SUCCESS;
		
	}
	
	//学生页面显示咨询信息
	public String showStudentAdminMessage(){
		AdminmessageBiz adminmessageBiz = new AdminmessageBizImpl();
		ReplyBiz replyBiz = new ReplyBizImpl();
		Reply reply = new Reply();
		reply = replyBiz.findByReplyId(systermMessageId);
		Adminmessage adminmessage = adminmessageBiz.findById(systermMessageId);
		if(adminmessage!=null){
			request.setAttribute("reply_message", reply);
			request.setAttribute("adminmessage_message", adminmessage);
			return SUCCESS;
		}
		return ERROR;
	}

}
