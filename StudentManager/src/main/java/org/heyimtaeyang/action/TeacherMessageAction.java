package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.TeachermessagePageBean;
import org.heyimtaeyang.bean.TeacherreplyPageBean;
import org.heyimtaeyang.biz.TeachermessageBiz;
import org.heyimtaeyang.biz.TeacherreplyBiz;
import org.heyimtaeyang.biz.impl.TeachermessageBizImpl;
import org.heyimtaeyang.biz.impl.TeacherreplyBizImpl;
import org.heyimtaeyang.entity.Teachermessage;
import org.heyimtaeyang.entity.Teacherreply;
import org.heyimtaeyang.service.TeachermessageService;
import org.heyimtaeyang.service.TeacherreplyService;
import org.heyimtaeyang.service.impl.TeachermessageServiceImpl;
import org.heyimtaeyang.service.impl.TeacherreplyServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TeacherMessageAction extends ActionSupport{
	
	private TeachermessageService teachermessageService = new TeachermessageServiceImpl();
	
	private TeacherreplyService teacherreplyService = new TeacherreplyServiceImpl();
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//页面获取字段
	private int teacherId;
	private String teacherMessageTitle;
	private String content1;
	private int studentId;
	private int teacherMessageId;
	private String replyTitle;
	private int gradeteacherId;
	private int teacherReplyId;
	
	public int getTeacherReplyId() {
		return teacherReplyId;
	}

	public void setTeacherReplyId(int teacherReplyId) {
		this.teacherReplyId = teacherReplyId;
	}

	public int getGradeteacherId() {
		return gradeteacherId;
	}

	public void setGradeteacherId(int gradeteacherId) {
		this.gradeteacherId = gradeteacherId;
	}

	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	public int getTeacherMessageId() {
		return teacherMessageId;
	}

	public void setTeacherMessageId(int teacherMessageId) {
		this.teacherMessageId = teacherMessageId;
	}

	//生成get set
	private int page;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherMessageTitle() {
		return teacherMessageTitle;
	}

	public void setTeacherMessageTitle(String teacherMessageTitle) {
		this.teacherMessageTitle = teacherMessageTitle;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	//无操作跳转到发送页面学生页面
	public String SendTeacher(){
		request.setAttribute("gradeteacherId", gradeteacherId);
		return SUCCESS;
	}
	
	//学生页面添加一条咨询信息
	public String addTeacherMessageStudent(){
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		int id = teachermessageBiz.addTeachermessage(teacherMessageTitle, content1, studentId, gradeteacherId);
		if(id==1){
			request.setAttribute("studentId", studentId);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//分页显示全部助理辅导员的咨询信息
	public String showPageTeacherMessage(){
		//表示每页显示5条记录，page表示当前网页
        TeachermessagePageBean pageBean = teachermessageService.getPageBean(10, page,this.studentId);
        HttpServletRequest request = ServletActionContext.getRequest();
        //request.setAttribute("studentId", studentId);
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
	}
	
	//按id显示一条咨询信息学生页面
	public String findTeacherMessage(){
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		Teachermessage teachermessage = teachermessageBiz.findByTeacherMessageId(teacherMessageId);
		if(teachermessage!=null){
			request.setAttribute("teachermessage_message", teachermessage);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//按id显示一条咨询信息助理辅导员页面
	public String findTeacherMessageTeacher(){
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		Teachermessage teachermessage = teachermessageBiz.findByTeacherMessageId(teacherMessageId);
		if(teachermessage!=null){
			request.setAttribute("studentId", this.studentId);
			request.setAttribute("teachermessage_message", teachermessage);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//显示学生已处理的咨询信息
	public String TeacherNoReply(){
		TeacherreplyPageBean pageBean = teacherreplyService.getPageBean(10, page,studentId);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//助理辅导员页面显示全部没处理的学生咨询信息
	public String showNoReply(){
		 TeachermessagePageBean pageBean = teachermessageService.getPageBeans(10, page,this.gradeteacherId);
	     HttpServletRequest request = ServletActionContext.getRequest();
	     //request.setAttribute("studentId", studentId);
	     request.setAttribute("pageBean", pageBean);
	     return SUCCESS;
	}
	
	//助理辅导员页面显示全部处理的学生咨询信息
	public String showYesReply(){
		TeacherreplyPageBean pageBean = teacherreplyService.getPageBeans(10, page,this.gradeteacherId);
	     request.setAttribute("pageBean", pageBean);
	     return SUCCESS;
	}
	
	//助理辅导员页面显示全部没处理的学生咨询信息
	public String addTeachermessageReply(){
		TeacherreplyBiz teacherreplyBiz = new TeacherreplyBizImpl();
		int id = teacherreplyBiz.addTercherreply(teacherMessageId, studentId, teacherId, replyTitle, content1);
		if(id!=0){
			request.setAttribute("teacherId", teacherId);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//助理辅导员页面按id显示已经处理了的信息
	public String FindByIdReply(){
		
		TeacherreplyBiz teacherreplyBiz = new TeacherreplyBizImpl();
		Teacherreply teacherreply = teacherreplyBiz.findById(teacherId, teacherMessageId);
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		Teachermessage teachermessage = teachermessageBiz.findByTeacherMessageId(teacherMessageId);
		request.setAttribute("teachermessage_message", teachermessage);
		request.setAttribute("teacherreply_message", teacherreply);
		return SUCCESS;
	}
	
	//学生页面显示单个助理辅导员处理的信息
	public String StudentReply(){
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		Teachermessage teachermessage = teachermessageBiz.findByTeacherMessageId(teacherReplyId);
		request.setAttribute("teachermessage_message", teachermessage);
		TeacherreplyBiz teacherreplyBiz = new TeacherreplyBizImpl();
		Teacherreply teacherreply = teacherreplyBiz.findByIdTeacherReplyId(teacherMessageId);
		/*System.out.println(teacherReplyId);
		System.out.println(teacherMessageId);*/
		request.setAttribute("teacherreply_message", teacherreply);
		
		/*request.setAttribute("teachermessage_message", teachermessage);*/
		return SUCCESS;
	}
}
