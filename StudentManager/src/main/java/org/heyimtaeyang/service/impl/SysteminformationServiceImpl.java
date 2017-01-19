package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.SysteminformationPageBean;
import org.heyimtaeyang.dao.SysteminformationDao;
import org.heyimtaeyang.dao.impl.SysteminformationDaoImpl;
import org.heyimtaeyang.entity.Systeminformation;
import org.heyimtaeyang.service.SysteminformationService;

public class SysteminformationServiceImpl implements SysteminformationService {

	private SysteminformationDao 
		systeminformationDao = new SysteminformationDaoImpl();
	
	@Override
	public SysteminformationPageBean getPageBean(int pageSize, int page) {
		SysteminformationPageBean 
			getPageBean = new SysteminformationPageBean();
		
		String hql = "from Systeminformation order by informationDate";
        int allRows = systeminformationDao.getAllRowCount(hql);
        int totalPage = getPageBean.getTotalPages(pageSize, allRows);
        int currentPage = getPageBean.getCurPage(page);
        int offset = getPageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Systeminformation> list = systeminformationDao.queryByPage(hql, offset, pageSize);
        getPageBean.setList(list);
        getPageBean.setAllRows(allRows);
        getPageBean.setCurrentPage(currentPage);
        getPageBean.setTotalPage(totalPage);
        return getPageBean;
	}

}
