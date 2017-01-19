package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.TeacherPageBean;
import org.heyimtaeyang.dao.TeacherDao;
import org.heyimtaeyang.dao.impl.TeacherDaoImpl;
import org.heyimtaeyang.entity.Teacher;
import org.heyimtaeyang.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	
	private TeacherDao teacherDao = new TeacherDaoImpl();

	@Override
	public TeacherPageBean getPageBean(int pageSize, int page) {
		TeacherPageBean pageBean = new TeacherPageBean();
		
		//HQL语句
        String hql = "from Teacher ";
        int allRows = teacherDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Teacher> list = teacherDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

	@Override
	public TeacherPageBean getPageBean(int pageSize, int page, int gradeId) {
		TeacherPageBean pageBean = new TeacherPageBean();
		
		//HQL语句
        String hql = "from Teacher as Teacher where gradeId="+gradeId;
        int allRows = teacherDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Teacher> list = teacherDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

}
