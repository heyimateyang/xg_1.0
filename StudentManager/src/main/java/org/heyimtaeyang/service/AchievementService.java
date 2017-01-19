package org.heyimtaeyang.service;

import org.heyimtaeyang.bean.AchievementPageBean;

public interface AchievementService {
	
	public AchievementPageBean getPageBean(int pageSize, int page,int studentId);
	
	/**
	 * 重载函数模糊查询
	 * @param pageSize
	 * @param page
	 * @param studentId
	 * @param achievementName
	 * @return
	 */
	
	//分页按排序显示全部学生的成绩
	public AchievementPageBean getPageBeanByGradeId(int pageSize, int page,int gradeId);
	
	public AchievementPageBean getPageBeanByGradeId(int pageSize, int page,int gradeId,int classmessageId);

}
