package org.heyimtaeyang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.TeacherPageBean;
import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.TeacherBiz;
import org.heyimtaeyang.biz.impl.ClassmessageBizImpl;
import org.heyimtaeyang.biz.impl.TeacherBizImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Teacher;
import org.heyimtaeyang.service.TeacherService;
import org.heyimtaeyang.service.impl.TeacherServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TeacherAction extends ActionSupport{
	
	private TeacherService teacherService = new TeacherServiceImpl();
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//生成get set
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	//从页面接收字段admin
	private int teacherId;
	private String teacherName;
	private int gradeId;
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	//分页显示班级老师admin
	public String TeacherPageAdmin(){
		//表示每页显示5条记录，page表示当前网页
		TeacherPageBean pageBean = teacherService.getPageBean(5, page);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	//模糊查询分页显示班级老师admin
	public String LikeTeacherPageAdmin(){
		TeacherBiz teacherBiz = new TeacherBizImpl();
		List<Teacher> list = teacherBiz.findLikeTeacher(teacherName);
		request.setAttribute("teacher_list", list);
		return SUCCESS;
	}
	
	//分页显示班级老师GradeTeacher
	public String GradeTeacherTeacherPage(){
		//表示每页显示5条记录，page表示当前网页
		TeacherPageBean pageBean = teacherService.getPageBean(5, page,this.gradeId);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//按id显示班级辅导员信息admin
	public String findTeacherByIds(){
		TeacherBiz teacherBiz = new TeacherBizImpl();
		Teacher teacher = teacherBiz.findTeacherById(this.teacherId);
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		List<Classmessage> list = classmessageBiz.findByteacherId(this.teacherId);
		request.setAttribute("list_classmessage", list);
		request.setAttribute("teacher_message", teacher);
		return SUCCESS;
	}
	//按id显示班级辅导员信息GradeTeacher
	public String findTeacherGradeTeacherById(){
		TeacherBiz teacherBiz = new TeacherBizImpl();
		Teacher teacher = teacherBiz.findTeacherById(this.teacherId);
		if(teacher!=null){
			request.setAttribute("teacher_message", teacher);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//按id显示班级辅导员信息TeacherIndex
	public String TeacherByid(){
		TeacherBiz teacherBiz = new TeacherBizImpl();
		Teacher teacher = teacherBiz.findTeacherById(this.teacherId);
		session.setAttribute("teacher_message", teacher);
		return SUCCESS;
	}
	
	//按id删除班级辅导员admin
	public String deleteTeacherById(){
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		classmessageBiz.updateClassmessageNull(this.teacherId);
		TeacherBiz teacherBiz = new TeacherBizImpl();
		teacherBiz.deleteTeacherById(teacherId,userId);
		return SUCCESS;
	}

}
