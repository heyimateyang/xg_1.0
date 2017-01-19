package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.CollegePageBean;
import org.heyimtaeyang.dao.CollegeDao;
import org.heyimtaeyang.dao.impl.CollegeDaoImpl;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.service.CollegeService;

public class CollegeServiceImpl implements CollegeService {
	
	private CollegeDao collegeDao = new CollegeDaoImpl();

	@Override
	public CollegePageBean getPageBean(int pageSize, int page) {
		CollegePageBean gradeteacherPageBean = new CollegePageBean();
		//HQL语句
        String hql = "from College ";
        int allRows = collegeDao.getAllRowCount(hql);
        int totalPage = gradeteacherPageBean.getTotalPages(pageSize, allRows);
        int currentPage = gradeteacherPageBean.getCurPage(page);
        int offset = gradeteacherPageBean.getCurrentPageOffset(pageSize, currentPage);
        List<College> list = collegeDao.queryByPage(hql, offset, pageSize);
        gradeteacherPageBean.setList(list);
        gradeteacherPageBean.setAllRows(allRows);
        gradeteacherPageBean.setCurrentPage(currentPage);
        gradeteacherPageBean.setTotalPage(totalPage);
        return gradeteacherPageBean;
	}

}
