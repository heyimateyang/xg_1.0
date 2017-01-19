package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.AchievementPageBean;
import org.heyimtaeyang.dao.AchievementDao;
import org.heyimtaeyang.dao.impl.AchievementDaoImpl;
import org.heyimtaeyang.entity.Achievement;
import org.heyimtaeyang.service.AchievementService;

public class AchievementServiceImpl implements AchievementService {

	private AchievementDao achievementDao = new AchievementDaoImpl();
	
	/**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     * @author heyimtaeyang
     */

	public AchievementPageBean getPageBean(int pageSize, int page,int studentId) {
		
		//PageBean pageBean = new PageBean();
		AchievementPageBean pageBean = new AchievementPageBean();
		//HQL语句
        String sql = "select * from achievement where studentId= "+studentId;
        int allRows = achievementDao.getAllRowCount(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Achievement> list = achievementDao.queryByPage(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

	//分页按排序显示全部学生的成绩按年级辅导员
	public AchievementPageBean getPageBeanByGradeId(int pageSize, int page,
			int gradeId) {
		AchievementPageBean pageBean = new AchievementPageBean();
		//HQL语句
		String sql = "select * from achievement,student where(student.gradeId="+gradeId+") and achievement.studentId=student.studentId";
        //String sql = "select * from achievement ,grade where gradeId="+gradeId;
        int allRows = achievementDao.getAllRowCount(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Achievement> list = achievementDao.queryByPage(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

	//分页按排序显示全部学生的成绩按班级辅导员
	public AchievementPageBean getPageBeanByGradeId(int pageSize, int page,
			int gradeId, int classmessageId) {
		AchievementPageBean pageBean = new AchievementPageBean();
		
		/*ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage classmessage = classmessageBiz.findTeacherByTeacherId(teacherId);*/
		
		//HQL语句
		String sql = "select * from achievement,student where(student.gradeId="
				+gradeId+")and student.classmessageId="+classmessageId+" and achievement.studentId=student.studentId";
        //String sql = "select * from achievement ,grade where gradeId="+gradeId;
        int allRows = achievementDao.getAllRowCount(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Achievement> list = achievementDao.queryByPage(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}
}
