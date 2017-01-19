package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.ClassmessagePageBean;
import org.heyimtaeyang.dao.ClassmessageDao;
import org.heyimtaeyang.dao.impl.ClassmessageDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.service.ClassmessageService;

public class ClassmessageServiceImpl implements ClassmessageService {
	
	private ClassmessageDao classmessageDao = new ClassmessageDaoImpl();

	@Override
	public ClassmessagePageBean getPageBean(int pageSize, int page) {
		ClassmessagePageBean classmessagePageBean = new ClassmessagePageBean();
		//HQL语句
        String hql = "from Classmessage ORDER BY gradeId";
        int allRows = classmessageDao.getAllRowCount(hql);
        int totalPage = classmessagePageBean.getTotalPages(pageSize, allRows);
        int currentPage = classmessagePageBean.getCurPage(page);
        int offset = classmessagePageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Classmessage> list = classmessageDao.queryByPage(hql, offset, pageSize);
        classmessagePageBean.setList(list);
        classmessagePageBean.setAllRows(allRows);
        classmessagePageBean.setCurrentPage(currentPage);
        classmessagePageBean.setTotalPage(totalPage);
        return classmessagePageBean;
	}

}
