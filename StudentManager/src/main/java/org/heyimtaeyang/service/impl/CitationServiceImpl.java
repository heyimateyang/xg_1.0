package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.CitationPageBean;
import org.heyimtaeyang.dao.CitationDao;
import org.heyimtaeyang.dao.impl.CitationDaoImpl;
import org.heyimtaeyang.entity.Citation;
import org.heyimtaeyang.service.CitationService;

public class CitationServiceImpl implements CitationService {
	
	private CitationDao citationDao = new CitationDaoImpl();

	@Override
	public CitationPageBean getPageBean(int pageSize, int page, int studentId) {
		CitationPageBean pageBean = new CitationPageBean();
		String hql = "from Citation as Citation where studentId="+studentId;
		int allRows = citationDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Citation> list = citationDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

}
