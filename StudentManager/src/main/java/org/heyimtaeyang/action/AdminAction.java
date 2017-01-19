package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.biz.AdminBiz;
import org.heyimtaeyang.biz.impl.AdminBizImpl;
import org.heyimtaeyang.entity.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport{
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//从admin页面接收字段
	private int adminId;
	private int userId;
	private String adminName;
	private String userName;
	private String userPwd;
	private int jurisdictionId;
	private int qqnumber;
	private int phone;
	
	public int getQqnumber() {
		return qqnumber;
	}
	public void setQqnumber(int qqnumber) {
		this.qqnumber = qqnumber;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getJurisdictionId() {
		return jurisdictionId;
	}
	public void setJurisdictionId(int jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
	
	//修改管理员信息
	public String update_admin(){
		AdminBiz adminBiz = new AdminBizImpl();
		Admin admin 
			= adminBiz.updateAdmin(qqnumber,phone,this.jurisdictionId,
					this.adminId, this.userId, this.adminName, this.userName, this.userPwd);
		if(admin!=null){
			Admin admin2 = adminBiz.find_adminById(adminId);
			session.setAttribute("admin_message", admin2);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//按id查找管理员
	public String findAdminById(){
		try {
			AdminBiz adminBiz = new AdminBizImpl();
			Admin admin = adminBiz.find_adminById(this.adminId);
			session.setAttribute("admin_message", admin);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

}
