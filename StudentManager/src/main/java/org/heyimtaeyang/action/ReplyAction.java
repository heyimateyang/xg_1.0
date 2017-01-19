package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.biz.AdminmessageBiz;
import org.heyimtaeyang.biz.ReplyBiz;
import org.heyimtaeyang.biz.TeachermessageBiz;
import org.heyimtaeyang.biz.TeacherreplyBiz;
import org.heyimtaeyang.biz.impl.AdminmessageBizImpl;
import org.heyimtaeyang.biz.impl.ReplyBizImpl;
import org.heyimtaeyang.biz.impl.TeachermessageBizImpl;
import org.heyimtaeyang.biz.impl.TeacherreplyBizImpl;
import org.heyimtaeyang.entity.Adminmessage;
import org.heyimtaeyang.entity.Reply;
import org.heyimtaeyang.entity.Teachermessage;
import org.heyimtaeyang.entity.Teacherreply;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ReplyAction extends ActionSupport{
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//从页面接收字段
	private int studentId;
	private int adminId;
	private String replyTitle;
	private String content1;
	private int systermMessageId;
	private int replyId;
	private int gradeteacherId;
	private int teacherMessageId;
	private int teacherReplyId;
	
	
	public int getTeacherReplyId() {
		return teacherReplyId;
	}
	public void setTeacherReplyId(int teacherReplyId) {
		this.teacherReplyId = teacherReplyId;
	}
	public int getTeacherMessageId() {
		return teacherMessageId;
	}
	public void setTeacherMessageId(int teacherMessageId) {
		this.teacherMessageId = teacherMessageId;
	}
	public int getGradeteacherId() {
		return gradeteacherId;
	}
	public void setGradeteacherId(int gradeteacherId) {
		this.gradeteacherId = gradeteacherId;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getSystermMessageId() {
		return systermMessageId;
	}
	public void setSystermMessageId(int systermMessageId) {
		this.systermMessageId = systermMessageId;
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
	public String getReplyTitle() {
		return replyTitle;
	}
	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	
	//添加一条新的回复信息GradeTeacher页面
	public String AddReplyMessage(){
		TeacherreplyBiz teacherreplyBiz = new TeacherreplyBizImpl();
		int id = teacherreplyBiz.addTercherreply(teacherMessageId, 
				studentId, gradeteacherId, replyTitle, content1);
		if(id!=0){
			request.setAttribute("gradeteacherId", gradeteacherId);
			request.setAttribute("teacherMessageId", teacherMessageId);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//显示一条回复的信息GraderTeacher页面
	public String OkReply(){
		TeacherreplyBiz teacherreplyBiz = new TeacherreplyBizImpl();
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		Teacherreply teacherreply = teacherreplyBiz.findById(gradeteacherId);
		request.setAttribute("teacherreply", teacherreply);
		Teachermessage teachermessage = teachermessageBiz.findByTeacherMessageId(teacherMessageId);
		request.setAttribute("teachermessage", teachermessage);
		return SUCCESS;
	}
	
	//显示一条回复的信息admin页面
	public String OkReplyAdmin(){
		TeacherreplyBiz teacherreplyBiz = new TeacherreplyBizImpl();
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		
		Teachermessage teachermessage = teachermessageBiz.findByTeacherMessageId(teacherMessageId);
		request.setAttribute("teachermessage", teachermessage);
		Teacherreply teacherreply = teacherreplyBiz.findByIdTeacherReplyId(teacherReplyId);
		request.setAttribute("teacherreply", teacherreply);
		return SUCCESS;
	}
	
	//学生页面显示回复信息
	public String StudentOkReply(){
		ReplyBiz replyBiz = new ReplyBizImpl();
		AdminmessageBiz adminmessageBiz = new AdminmessageBizImpl();
		Adminmessage adminmessage = new Adminmessage();
		Reply reply = new Reply();
		reply = replyBiz.findByReplyId(systermMessageId);
		adminmessage = adminmessageBiz.findById(systermMessageId);
		request.setAttribute("adminmessage_message", adminmessage);
		request.setAttribute("reply_message", reply);
		return SUCCESS;
	}

}
