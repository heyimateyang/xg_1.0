package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.AdminmessagePageBean;
import org.heyimtaeyang.dao.AdminmessageDao;
import org.heyimtaeyang.dao.impl.AdminmessageDaoImpl;
import org.heyimtaeyang.entity.Adminmessage;
import org.heyimtaeyang.service.AdminmessageService;

public class AdminmessageServiceImpl implements AdminmessageService {
	
	private AdminmessageDao adminmessageDao = new AdminmessageDaoImpl();

	@Override
	public AdminmessagePageBean getPageBean(int pageSize, int page,
			int studentId) {
		//PageBean pageBean = new PageBean();
		AdminmessagePageBean pageBean = new AdminmessagePageBean();
		//HQL语句
		String sql = "from Adminmessage where studentId= "+studentId+"and state=1"+"order by systemDate";
		int allRows = adminmessageDao.getAllRowCount(sql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Adminmessage> list = adminmessageDao.queryByPage(sql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public AdminmessagePageBean getPageBean(int pageSize, int page) {
		//PageBean pageBean = new PageBean();
		AdminmessagePageBean pageBean = new AdminmessagePageBean();
		//HQL语句
		String sql = "from Adminmessage where state= "+1;
		int allRows = adminmessageDao.getAllRowCount(sql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Adminmessage> list = adminmessageDao.queryByPage(sql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public AdminmessagePageBean getPageBeans(int pageSize, int page) {
		//PageBean pageBean = new PageBean();
		AdminmessagePageBean pageBean = new AdminmessagePageBean();
		//HQL语句
		String sql = "from Adminmessage where state= "+2;
		int allRows = adminmessageDao.getAllRowCount(sql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Adminmessage> list = adminmessageDao.queryByPage(sql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public AdminmessagePageBean getPageBeans(int pageSize, int page,
			int studentId) {
		AdminmessagePageBean pageBean = new AdminmessagePageBean();
		//HQL语句
		String sql = "from Adminmessage where studentId= "+studentId+"and state=2"+"order by systemDate";
		int allRows = adminmessageDao.getAllRowCount(sql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Adminmessage> list = adminmessageDao.queryByPage(sql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

}
