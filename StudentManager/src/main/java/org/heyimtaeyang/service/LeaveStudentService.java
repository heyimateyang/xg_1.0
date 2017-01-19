package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.LeaveStudentPage;

public interface LeaveStudentService {
	
	public LeaveStudentPage getPageBean(int pageSize, int page,int studentId);
	
	public LeaveStudentPage getPageBean(int pageSize, int page);
}
