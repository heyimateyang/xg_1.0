package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.ProfessionPageBean;

public interface ProfessionService {
	
	public ProfessionPageBean getPageBean(int pageSize, int page);

}
