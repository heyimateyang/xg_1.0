package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.StudentPageBean;

public interface StudentService {
	
	/**
	 * 
	 * 重载函数
	 * @author heyimtaeyang
	*/
	
	public StudentPageBean getPageBean(int pageSize, int page);
	
	public StudentPageBean getPageBean(int pageSize, int page,String studentGradeName);
	
	public StudentPageBean getPageBeanClassmessageId(int pageSize, int page,int classmessageId);
	
	public StudentPageBean getPageBean(int pageSize, int page,int gradeId,int classmessageId);
	
	
	/*辅导员页面分页显示所属学生的信息*/
	public StudentPageBean getPageBeans(int pageSize, int page,int teacherId);
}
