package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.CitationPageBean;

public interface CitationService {
	
	public CitationPageBean getPageBean(int pageSize, int page,int studentId);

}
