package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.TeachermessagePageBean;
import org.heyimtaeyang.dao.TeachermessageDao;
import org.heyimtaeyang.dao.impl.TeachermessageDaoImpl;
import org.heyimtaeyang.entity.Teachermessage;
import org.heyimtaeyang.service.TeachermessageService;

public class TeachermessageServiceImpl implements TeachermessageService {
	
	private TeachermessageDao 
		teachermessageDao = new TeachermessageDaoImpl();

	@Override
	public TeachermessagePageBean getPageBean(int pageSize, int page,
			int studentId) {
		//PageBean pageBean = new PageBean();
		TeachermessagePageBean pageBean = new TeachermessagePageBean();
		//HQL语句
        String sql = "from Teachermessage where studentId= "+studentId+"and state =1"+"order by TeacherMessageDate";
        int allRows = teachermessageDao.getAllRowCount(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Teachermessage> list = teachermessageDao.queryByPage(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

	@Override
	public TeachermessagePageBean getPageBean(int pageSize, int page) {
		TeachermessagePageBean pageBean = new TeachermessagePageBean();
		//HQL语句
        String sql = "from Teachermessage where state=1"+" order by TeacherMessageDate";
        int allRows = teachermessageDao.getAllRowCount(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Teachermessage> list = teachermessageDao.queryByPage(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

	@Override
	public TeachermessagePageBean getPageBeans(int pageSize, int page,int teacherId) {
		TeachermessagePageBean pageBean = new TeachermessagePageBean();
		//HQL语句
        String sql = "from Teachermessage where  state =1 and gradeteacherId="+teacherId+"order by TeacherMessageDate";
        int allRows = teachermessageDao.getAllRowCount(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Teachermessage> list = teachermessageDao.queryByPage(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

	

}
