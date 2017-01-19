package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.TeachermessagePageBean;

public interface TeachermessageService {
	
	public TeachermessagePageBean getPageBean(int pageSize, int page,int studentId);
	
	public TeachermessagePageBean getPageBean(int pageSize, int page);
	
	public TeachermessagePageBean getPageBeans(int pageSize, int page,int teacherId);

}
