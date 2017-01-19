package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.AdminmessagePageBean;

public interface AdminmessageService {
	
	public AdminmessagePageBean getPageBean(int pageSize, int page,int studentId);
	
	//未处理分页显示信息
	public AdminmessagePageBean getPageBean(int pageSize, int page);
	
	//已处理分页显示信息
	public AdminmessagePageBean getPageBeans(int pageSize, int page);
	
	public AdminmessagePageBean getPageBeans(int pageSize, int page,int studentId);
}
