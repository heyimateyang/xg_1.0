package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.CollegePageBean;
import org.heyimtaeyang.biz.CollegeBiz;
import org.heyimtaeyang.biz.impl.CollegeBizImpl;
import org.heyimtaeyang.service.CollegeService;
import org.heyimtaeyang.service.impl.CollegeServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddCollegeAction extends ActionSupport {
	
	public CollegeService collegeService = new CollegeServiceImpl();
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//从页面接收字段
	private String collegeName;
	private int collegeId;
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	//生成get set
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	//添加学院
	public String addCollege(){
		CollegeBiz collegeBiz = new CollegeBizImpl();
		collegeBiz.addCollege(collegeName);
		return SUCCESS;
	}
	
	//无操作跳转到添加学院页面
	public String addCollegeIndex(){
		return SUCCESS;
	}
	
	//分页显示全部学院信息
	public String CollegePageBeanAdmin(){
		//表示每页显示5条记录，page表示当前网页
		CollegePageBean collegePageBean = collegeService.getPageBean(5, page);
		request.setAttribute("collegePageBean", collegePageBean);
		return SUCCESS;
	}
	
	//按id删除学院
	public String deleteCollege(){
		CollegeBiz collegeBiz = new CollegeBizImpl();
		collegeBiz.deleteCollegeById(collegeId);
		return SUCCESS;
	}
}
