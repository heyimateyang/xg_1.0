package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.ReplyPageBean;

public interface ReplyService {
	
	public ReplyPageBean getPageBean(int pageSize, int page,int studentId);

}
