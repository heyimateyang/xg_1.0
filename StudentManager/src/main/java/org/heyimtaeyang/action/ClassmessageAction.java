package org.heyimtaeyang.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.ClassmessagePageBean;
import org.heyimtaeyang.biz.CalculationBiz;
import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.GradeBiz;
import org.heyimtaeyang.biz.GradeteacherBiz;
import org.heyimtaeyang.biz.ProfessionBiz;
import org.heyimtaeyang.biz.TeacherBiz;
import org.heyimtaeyang.biz.impl.CalculationBizImpl;
import org.heyimtaeyang.biz.impl.ClassmessageBizImpl;
import org.heyimtaeyang.biz.impl.GradeBizImpl;
import org.heyimtaeyang.biz.impl.GradeteacherBizImpl;
import org.heyimtaeyang.biz.impl.ProfessionBizImpl;
import org.heyimtaeyang.biz.impl.TeacherBizImpl;
import org.heyimtaeyang.dao.AdminDao;
import org.heyimtaeyang.dao.ProfessionDao;
import org.heyimtaeyang.dao.impl.AdminDaoImpl;
import org.heyimtaeyang.dao.impl.ProfessionDaoImpl;
import org.heyimtaeyang.entity.Admin;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.entity.Profession;
import org.heyimtaeyang.entity.Teacher;
import org.heyimtaeyang.service.ClassmessageService;
import org.heyimtaeyang.service.impl.ClassmessageServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ClassmessageAction extends ActionSupport {
	
	public ClassmessageService classmessageService = new ClassmessageServiceImpl();
	
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
	private int gradeId;
	private int teacherId;
	private int studentId;
	private String slogan;
	private int classQqnumber;
	private String content1;
	private String classmessageGradeName;
	
	public String getClassmessageGradeName() {
		return classmessageGradeName;
	}
	public void setClassmessageGradeName(String classmessageGradeName) {
		this.classmessageGradeName = classmessageGradeName;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public int getClassQqnumber() {
		return classQqnumber;
	}
	public void setClassQqnumber(int classQqnumber) {
		this.classQqnumber = classQqnumber;
	}

	private String classmessageName;
	private int professionId;
	public String getClassmessageName() {
		return classmessageName;
	}
	public void setClassmessageName(String classmessageName) {
		this.classmessageName = classmessageName;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	private int classmessageId;
	public int getClassmessageId() {
		return classmessageId;
	}
	public void setClassmessageId(int classmessageId) {
		this.classmessageId = classmessageId;
	}
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

	//admin页面跳转班级信息
	public String clasee_MessageAdmin(){
		//按id查找辅导员
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		Gradeteacher gradeteacher = new Gradeteacher();
		gradeteacher = gradeteacherBiz.findGradeteacherByGrade(this.gradeId);
		request.setAttribute("gradeteacher_message", gradeteacher);
		//查找辅导员助理
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage classmessage = classmessageBiz.findClassmessageId(this.classmessageId);
		request.setAttribute("classmessage", classmessage);
		//计算班级总人数
		CalculationBiz calculationBiz = new CalculationBizImpl();
		List list_total = new ArrayList();
		list_total = calculationBiz.Total_Message(classmessageId);
		request.setAttribute("list_total", list_total);
		//计算男生人数
		List list_man = new ArrayList();
		list_man = calculationBiz.Total_Man(classmessageId);
		request.setAttribute("list_man", list_man);
		//计算女生人数
		List list_Girl = new ArrayList();
		list_Girl = calculationBiz.Total_Girl(classmessageId);
		request.setAttribute("list_Girl", list_Girl);
		//计算团员人数
		List list_Members = new ArrayList();
		list_Members = calculationBiz.Total_Members(classmessageId);
		request.setAttribute("list_Members", list_Members);
		//计算预备党员人数
		List list_ReservePartyMember = new ArrayList();
		list_ReservePartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
		request.setAttribute("list_ReservePartyMember", list_ReservePartyMember);
		//计算党员人数
		List list_PartyMember = new ArrayList();
		list_PartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
		request.setAttribute("list_PartyMember", list_PartyMember);
		//计算入党积极分子
		List list_PartyActivists = new ArrayList();
		list_PartyActivists = calculationBiz.Total_PartyActivists(classmessageId);
		request.setAttribute("list_PartyActivists", list_PartyActivists);
		//计算入贫困生人数
		List list_Poor = new ArrayList();
		list_Poor = calculationBiz.Total_Poor(classmessageId);
		request.setAttribute("list_Poor", list_Poor);
		return SUCCESS;
	}
	//GradeTeacher页面跳转班级信息
	public String clasee_MessageGradeTeacher(){
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		Gradeteacher gradeteacher 
			= gradeteacherBiz.findGradeteacherByGrade(gradeId);
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage classmessage = classmessageBiz.findClassmessageId(classmessageId);
		request.setAttribute("classmessage", classmessage);
		request.setAttribute("gradeteacher_message", gradeteacher);
		//计算班级总人数
				CalculationBiz calculationBiz = new CalculationBizImpl();
				List list_total = new ArrayList();
				list_total = calculationBiz.Total_Message(classmessageId);
				request.setAttribute("list_total", list_total);
				//计算男生人数
				List list_man = new ArrayList();
				list_man = calculationBiz.Total_Man(classmessageId);
				request.setAttribute("list_man", list_man);
				//计算女生人数
				List list_Girl = new ArrayList();
				list_Girl = calculationBiz.Total_Girl(classmessageId);
				request.setAttribute("list_Girl", list_Girl);
				//计算团员人数
				List list_Members = new ArrayList();
				list_Members = calculationBiz.Total_Members(classmessageId);
				request.setAttribute("list_Members", list_Members);
				//计算预备党员人数
				List list_ReservePartyMember = new ArrayList();
				list_ReservePartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
				request.setAttribute("list_ReservePartyMember", list_ReservePartyMember);
				//计算党员人数
				List list_PartyMember = new ArrayList();
				list_PartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
				request.setAttribute("list_PartyMember", list_PartyMember);
				//计算入党积极分子
				List list_PartyActivists = new ArrayList();
				list_PartyActivists = calculationBiz.Total_PartyActivists(classmessageId);
				request.setAttribute("list_PartyActivists", list_PartyActivists);
				//计算入贫困生人数
				List list_Poor = new ArrayList();
				list_Poor = calculationBiz.Total_Poor(classmessageId);
				request.setAttribute("list_Poor", list_Poor);
		return SUCCESS;
	}
	//Teacher页面跳转班级信息
	public String clasee_MessageTeacher(){
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		Gradeteacher gradeteacher 
			= gradeteacherBiz.findGradeteacherByGrade(gradeId);
		
		//查找班级老师和班级信息
		TeacherBiz teacherBiz = new TeacherBizImpl();
		Teacher teacher = teacherBiz.findTeacherByClassmessageId(this.classmessageId);
		request.setAttribute("teacher_message", teacher);
		request.setAttribute("gradeteacher_message", gradeteacher);
		
		//计算班级总人数
				CalculationBiz calculationBiz = new CalculationBizImpl();
				List list_total = new ArrayList();
				list_total = calculationBiz.Total_Message(classmessageId);
				request.setAttribute("list_total", list_total);
				//计算男生人数
				List list_man = new ArrayList();
				list_man = calculationBiz.Total_Man(classmessageId);
				request.setAttribute("list_man", list_man);
				//计算女生人数
				List list_Girl = new ArrayList();
				list_Girl = calculationBiz.Total_Girl(classmessageId);
				request.setAttribute("list_Girl", list_Girl);
				//计算团员人数
				List list_Members = new ArrayList();
				list_Members = calculationBiz.Total_Members(classmessageId);
				request.setAttribute("list_Members", list_Members);
				//计算预备党员人数
				List list_ReservePartyMember = new ArrayList();
				list_ReservePartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
				request.setAttribute("list_ReservePartyMember", list_ReservePartyMember);
				//计算党员人数
				List list_PartyMember = new ArrayList();
				list_PartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
				request.setAttribute("list_PartyMember", list_PartyMember);
				//计算入党积极分子
				List list_PartyActivists = new ArrayList();
				list_PartyActivists = calculationBiz.Total_PartyActivists(classmessageId);
				request.setAttribute("list_PartyActivists", list_PartyActivists);
				//计算入贫困生人数
				List list_Poor = new ArrayList();
				list_Poor = calculationBiz.Total_Poor(classmessageId);
				request.setAttribute("list_Poor", list_Poor);
		return SUCCESS;
	}
	
	//Student页面跳转班级信息
	public String clasee_MessageStudent(){
		
		
		//查找该学生所在班级的信息
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage classmessage = classmessageBiz.findClassmessageId(classmessageId);
		//显示全部管理员(既辅导员信息)
		AdminDao adminDao = new AdminDaoImpl();
		List<Admin> listAdmin = adminDao.showAll();
		//显示该学生负责的班级老师(既助理辅导员)
		Classmessage classmessage2 = classmessageBiz.findClassmessageId(classmessageId);
		request.setAttribute("classmessage2", classmessage2);
		request.setAttribute("listAdmin", listAdmin);
		request.setAttribute("classmessageMessage", classmessage);
		//显示辅导员
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		List<Gradeteacher> list = gradeteacherBiz.findAllGradeTeacher();
		request.setAttribute("gradeteacher_message", list);
		return SUCCESS;
	}
	
	//班级辅导员所在班级TeacherPage
	public String TeacherClassMessage(){
		try {
			
			return SUCCESS;
		} catch (Exception e) {
			
		}
		return ERROR;
	}
	
	//分页显示全部班级admin
	public String ClassmessagePageAdmin(){
		ClassmessagePageBean classmessagePageBean = classmessageService.getPageBean(10, page);
		request.setAttribute("classmessagePageBean", classmessagePageBean);
		return SUCCESS;
	}
	
	//跳转到添加班级页面
	public String addClassmessage(){
		GradeBiz gradeBiz = new GradeBizImpl();
		//显示全部年级
		List<Grade> list = gradeBiz.findAll();
		request.setAttribute("grade_list", list);
		//显示全部专业
		ProfessionDao professionDao = new ProfessionDaoImpl();
		List<Profession> lists = professionDao.findAll();
		request.setAttribute("profession_list", lists);
		return SUCCESS;
	}
	
	//添加班级信息admin
	public String addClassmessageAdmin(){
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		
		classmessageBiz.addClassmessage(classmessageName, gradeId, professionId,classmessageGradeName);
		return SUCCESS;
	}
	
	//按班级id删除班级信息admin
	public String deleteClassmessage(){
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		classmessageBiz.deleteClassmessage(classmessageId);
		return SUCCESS;
	}
	
	//显示班级详细信息admin
	public String ShowClassmessageAdmin(){
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		//按班级id查找班级信息
		Classmessage classmessage 
			= classmessageBiz.findClassmessageId(this.classmessageId);
		//遍历年级元素
		GradeBiz gradeBiz = new GradeBizImpl();
		List<Grade> listGrade = gradeBiz.findAll();
		request.setAttribute("listGrade", listGrade);
		//遍历专业元素
		ProfessionBiz professionBiz = new ProfessionBizImpl();
		List<Profession> listProfession = professionBiz.findAll();
		request.setAttribute("listProfession", listProfession);
		//载入班级信息
		request.setAttribute("classmessage_message", classmessage);
		//计算班级总人数
		CalculationBiz calculationBiz = new CalculationBizImpl();
		List list_total = new ArrayList();
		list_total = calculationBiz.Total_Message(classmessageId);
		request.setAttribute("list_total", list_total);
		//计算男生人数
		List list_man = new ArrayList();
		list_man = calculationBiz.Total_Man(classmessageId);
		request.setAttribute("list_man", list_man);
		//计算女生人数
		List list_Girl = new ArrayList();
		list_Girl = calculationBiz.Total_Girl(classmessageId);
		request.setAttribute("list_Girl", list_Girl);
		//计算团员人数
		List list_Members = new ArrayList();
		list_Members = calculationBiz.Total_Members(classmessageId);
		request.setAttribute("list_Members", list_Members);
		//计算预备党员人数
		List list_ReservePartyMember = new ArrayList();
		list_ReservePartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
		request.setAttribute("list_ReservePartyMember", list_ReservePartyMember);
		//计算党员人数
		List list_PartyMember = new ArrayList();
		list_PartyMember = calculationBiz.Total_ReservePartyMember(classmessageId);
		request.setAttribute("list_PartyMember", list_PartyMember);
		//计算入党积极分子
		List list_PartyActivists = new ArrayList();
		list_PartyActivists = calculationBiz.Total_PartyActivists(classmessageId);
		request.setAttribute("list_PartyActivists", list_PartyActivists);
		//计算入贫困生人数
		List list_Poor = new ArrayList();
		list_Poor = calculationBiz.Total_Poor(classmessageId);
		request.setAttribute("list_Poor", list_Poor);
		return SUCCESS;
	}
	
	//更新班级信息
	public String UpdateClassmessageAdmins(){
		
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		classmessageBiz.updateClassmessage(classmessageId, classmessageName, 
				gradeId, professionId, slogan, classQqnumber,content1);
		return SUCCESS;
	}
}
