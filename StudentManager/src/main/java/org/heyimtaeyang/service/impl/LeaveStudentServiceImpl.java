package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.LeaveStudentPage;
import org.heyimtaeyang.dao.LeavestudentDao;
import org.heyimtaeyang.dao.impl.LeavestudentDaoImpl;
import org.heyimtaeyang.entity.Leavestudent;
import org.heyimtaeyang.service.LeaveStudentService;

public class LeaveStudentServiceImpl implements LeaveStudentService {
	
	private LeavestudentDao leavestudentDao = new LeavestudentDaoImpl();

	@Override
	public LeaveStudentPage getPageBean(int pageSize, int page, int studentId) {
		LeaveStudentPage pageBean = new LeaveStudentPage();
		String hql = "from Leavestudent where studentId="+studentId+"ORDER BY leaveTime";
		int allRows = leavestudentDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Leavestudent> list = leavestudentDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

	@Override
	public LeaveStudentPage getPageBean(int pageSize, int page) {
		LeaveStudentPage pageBean = new LeaveStudentPage();
		String hql = "from Leavestudent ORDER BY leaveTime";
		int allRows = leavestudentDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Leavestudent> list = leavestudentDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

}
