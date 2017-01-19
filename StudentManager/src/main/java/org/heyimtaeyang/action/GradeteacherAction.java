package org.heyimtaeyang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.GradeteacherPageBean;
import org.heyimtaeyang.biz.DeleteBiz;
import org.heyimtaeyang.biz.DeleteBizImpl;
import org.heyimtaeyang.biz.GradeBiz;
import org.heyimtaeyang.biz.GradeteacherBiz;
import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.biz.impl.GradeBizImpl;
import org.heyimtaeyang.biz.impl.GradeteacherBizImpl;
import org.heyimtaeyang.biz.impl.UsersBizImpl;
import org.heyimtaeyang.dao.CollegeDao;
import org.heyimtaeyang.dao.impl.CollegeDaoImpl;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.service.GradeteacherService;
import org.heyimtaeyang.service.impl.GradeteacherServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GradeteacherAction extends ActionSupport{
	
	private GradeteacherService gradeteacherService = new GradeteacherServiceImpl();
	
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
	private int gradeteacherId;
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String gradeteacherName;
	public String getGradeteacherName() {
		return gradeteacherName;
	}
	public void setGradeteacherName(String gradeteacherName) {
		this.gradeteacherName = gradeteacherName;
	}
	public int getGradeteacherId() {
		return gradeteacherId;
	}
	public void setGradeteacherId(int gradeteacherId) {
		this.gradeteacherId = gradeteacherId;
	}
	
	//分页显示年级辅导员admin
	public String GradeteacherPageAdmin(){
		//表示每页显示5条记录，page表示当前网页
	    GradeteacherPageBean gradeteacherPageBean = gradeteacherService.getPageBean(5, page);
	    HttpServletRequest request = ServletActionContext.getRequest();
	    request.setAttribute("gradeteacherBean", gradeteacherPageBean);
	    return SUCCESS;
	}
	//模糊查询显示年级辅导员admin
	public String LikeGradeteacherPageAdmin(){
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		List<Gradeteacher> list = gradeteacherBiz.findLikeGradeTeacher(gradeteacherName);
		request.setAttribute("GradeTeacher_list", list);
		return SUCCESS;
	}
	
	//按id显示年级辅导员admin
	public String finGradeteacherById(){
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		Gradeteacher gradeteacher = gradeteacherBiz.findGradeTeacher(this.gradeteacherId);
		if(gradeteacher!=null){
			request.setAttribute("gradeteacher_message", gradeteacher);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	//显示年级辅导员GradeTeacher无操作
	public String ShowGradeTeacher(){
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		Gradeteacher gradeteacher = gradeteacherBiz.findGradeTeacher(gradeteacherId);
		session.setAttribute("gradeteacher_message", gradeteacher);
		return SUCCESS;
	}
	
	//按id删除年级辅导员admin
	public String deleteGradeById(){
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		UsersBiz usersBiz = new UsersBizImpl();
		DeleteBiz deleteBiz = new DeleteBizImpl();
		deleteBiz.deleteTeachermessage(gradeteacherId);
		deleteBiz.deleteTeacherReplymessage(gradeteacherId);
		usersBiz.deleteUsersById(userId);
		gradeteacherBiz.deleteGradeteacherById(gradeteacherId);
		return SUCCESS;
	}
	
	//跳转到添加年级辅导员页面admin
	public String addGradeTeacher(){
		GradeBiz gradeBiz = new GradeBizImpl();
		CollegeDao collegeDao = new CollegeDaoImpl();
		List<College> lists = collegeDao.findAll();
		List<Grade> list = gradeBiz.findAll();
		request.setAttribute("list_grade", list);
		request.setAttribute("list_college", lists);
		return SUCCESS;
	}
	
	//无操作跳转到更新年级辅导员
	public String updateGradeTeacher(){
		
		return SUCCESS;
	}
}
