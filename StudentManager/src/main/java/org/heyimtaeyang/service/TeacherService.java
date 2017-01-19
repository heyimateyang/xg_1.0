package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.TeacherPageBean;

public interface TeacherService {
	

	/**
	 * 
	 * 重载函数
	 * @author heyimtaeyang
	*/
	
	public TeacherPageBean getPageBean(int pageSize, int page);
	
	public TeacherPageBean getPageBean(int pageSize, int page,int gradeId);
	
}
