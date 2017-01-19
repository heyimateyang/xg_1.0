package org.heyimtaeyang.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.AchievementPageBean;
import org.heyimtaeyang.biz.AchievementBiz;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.biz.impl.AchievementBizImpl;
import org.heyimtaeyang.biz.impl.StudentBizImpl;
import org.heyimtaeyang.entity.Achievement;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.service.AchievementService;
import org.heyimtaeyang.service.impl.AchievementServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 成绩action
 * @author heyimtaeyang
 *
 */

@SuppressWarnings("serial")
public class AchievementAction extends ActionSupport{
	
	public AchievementService achievementService = new AchievementServiceImpl();

	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//从页面接收的字段
	private int studentId;
	private int achievementId;
	private String achievementName;
	private int achievementScore;
	private int gradeId;
	private int classmessageId;
	public int getClassmessageId() {
		return classmessageId;
	}
	public void setClassmessageId(int classmessageId) {
		this.classmessageId = classmessageId;
	}

	private int teacherId;
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getAchievementName() {
		return achievementName;
	}
	public void setAchievementName(String achievementName) {
		this.achievementName = achievementName;
	}
	public int getAchievementScore() {
		return achievementScore;
	}
	public void setAchievementScore(int achievementScore) {
		this.achievementScore = achievementScore;
	}
	public int getAchievementId() {
		return achievementId;
	}
	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	//生成get set
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	//分页显示学生成绩admin
	public String StudentAchievementPage(){
		//表示每页显示5条记录，page表示当前网页
        AchievementPageBean pageBean = achievementService.getPageBean(5, page,this.studentId);
        HttpServletRequest request = ServletActionContext.getRequest();
        //request.setAttribute("studentId", studentId);
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
	}
	
	//分页显示学生成绩GradeTeacher
	public String StudentAchievementPageGradeTeacher(){
		//表示每页显示3条记录，page表示当前网页
        AchievementPageBean pageBean = achievementService.getPageBean(5, page,this.studentId);
        HttpServletRequest request = ServletActionContext.getRequest();
        //request.setAttribute("studentId", studentId);
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
	}
	
	//分页排序显示学生成绩GradeTeacher
	public String StudentGradeTeacherAchievementPage(){
		//表示每页显示3条记录，page表示当前网页
	    AchievementPageBean pageBean = achievementService.getPageBeanByGradeId(5, page, this.gradeId);
	    //request.setAttribute("studentId", studentId);
	    request.setAttribute("pageBean", pageBean);
	    return SUCCESS;
	}
	
	//分页显示学生成绩Teacher
	public String StudentTeacherAchievementPage(){
		//表示每页显示3条记录，page表示当前网页
		AchievementPageBean pageBean = achievementService.getPageBean(5, page,this.studentId);
		//request.setAttribute("studentId", studentId);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	//分页显示学生成绩Student
	public String StudentMessageAchievementPage(){
		//表示每页显示3条记录，page表示当前网页
		AchievementPageBean pageBean = achievementService.getPageBean(5, page,this.studentId);
		//request.setAttribute("studentId", studentId);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//添加学生成绩admin
	public String AddScoreAdmin(){
		AchievementBiz achievementBiz = new AchievementBizImpl();
	
		int id = achievementBiz.addAchievement(achievementName, achievementScore, studentId);
		if(id==0){
			return ERROR;
		}
		request.setAttribute("studentId", studentId);
		return SUCCESS;
	 }
	
	//按id删除学生成绩admin
	public String deleteScoreByid(){
		AchievementBiz achievementBiz = new AchievementBizImpl();
		try {
			achievementBiz.deleteAchievementById(this.achievementId);
			request.setAttribute("studentId", studentId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//模糊查询该年级辅导员的学生成绩 GradeTeacher
	public String findLikeGradeTeacher(){
		AchievementBiz achievementBiz = new AchievementBizImpl();
		StudentBiz studentBiz = new StudentBizImpl();
		List<Achievement> list = achievementBiz.findLikeAchievement(this.gradeId,achievementName);
		for(Achievement achievement:list){
			Student student = studentBiz.findStudentById(achievement.getStudent().getStudentId());
			request.setAttribute("student_Name", student);
		}
		request.setAttribute("achievement_list", list);
		return SUCCESS;
	}
	
	//查询该年级辅导员的学生成绩 Teacher
	public String findStudentScroeTeacher(){
		//表示每页显示3条记录，page表示当前网页
		AchievementPageBean pageBean = achievementService.getPageBeanByGradeId(5, page,this.gradeId,this.classmessageId);
		//request.setAttribute("studentId", studentId);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
}
