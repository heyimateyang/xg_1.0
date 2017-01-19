package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.TeacherreplyPageBean;

public interface TeacherreplyService {
	
	public TeacherreplyPageBean getPageBean(int pageSize, int page);
	
	public TeacherreplyPageBean getPageBean(int pageSize, int page,int studentId);
	
	public TeacherreplyPageBean getPageBeans(int pageSize, int page,int gradeteacherId);

}
