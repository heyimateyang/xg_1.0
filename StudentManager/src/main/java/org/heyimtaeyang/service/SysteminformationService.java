package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.SysteminformationPageBean;

public interface SysteminformationService {
	
	public SysteminformationPageBean getPageBean(int pageSize, int page);

}
