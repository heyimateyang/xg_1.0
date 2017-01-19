package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.StudentPageBean;
import org.heyimtaeyang.dao.StudentDao;
import org.heyimtaeyang.dao.impl.StudentDaoImpl;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = new StudentDaoImpl();
	
	
	/**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     * @author heyimtaeyang
     */

	public StudentPageBean getPageBean(int pageSize, int page) {
		StudentPageBean pageBean = new StudentPageBean();
		
		//HQL语句
        String hql = "from Student ORDER BY gradeId ,studentNumber DESC";
        int allRows = studentDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Student> list = studentDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}


	@Override
	public StudentPageBean getPageBean(int pageSize, int page, String studentGradeName) {
		String hql = "from Student ORDER where studentGradeName="+"'"+studentGradeName+"'";
		StudentPageBean pageBean = new StudentPageBean();
		int allRows = studentDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Student> list = studentDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}


	@Override
	public StudentPageBean getPageBean(int pageSize, int page, int gradeId,
			int classmessageId) {
		
		//按teacherId查找该老师的班级
		//ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		//Classmessage classmessage = classmessageBiz.findTeacherByTeacherId(teacherId);
		
		
		String hql = "from Student as Student where gradeId="+gradeId+"and classmessageId="+classmessageId;
		StudentPageBean pageBean = new StudentPageBean();
		int allRows = studentDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Student> list = studentDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}


	@Override
	public StudentPageBean getPageBeans(int pageSize, int page, int teacherId) {
		
		String sql = "select * from Student,Classmessage where Student.classmessageId = Classmessage.classmessageId AND Classmessage.teacherId="+teacherId;
		StudentPageBean pageBean = new StudentPageBean();
		int allRows = studentDao.getAllRowCounts(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Student> list = studentDao.queryByPages(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}


	@Override
	public StudentPageBean getPageBeanClassmessageId(int pageSize, int page,
			int classmessageId) {
		String hql = "from Student ORDER where classmessageId="+classmessageId;
		StudentPageBean pageBean = new StudentPageBean();
		int allRows = studentDao.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Student> list = studentDao.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

}
