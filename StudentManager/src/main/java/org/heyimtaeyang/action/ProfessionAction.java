package org.heyimtaeyang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.ProfessionPageBean;
import org.heyimtaeyang.biz.ProfessionBiz;
import org.heyimtaeyang.biz.impl.ProfessionBizImpl;
import org.heyimtaeyang.dao.CollegeDao;
import org.heyimtaeyang.dao.impl.CollegeDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.service.ProfessionService;
import org.heyimtaeyang.service.impl.ProfessionServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ProfessionAction extends ActionSupport{
	
	public ProfessionService professionService = new ProfessionServiceImpl();
	
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
	
	//从页面接收的字段
	private String professionName;
	private int collegeId;
	private int professionId;
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	
	//跳转到添加专业页面admin
	public String addProfessionIndex(){
		CollegeDao collegeDao = new CollegeDaoImpl();
		List<College> list = collegeDao.findAll();
		request.setAttribute("college_list", list);
		return SUCCESS;
	}
	
	//添加专业admin
	public String addProfession(){
		ProfessionBiz professionBiz = new ProfessionBizImpl();
		professionBiz.addProfession(professionName, collegeId);
		return SUCCESS;
	}
	
	//分页显示全部专业admin
	public String ProfessionPageAdmin(){
		ProfessionPageBean professionPageBean = professionService.getPageBean(5, page);
		request.setAttribute("professionPageBean", professionPageBean);
		return SUCCESS;
	}
	
	//按id删除专业admin
	public String deleteProfessionById(){
		ProfessionBiz professionBiz = new ProfessionBizImpl();
		professionBiz.deleteProfession(professionId);
		return SUCCESS;
	}
	
	//按专业id查找班级
	public String ProfessionIdByClassmessage(){
		ProfessionBiz professionBiz = new ProfessionBizImpl();
		List<Classmessage> list = professionBiz.findProfession(this.professionId);
		request.setAttribute("list_message", list);
		return SUCCESS;
	}
}
