package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.LeaveStudentPage;
import org.heyimtaeyang.biz.LeaveStudentBiz;
import org.heyimtaeyang.biz.impl.LeaveStudentBizImpl;
import org.heyimtaeyang.entity.Leavestudent;
import org.heyimtaeyang.service.LeaveStudentService;
import org.heyimtaeyang.service.impl.LeaveStudentServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LeaveStudentAction extends ActionSupport{
	
		//全局变量
		public HttpServletRequest request 
			= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
		public HttpSession session = request.getSession();
		
		public LeaveStudentService leaveStudentService = new LeaveStudentServiceImpl();
		private LeaveStudentBiz leaveStudentBiz = new LeaveStudentBizImpl();
		
		//生成get set
		private int page;
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		
		private int id;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		//页面接收数据
		private int studentId;
		
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		
		private String leaveContent;
		private String leaveBeginTime;
		private String leaveEndTime;
		
		private int AdminId;
		
		public int getAdminId() {
			return AdminId;
		}
		public void setAdminId(int adminId) {
			AdminId = adminId;
		}

		private int leaveId;
		
		public int getLeaveId() {
			return leaveId;
		}
		public void setLeaveId(int leaveId) {
			this.leaveId = leaveId;
		}
		public String getLeaveContent() {
			return leaveContent;
		}
		public void setLeaveContent(String leaveContent) {
			this.leaveContent = leaveContent;
		}
		public String getLeaveBeginTime() {
			return leaveBeginTime;
		}
		public void setLeaveBeginTime(String leaveBeginTime) {
			this.leaveBeginTime = leaveBeginTime;
		}
		public String getLeaveEndTime() {
			return leaveEndTime;
		}
		public void setLeaveEndTime(String leaveEndTime) {
			this.leaveEndTime = leaveEndTime;
		}
		
		
		//学生页面显示请假的列表
		public String LeaveStudentListStudent(){
			
			LeaveStudentPage pageBean = leaveStudentService.getPageBean(10, page, studentId);
			request.setAttribute("pageBean", pageBean);
			session.setAttribute("deleteLeaveStudent", studentId);
	        return SUCCESS;
		}
		
		//跳转到学生申请请假页面
		public String ApplyLeaveStudent(){
			return SUCCESS;
		}
		
		//学生申请请假条
		public String AddApplyLeaveStudentandy(){
			int i = leaveStudentBiz.addLeaveStudent(studentId, leaveContent, leaveBeginTime, leaveEndTime);
			if(i!= 0){
				request.setAttribute("studentId", studentId);
				return SUCCESS;
			}
			return ERROR;
		}
		
		//学生删除
		public String deleteLeaveStudent(){
			int id = (int) request.getSession().getAttribute("deleteLeaveStudent");
			
			int i = leaveStudentBiz.deleteLeaveStudent(leaveId);
			if(i!=0){
				session.setAttribute("id", id);
				return SUCCESS;
			}
			return SUCCESS;
		}
		
		//学生页面显示请假的列表
		public String LeaveStudentListStudentAfter(){
			System.out.println(id);
			int id = (int) request.getSession().getAttribute("deleteLeaveStudent");	
			LeaveStudentPage pageBean = leaveStudentService.getPageBean(10, page, id);
			request.setAttribute("pageBean", pageBean);
			
			return SUCCESS;
		}
		
		//显示请假条
		public String showLeaveStudent(){
			Leavestudent leavestudent = leaveStudentBiz.ShowLeaveStudent(leaveId);
			if(leavestudent!=null){
				request.setAttribute("leavestudent", leavestudent);
				return SUCCESS;
			}
			return ERROR;
		}
		
		//管理员分页显示学生请假
		public String LeaveStudentListAdmin(){
			LeaveStudentPage pageBean = leaveStudentService.getPageBean(10, page);
			request.setAttribute("pageBean", pageBean);
			session.setAttribute("deleteLeaveStudent", studentId);
	        return SUCCESS;
		}
		
		//管理员删除
				public String deleteLeaveAdmin(){
					int AdminId = (int) request.getSession().getAttribute("deleteLeaveStudent");
					
					int i = leaveStudentBiz.deleteLeaveStudent(leaveId);
					if(i!=0){
						session.setAttribute("AdminId", AdminId);
						return SUCCESS;
					}
					return SUCCESS;
				}
				//学生页面显示请假的列表
				public String LeaveStudentListAdminAfter(){
				
					LeaveStudentPage pageBean = leaveStudentService.getPageBean(10, page);
					request.setAttribute("pageBean", pageBean);
					
					return SUCCESS;
				}
				
		//修改状态
		public String updateLeaveAdmin(){
			leaveStudentBiz.updateLeaveStudent(leaveId);
			return SUCCESS;
		}
		
		//显示请假条ADMIN
				public String showLeaveAdmin(){
					Leavestudent leavestudent = leaveStudentBiz.ShowLeaveStudent(leaveId);
					if(leavestudent!=null){
						request.setAttribute("leavestudent", leavestudent);
						return SUCCESS;
					}
					return ERROR;
				}

}
