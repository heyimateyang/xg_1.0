package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.GradeteacherPageBean;
import org.heyimtaeyang.dao.GradeteacherDao;
import org.heyimtaeyang.dao.impl.GradeteacherDaoImpl;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.service.GradeteacherService;

public class GradeteacherServiceImpl implements GradeteacherService {

	private GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
	
	/**
	 * pageSize为每页显示的记录数
     * page为当前显示的网页
     * @author heyimtaeyang
     */
	
	public GradeteacherPageBean getPageBean(int pageSize, int page) {
		GradeteacherPageBean gradeteacherPageBean = new GradeteacherPageBean();
		//HQL语句
        String hql = "from Gradeteacher ";
        int allRows = gradeteacherDao.getAllRowCount(hql);
        int totalPage = gradeteacherPageBean.getTotalPages(pageSize, allRows);
        int currentPage = gradeteacherPageBean.getCurPage(page);
        int offset = gradeteacherPageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Gradeteacher> list = gradeteacherDao.queryByPage(hql, offset, pageSize);
        gradeteacherPageBean.setList(list);
        gradeteacherPageBean.setAllRows(allRows);
        gradeteacherPageBean.setCurrentPage(currentPage);
        gradeteacherPageBean.setTotalPage(totalPage);
        return gradeteacherPageBean;
	}

	@Override
	public GradeteacherPageBean getPageBean(int pageSize, int page,
			String gradeteacherName) {
		GradeteacherPageBean gradeteacherPageBean = new GradeteacherPageBean();
		//HQL语句
        String hql = "from Gradeteacher as s where s.gradeteacherName like '%"+gradeteacherName+"%'";
        int allRows = gradeteacherDao.getAllRowCount(hql);
        int totalPage = gradeteacherPageBean.getTotalPages(pageSize, allRows);
        int currentPage = gradeteacherPageBean.getCurPage(page);
        int offset = gradeteacherPageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Gradeteacher> list = gradeteacherDao.queryByPage(hql, offset, pageSize);
        gradeteacherPageBean.setList(list);
        gradeteacherPageBean.setAllRows(allRows);
        gradeteacherPageBean.setCurrentPage(currentPage);
        gradeteacherPageBean.setTotalPage(totalPage);
        return gradeteacherPageBean;
	}

}
