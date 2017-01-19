package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.GradeteacherPageBean;

public interface GradeteacherService {
	
	public GradeteacherPageBean getPageBean(int pageSize, int page);
	
	public GradeteacherPageBean getPageBean(int pageSize, int page,String gradeteacherName);

}
