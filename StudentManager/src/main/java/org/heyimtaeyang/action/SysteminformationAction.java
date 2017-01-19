package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.SysteminformationPageBean;
import org.heyimtaeyang.biz.SysteminformationBiz;
import org.heyimtaeyang.biz.impl.SysteminformationBizImpl;
import org.heyimtaeyang.entity.Systeminformation;
import org.heyimtaeyang.service.SysteminformationService;
import org.heyimtaeyang.service.impl.SysteminformationServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SysteminformationAction extends ActionSupport{
	
	private SysteminformationService 
		systeminformationService = new SysteminformationServiceImpl();
	
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

	//页面获取数据
	private String content1;
	private String informationTitle;
	private int informationId;
	
	public int getInformationId() {
		return informationId;
	}

	public void setInformationId(int informationId) {
		this.informationId = informationId;
	}

	public String getInformationTitle() {
		return informationTitle;
	}

	public void setInformationTitle(String informationTitle) {
		this.informationTitle = informationTitle;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	//添加系统公告admin
	public String Add_Systeminformation(){
		SysteminformationBiz systeminformationBiz = new SysteminformationBizImpl();
		try {
			int id = systeminformationBiz.add_SysteminformationBiz(this.informationTitle, content1);
			if(id == 1){
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//分页显示系统公告sutdent
	public String showPageSysteminformationStudent(){
		SysteminformationPageBean systeminformationPageBean 
			= systeminformationService.getPageBean(5, page);
		request.setAttribute("pageBean", systeminformationPageBean);
		return SUCCESS;
	}
	
	//分页显示系统公告Teacher
	public String showPageSysteminformationTeacher(){
		SysteminformationPageBean systeminformationPageBean 
			= systeminformationService.getPageBean(5, page);
		request.setAttribute("pageBean", systeminformationPageBean);
		return SUCCESS;
	}
	
	
	//分页显示系统公告admin
	public String showPageSysteminformationAdmin(){
		SysteminformationPageBean systeminformationPageBean 
			= systeminformationService.getPageBean(10, page);
		request.setAttribute("pageBean", systeminformationPageBean);
		return SUCCESS;
	}
	
	//分页显示系统公告GradeTeacher
	public String showPageSysteminformationGradeTeacher(){
		SysteminformationPageBean systeminformationPageBean 
			= systeminformationService.getPageBean(10, page);
		request.setAttribute("pageBean", systeminformationPageBean);
		return SUCCESS;
	}
	
	//按id显示系统公告GradeTeacher
	public String showSysteminformationByIdGradeTeacher(){
		SysteminformationBiz 
			systeminformationBiz = new SysteminformationBizImpl();
		Systeminformation systeminformation 
			= systeminformationBiz.FindSysteminformationById(informationId);
		if(systeminformation!=null){
			request.setAttribute("systeminformationMessage", systeminformation);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//按id显示系统公告admin
	public String showSysteminformationByIdAdmin(){
		SysteminformationBiz 
			systeminformationBiz = new SysteminformationBizImpl();
		Systeminformation systeminformation 
			= systeminformationBiz.FindSysteminformationById(informationId);
		if(systeminformation!=null){
			request.setAttribute("systeminformationMessage", systeminformation);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//按id显示系统公告admin
	public String showSysteminformationByIdTeacher(){
		SysteminformationBiz 
			systeminformationBiz = new SysteminformationBizImpl();
		Systeminformation systeminformation 
			= systeminformationBiz.FindSysteminformationById(informationId);
		if(systeminformation!=null){
			request.setAttribute("systeminformationMessage", systeminformation);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//按id显示系统公告Student
	public String showSysteminformationByIdStudent(){
		SysteminformationBiz 
			systeminformationBiz = new SysteminformationBizImpl();
		Systeminformation systeminformation 
			= systeminformationBiz.FindSysteminformationById(this.informationId);
		if(systeminformation!=null){
			request.setAttribute("systeminformationMessageStudent", systeminformation);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//无操作跳转到发布公告admin
	public String SendMessage_Admin(){
		return SUCCESS;
	}
	
	//删除系统公告admin
	public String deleteBySysteminformation(){
		SysteminformationBiz 
			systeminformationBiz = new SysteminformationBizImpl();
		int id = systeminformationBiz.deleteSysteminformationByid(informationId);
		if(id == 1){
			return SUCCESS;
		}
		return ERROR;
	}

}
