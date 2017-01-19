package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.TeacherreplyPageBean;
import org.heyimtaeyang.dao.TeacherreplyDao;
import org.heyimtaeyang.dao.impl.TeacherreplyDaoImpl;
import org.heyimtaeyang.entity.Teacherreply;
import org.heyimtaeyang.service.TeacherreplyService;

public class TeacherreplyServiceImpl implements TeacherreplyService {
	
	private TeacherreplyDao teacherreplyDao = new TeacherreplyDaoImpl();

	@Override
	public TeacherreplyPageBean getPageBean(int pageSize, int page) {
		//PageBean pageBean = new PageBean();
		TeacherreplyPageBean pageBean = new TeacherreplyPageBean();
		//HQL语句
		String sql = "from Teacherreply order by replyDate";
		int allRows = teacherreplyDao.getAllRowCount(sql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Teacherreply> list = teacherreplyDao.queryByPage(sql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public TeacherreplyPageBean getPageBean(int pageSize, int page,
			int studentId) {
		//PageBean pageBean = new PageBean();
		TeacherreplyPageBean pageBean = new TeacherreplyPageBean();
		//HQL语句
		String sql = "from Teacherreply where studentId = "+studentId+" order by replyDate";
		int allRows = teacherreplyDao.getAllRowCount(sql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Teacherreply> list = teacherreplyDao.queryByPage(sql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public TeacherreplyPageBean getPageBeans(int pageSize, int page,
			int gradeteacherId) {
		//PageBean pageBean = new PageBean();
		TeacherreplyPageBean pageBean = new TeacherreplyPageBean();
		//HQL语句
		String sql = "from Teacherreply where gradeteacherId="+gradeteacherId+" order by replyDate";
		int allRows = teacherreplyDao.getAllRowCount(sql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Teacherreply> list = teacherreplyDao.queryByPage(sql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	
}
